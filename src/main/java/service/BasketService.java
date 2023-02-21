package service;
import bean.Basket;
import java.util.List;



    public interface BasketService {
        public List<Basket> getAllBasket();
        public void deleteBasket(Long id);
        public Basket addBookInBasket(Basket basket);
        public Basket getBasket(Long id);
    }

