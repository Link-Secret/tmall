package tmall.servlet;

import tmall.bean.Category;
import tmall.dao.CategoryDAO;
import tmall.dao.ProductDAO;
import tmall.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ForeServlet extends BaseForeServlet {

    public String home(HttpServletRequest request,HttpServletResponse response,Page page) {
        /*获取所有17种分类*/
        List<Category> cs = new CategoryDAO().list();
        /*为这些分类填充产品集合，即为每个Category对象，设置products属性*/
        new ProductDAO().fill(cs);
        /*为这些分类填充推荐产品集合，即为每个Category对象，设置productsByRow属性*/
        new ProductDAO().fillByRow(cs);
        /*把分类集合设置在request的"cs"属性上*/
        request.setAttribute("cs",cs);
        /*服务器端跳转*/
        return "home.jsp";
    }

}