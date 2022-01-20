package it.achtelik.javaspringtemplate.modules.messages.dataproviders.mongo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MessageRepository extends ReactiveCrudRepository<MessageDocument, String> {
}
