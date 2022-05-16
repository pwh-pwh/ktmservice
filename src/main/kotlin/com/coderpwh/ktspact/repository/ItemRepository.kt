package com.coderpwh.ktspact.repository

import com.coderpwh.ktspact.entry.Item
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository


/**
 * @author coderpwh
 * @date 2022/5/16 6:00 PM
 */
interface ItemRepository:ElasticsearchRepository<Item,Long>