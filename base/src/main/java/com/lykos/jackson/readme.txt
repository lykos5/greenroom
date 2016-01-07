jackson有关数据操作

--------------------------------jackson--------------------
JsonUtil  对象,json字符串之间转换
XmlUtil   对象,xml字符串,json之间转换
   注意如果xml 格式需要<items><item></item></items>那obj属性可以先配制一个map,如：
   @JsonProperty("items")
       private Map items;
   然后用  map.put(“item”,list);

   xml转json转Map   依赖：json-lib  xom
   XMLSerializer xmlSerializer = new XMLSerializer();
   JSON json = xmlSerializer.read(res);
   ObjectMapper mapper = new ObjectMapper();
   Map<String, Object> jsonInMap = mapper.readValue(json.toString(1),
                       new TypeReference<Map<String, Object>>() {
                       });