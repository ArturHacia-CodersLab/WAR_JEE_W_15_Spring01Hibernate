package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherService publisherService;

    @Override
    public Publisher convert(String id) {
        return publisherService.findById(Integer.parseInt(id));
    }
}
