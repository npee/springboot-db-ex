package io.npee.itemservice.config;

import io.npee.itemservice.repository.ItemRepository;
import io.npee.itemservice.repository.jdbctempate.JdbcTemplateItemRepositoryV3;
import io.npee.itemservice.repository.mybatis.ItemMapper;
import io.npee.itemservice.repository.mybatis.MyBatisItemRepository;
import io.npee.itemservice.service.ItemService;
import io.npee.itemservice.service.ItemServiceV1;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final ItemMapper itemMapper;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }

}
