package service.lmpl;

import bean.Basket;
import org.springframework.stereotype.Service;
import repository.BasketRepository;
import repository.BookRepository;
import service.BasketService;

import java.util.List;

import static java.awt.Container.log;

@Service
public class BasketServiceImpl implements BasketService {

    final
    BookRepository bookRepository;
    final
    BasketRepository basketRepository;

    public BasketServiceImpl(BookRepository bookRepository, BasketRepository basketRepository) {
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
    }

    @Override
    public List<Basket> getAllBasket() {
        return basketRepository.findAll();
    }

    @Override
    public void deleteBasket(Long id) {
        Basket basket =   basketRepository.getOne(id);
        basketRepository.delete(basket);
        log.info("basket delete " + basket);

    }

    @Override
    public Basket addBookInBasket(Basket basket) {
        log.info("book add in basket " + basket);
        return basketRepository.save(basket);

    }

    @Override
    public Basket getBasket(Long id) {
        return basketRepository.getOne(id);
    }

}
