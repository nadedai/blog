package com.hhtt.blog.util;
import lombok.extern.slf4j.Slf4j;
import org.commonmark.parser.Parser;
import org.commonmark.node.*;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhtt
 * @date 2020/5/22 14:20
 * description:
 */
@Slf4j
public class MarkdownUtils {
    public static String markdownToHtml(String markdown){
        Parser parser = Parser.builder().build();
        Node doc = parser.parse(markdown);

        HtmlRenderer renderer = HtmlRenderer.builder().attributeProviderFactory(new AttributeProviderFactory() {
            public AttributeProvider create(AttributeProviderContext context) {
                return new CustomAttributeProvider();
            }
        }).build();
        return renderer.render(doc);
    }

    public static class CustomAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            if (node instanceof Image) {
                String style = "display: block;margin: 0 auto;";
                Map<String, String> attrs = getAttr(attributes.get("src"));
                if(attrs == null){
                    attributes.put("style", "display: block;margin: 0 auto;width:100%;height:100%;");
                    return;
                }
                if(attrs.get("w")!=null){
                    //设置宽度 value(100%,100px） ->
                    style += setAttr(attrs.get("w"),"width");
                }
                else{
                    style += "width:100%;";
                }
                if(attrs.get("h")!=null){
                    //设置宽度
                    style += setAttr(attrs.get("h"),"height");
                }
                else{
                    style += "height:100%;";
                }
                attributes.put("style", style);
            }
        }
    }

    private static String setAttr(String value,String attr){
        String res;
        if(value.contains("%")){
            res = attr +":"+ value;
        }
        else {
            res = attr +":"+ value + "px";
        }
        return  res+";";
    }

    private static Map<String, String> getAttr(String content){
        if(content==null) return null;
        Map<String, String> attrMap = new HashMap<>();
        String _content = content.substring(content.lastIndexOf('?')+1);
        if(content.equals(_content)){
            return null;
        }
        //abc=xxx
        String[] attrs = _content.split("&");
        for(String map : attrs){
            String[] split = map.split("=");
            attrMap.put(split[0],split[1]);
        }
        return attrMap;
    }

}
