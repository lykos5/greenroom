package com.lykos.excel;

/**
 *
 * asposeCell 操作excell 方法
 * Created by Lykos on 16/1/28.
 */
public class AsposeCellUtil {
//
//    //存放Excel模板的位置
//    private static final String TEMPLATE_FILE_PATH_PART = "../../../resources/a.xlsx";
//
//    /**
//     * 根据文件输入流获得excle，默认读取第一个sheet，并默认表头为第一行
//     *
//     * @param stream
//     * @return
//     * @throws Exception
//     */
//    public static List getExcelData(InputStream stream) throws Exception {
//        return getExcelData(stream, "");
//    }
//
//    /**
//     * 根据文件输入流获得excle，默认表头为第一行
//     *
//     * @param stream
//     * @param sheetName sheet页名
//     * @return
//     * @throws Exception
//     */
//    public static List getExcelData(InputStream stream, String sheetName) throws Exception {
//        return getExcelData(stream, sheetName, 1);
//    }
//
//    /**
//     * 根据文件输入流获得excle
//     *
//     * @param stream
//     * @param sheetName  sheet页名
//     * @param titleIndex 表头所在行数
//     * @return
//     * @throws Exception
//     */
//    public static List getExcelData(InputStream stream, String sheetName, int titleIndex) throws Exception {
//        Workbook workbook = new Workbook(stream);//工作簿
//        return getExcelData(workbook, sheetName, titleIndex);
//    }
//
//    /**
//     * 根据文件地址获得excle，默认读取第一个sheet，并默认表头为第一行
//     *
//     * @param file
//     * @return
//     * @throws Exception
//     */
//    public static List getExcelData(String file) throws Exception {
//        return getExcelData(file, "");
//    }
//
//    /**
//     * 根据文件地址获得excle，默认表头为第一行
//     *
//     * @param file
//     * @param sheetName
//     * @return
//     * @throws Exception
//     */
//    public static List getExcelData(String file, String sheetName) throws Exception {
//        return getExcelData(file, sheetName, 1);
//    }
//
//    /**
//     * 根据文件地址获得excle
//     *
//     * @param file
//     * @param sheetName  sheet页名
//     * @param titleIndex 表头所在行数
//     * @return
//     * @throws Exception
//     */
//    public static List getExcelData(String file, String sheetName, int titleIndex) throws Exception {
//        Workbook workbook = new Workbook(file);//工作簿
//        return getExcelData(workbook, sheetName, titleIndex);
//    }
//
//    /**
//     * 根据Workbook取对应的sheet页，组合成List<Map>的格式传出去，Map的key是表头，value是内容
//     *
//     * @param workbook
//     * @param sheetName  sheet页名
//     * @param titleIndex 表头所在行数
//     * @return
//     * @throws Exception
//     */
//    private static List getExcelData(Workbook workbook, String sheetName, int titleIndex) throws Exception {
//        Worksheet worksheet = StringUtils.isBlank(sheetName) ? workbook.getWorksheets().get(0) : workbook.getWorksheets().get(sheetName);//获取Sheet页
//        if (null == workbook || null == worksheet.getCells()) {
//            return null;
//        }
//        Cells cells = worksheet.getCells();
//        int columns = cells.getMaxDataColumn();
//        int rows = cells.getMaxDataRow();
//        List list = new ArrayList();
//        //获取表头
//        List mapKeyList = new ArrayList();
//        for (int c = 0; c <= columns; c++) {
//            String columnValue = cells.get(titleIndex - 1, c).getStringValue();
//            mapKeyList.add(columnValue);
//        }
//        for (int r = titleIndex; r <= rows; r++) {
//            Map map = new HashMap();
//            for (int c = 0; c <= columns; c++) {
//                String columnValue = cells.get(r, c).getStringValue();
//                map.put(mapKeyList.get(c), columnValue);
//            }
//            list.add(map);
//        }
//        return list;
//    }
//
//    public Workbook exportExcel(String template_file_path, Map map) throws Exception {
//        Workbook wb = new Workbook(template_file_path);
//        Map<String, String> resultMap = new HashMap<String, String>();
//        WorkbookDesigner designer = new WorkbookDesigner();
//        designer.setWorkbook(wb);
//        // designer.setDataSource("Person", person);
//        designer.process(true);
//        return wb;
//    }
//
//
//    public static Workbook createReport(HttpServletRequest request, List list) throws Exception {
//        //创建工作薄加载模板(SmartMarkerDesigner.xls)
//        Workbook wb = new Workbook("E:\\a.xlsx");
//        createSmart(wb, list);
//        return wb;
//    }
//
//    private static void createSmart(Workbook wb, List list) throws Exception {
//        WorkbookDesigner designer = new WorkbookDesigner();
//        designer.setWorkbook(wb);
//        designer.setDataSource("Book", list);
//        //designer.setDataSource("Map", new HashMapDataTable(InitData.getHashMap()));
//        designer.process(true);
//    }
//
//
//    /**
//     * 设置HTTP响应头
//     *
//     * @param response
//     * @param fileName
//     * @param formatSuffix
//     */
//    public static void setResponseHeader(HttpServletResponse response, String fileName, String formatSuffix) {
//        String contentType = "application/vnd.ms-excel";
//        formatSuffix = formatSuffix.toLowerCase();
//        if (formatSuffix.endsWith(".xlsx")
//                || formatSuffix.endsWith(".xls")
//                || formatSuffix.endsWith(".xlsb")
//                || formatSuffix.endsWith(".xlsm")
//                || formatSuffix.endsWith(".xltm")
//                || formatSuffix.endsWith(".xltx")) {
//            contentType = "application/vnd.ms-excel";
//            //"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//        }
//        response.setContentType(contentType);
//        response.addHeader("content-disposition", "attachment;filename=" + fileName + ";filename*=UTF-8''" + fileName);
////        2010年 RFC 5987 发布，正式规定了 HTTP Header 中多语言编码的处理方式，应当采用类似 MIME 扩展的 parameter*=charset'lang'value 的格式，
////        但是其中 value 应根据 RFC 3986 Section 2.1 使用百分号进行编码，并且规定浏览器至少应该支持 ASCII 和 UTF-8 。
////        随后，2011年 RFC 6266 发布，正式将 Content-Disposition 纳入 HTTP 标准，并再次强调了 RFC 5987 中多语言编码的方法，
////        还给出了一个范例用于解决向后兼容的问题——就是我在一开始给出的例子：
////        Content-Disposition: attachment;
////        filename="encoded_text";
////        filename*=utf-8''encoded_text
////        在这个例子中，对于较新的 Firefox 、 Chrome 、 Opera 、 Safari 等浏览器，都支持新标准规定的 filename* ，
////        并且会优先使用，所以尽管 filename=”encoded_text” 不被它们支持，仍然不会有问题；至于使用 UTF-8 只是因为它是标准中强制要求必须支持的。
////        而对于旧版本的IE浏览器，它们无法识别后面的 filename* ，会自动忽略并使用旧的 filename 。这样一来就完美解决了多浏览器的多语言兼容问题，
////        既不需要 UA 判断，也符合标准。
//    }
//
//
//    /**
//     * 向客户端返回excel
//     *
//     * @param request
//     * @param response
//     * @param wb
//     * @throws Exception
//     */
//    public static void sendReport(HttpServletRequest request,
//                                  HttpServletResponse response, Workbook wb) throws Exception {
//        wb.save(response.getOutputStream(), wb.getFileFormat());
//    }
}
