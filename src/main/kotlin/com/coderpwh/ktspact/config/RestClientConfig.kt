package com.coderpwh.ktspact.config


import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate


/**
 * @author coderpwh
 * @date 2022/5/16 7:20 PM
 */
@Configuration
class RestClientConfig : AbstractElasticsearchConfiguration() {
    @Value("\${es.url}")
    lateinit var hostAndPort:String
    @Bean
    override fun elasticsearchClient(): RestHighLevelClient{
        var configuration = ClientConfiguration.create(hostAndPort)
        return RestClients.create(configuration).rest()
    }
    @Bean
    fun elasticsearchRestTemplate(elasticsearchClient:RestHighLevelClient): ElasticsearchRestTemplate {
        println("et create")
        return ElasticsearchRestTemplate(elasticsearchClient)
    }

}