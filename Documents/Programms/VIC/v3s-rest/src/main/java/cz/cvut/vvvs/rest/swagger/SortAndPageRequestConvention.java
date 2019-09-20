package cz.cvut.vvvs.rest.swagger;

import com.fasterxml.classmate.TypeResolver;
import cz.cvut.vic.repository.PageRequest;
import cz.cvut.vic.repository.Sort;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * Replace Sort and PageRequest classes in Swagger documentation
 * <p>
 * See https://springfox.github.io/springfox/docs/current/#creating-a-convention
 */
public class SortAndPageRequestConvention implements AlternateTypeRuleConvention {
    private TypeResolver typeResolver;

    public SortAndPageRequestConvention(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Override
    public List<AlternateTypeRule> rules() {
        ArrayList<AlternateTypeRule> rules = new ArrayList<>();
        rules.add(
                newRule(
                        typeResolver.resolve(Sort.class),
                        typeResolver.resolve(SwaggerSort.class)));
        rules.add(
                newRule(
                        typeResolver.resolve(PageRequest.class),
                        typeResolver.resolve(SwaggerPageRequest.class)));
        return rules;
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

    public class SwaggerSort {
        @ApiModelProperty("Comma separated property names. Use suffix '-' or optional '+' to explicitly declare property order direction. E.g. 'id-,name'")
        public String sort;
    }

    public class SwaggerPageRequest extends SwaggerSort {
        @ApiModelProperty(value = "Value from range [1, infinity]", allowableValues = "range[1, infinity]", example = "10")
        public Integer size;
        @ApiModelProperty(value = "Value from range [0, infinity]", allowableValues = "range[0, infinity]", example = "0")
        public Integer page;
    }
}