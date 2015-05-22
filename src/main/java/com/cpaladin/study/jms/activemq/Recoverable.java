package com.cpaladin.study.jms.activemq;

import javax.jms.Connection;

public interface Recoverable {

    void recover(Connection connection);

}
