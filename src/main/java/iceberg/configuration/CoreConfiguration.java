package iceberg.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Configuration Rest
 *
 * @author
 */
@Configuration
public class CoreConfiguration {

    /**
     * Rest template config
     *
     * @return the configured rest template
     */
    @Bean
    @Qualifier("iceberg.restTemplate")
    public RestTemplate restTemplate() {
        List<HttpMessageConverter<?>> messageConverterList = new ArrayList<>();
        messageConverterList.add(new StringHttpMessageConverter());
        messageConverterList.add(new MappingJackson2HttpMessageConverter());
        messageConverterList.add(new FormHttpMessageConverter());
        messageConverterList.add(new Jaxb2RootElementHttpMessageConverter());
        messageConverterList.add(new ByteArrayHttpMessageConverter());
        return new RestTemplate(messageConverterList);
    }

    /**
     * JdbcTemplate supportant les paramètres nommées.
     */
    @Bean
    public NamedParameterJdbcTemplate jdbcNamedTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
