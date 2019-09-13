package com.wy;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Document(indexName = "transaction", type = "transaction", shards = 1, replicas = 0, refreshInterval = "-1")
public class PaymentTransaction {
    @Id
    private String id;
    private String transNumber;
    private Date timestamp;
    private String srcAccount;
    private String srcRouting;
    private String dstAccount;
    private String dstRouting;
    private float  amount;

    public PaymentTransaction(String transNumber, Date timestamp, String srcAccount, String srcRouting, String dstAccount, String dstRouting, float amount) {
        this.transNumber = transNumber;
        this.timestamp = timestamp;
        this.srcAccount = srcAccount;
        this.srcRouting = srcRouting;
        this.dstAccount = dstAccount;
        this.dstRouting = dstRouting;
        this.amount = amount;
    }

    public PaymentTransaction() {
    }

    public String getTransNumber() {
        return transNumber;
    }

    public void setTransNumber(String transNumber) {
        this.transNumber = transNumber;
        this.id = transNumber;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSrcAccount() {
        return srcAccount;
    }

    public void setSrcAccount(String srcAccount) {
        this.srcAccount = srcAccount;
    }

    public String getSrcRouting() {
        return srcRouting;
    }

    public void setSrcRouting(String srcRouting) {
        this.srcRouting = srcRouting;
    }

    public String getDstAccount() {
        return dstAccount;
    }

    public void setDstAccount(String dstAccount) {
        this.dstAccount = dstAccount;
    }

    public String getDstRouting() {
        return dstRouting;
    }

    public void setDstRouting(String dstRouting) {
        this.dstRouting = dstRouting;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        return String.format("Transaction[id=%s, TransactionNumber='%s', timeStamp='%s', SourceAccounut='%s', SourceRoutingNumber='%s', DestinationAccounut='%s', DestinatiomRoutingNumber='%s', Amount='%s']"
                ,this.id, this.transNumber, df.format(this.timestamp) ,this.srcAccount ,this.srcRouting  ,this.dstAccount ,this.dstRouting, String.valueOf(this.amount)
        );
    }
}
