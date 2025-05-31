package myservice.service;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class SearchController {

    @QueryMapping
    String search(@Argument String pattern, @Argument int limit) {
        // Your search logic here
        return "Search results for '" + pattern + "' with limit " + limit;
    }
    @QueryMapping
    String searchInput(@Argument SearchInput searchInput, DataFetchingEnvironment env) {
        // Default limit is 10
        Map<String, Object> input = env.getArgument("searchInput");
        return "SearchInput results for '" + searchInput.pattern()
                + "' with limit " + searchInput.limit();
    }
}
