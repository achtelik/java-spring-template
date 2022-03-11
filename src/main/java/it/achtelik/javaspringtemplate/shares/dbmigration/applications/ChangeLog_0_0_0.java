package it.achtelik.javaspringtemplate.shares.dbmigration.applications;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

@ChangeLog
public class ChangeLog_0_0_0 {
    @ChangeSet(order = "000", id = "information", author = "-", runAlways = true)
    public void information(MongoDatabase db) {
        System.out.println("################# Indexes #################");
        db.getCollection("messageDocument").listIndexes().forEach(doc -> System.out.println(doc.toJson()));
        db.getCollection("messageDocument").createIndex(Indexes.compoundIndex(Indexes.descending("modifiedAt")));
    }
}
