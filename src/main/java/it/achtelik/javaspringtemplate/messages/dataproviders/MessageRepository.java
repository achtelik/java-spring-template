package it.achtelik.javaspringtemplate.messages.dataproviders;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MessageRepository extends ReactiveCrudRepository<MessageDocument, String> {
}
