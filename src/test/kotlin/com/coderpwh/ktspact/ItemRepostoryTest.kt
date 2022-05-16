package com.coderpwh.ktspact

import com.coderpwh.ktspact.entry.Item
import com.coderpwh.ktspact.repository.ItemRepository
import org.elasticsearch.index.query.QueryBuilders
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder


/**
 * @author coderpwh
 * @date 2022/5/16 6:02 PM
 */
@SpringBootTest
class ItemRepostoryTest {
    @Autowired
    lateinit var itemRepository: ItemRepository
    @Autowired
    lateinit var elasticsearchRestTemplate: ElasticsearchRestTemplate
    @Test
    fun `test create index`() {
        var delete = elasticsearchRestTemplate.indexOps(Item::class.java).delete()
        println("${delete}")
        var indexOps = elasticsearchRestTemplate.indexOps(Item::class.java)
        indexOps.create()
        indexOps.createMapping()
    }
    @Test
    fun `test add item to es`() {
        var item = Item(12L, "apple phone", "gbao", "libai", 99.99, "aaa.png")
        itemRepository.save(item)
    }
    @Test
    fun `test add all`() {
        var item = Item(1L, "title", "gbao", "libai", 99.99, "aaa.png")
        var listOf = listOf<Item>(
            item.copy(id = 2L, title = "apple phone", price = 20.0),
            item.copy(id = 3L, title = "number", price = 110.0),
            item.copy(id = 5L, title = "wot", price = 120.0),
            item.copy(id = 6L, title = "idea", price = 20.0),
            item.copy(id = 7L, title = "pwh", price = 20.0),
            item.copy(id = 8L, title = "coder", price = 20.0)
        )
        itemRepository.saveAll(listOf)
    }

    @Test
    fun `test find all`() {
        itemRepository.findAll().forEach {
            println(it)
        }
    }
    @Test
    fun `test match query title contains apple and phone`() {
        var builder = NativeSearchQueryBuilder()
        //先分词再查询
        builder.withQuery(QueryBuilders.matchQuery("title","apple phone"))
        var search = elasticsearchRestTemplate.search(builder.build(), Item::class.java)
        search.forEach {
            println(it)
        }
    }

    @Test
    fun `test term query title contains apple and phone`() {
        var builder = NativeSearchQueryBuilder()
        //先分词再查询
        builder.withQuery(QueryBuilders.termQuery("title","apple"))
        var search = elasticsearchRestTemplate.search(builder.build(), Item::class.java)
        search.forEach {
            println(it)
        }
    }


}