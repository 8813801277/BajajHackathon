package com.mukul.Bajaj.Service;

import com.mukul.Bajaj.Entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public long getNext(String seqName){
        Sequence sequence = mongoTemplate.findAndModify(
                Query.query(Criteria.where("id").is(seqName)), // Corrected this line
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class);
        return sequence != null ? sequence.getSeq() : 1;
    }
}