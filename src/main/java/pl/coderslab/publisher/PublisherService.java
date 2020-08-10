package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.author.Author;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class PublisherService {
    private final PublisherDao publisherDao;

    public void savePublisher(Publisher publisher) {
        publisherDao.save(publisher);
    }

    public Publisher findById(long id) {
        return publisherDao.findById(id);
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void delete(Publisher publisher) {
        publisherDao.delete(publisher);
    }
}
