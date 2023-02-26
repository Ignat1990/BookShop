package service;
import bean.Basket;
import java.util.List;



    public interface BasketService {
         List<Basket> findAll();
       public void delete(Long id);
        public Basket save(Basket basket);
        public Basket find(Long id);
    }

