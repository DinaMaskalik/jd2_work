package it.academy.servlet;

import it.academy.model.SearchDto;
import it.academy.model.ResultDto;
import it.academy.service.SearchProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "search", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private  final SearchParamsBinder searchParamsBinder = new SearchParamsBinder();
    private SearchProcessor searchProcessor =  new SearchProcessor();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Validate request params (validation)

        //Parse request params to search model(building)
        SearchDto searchDto = searchParamsBinder.bind(req);

        //Call search service and pass search model, return result model(processing)
        ResultDto resultDto = searchProcessor.search(searchDto);


        //Add result model to request scope present result model on view (result.jsp)


        req.setAttribute("result", resultDto);
        req.setAttribute("terms", searchDto.getTerms());
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
