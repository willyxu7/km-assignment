CREATE TABLE user (
    ID CHAR(32) NOT NULL,
    code CHAR(15) NOT NULL,
    name VARCHAR(80) NOT NULL,
    status SMALLINT NOT NULL,
    remark VARCHAR(200),
    deleted SMALLINT,
    creator CHAR(32) NOT NULL,
    created_time BIGINT NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE product(
    ID CHAR(32) NOT NULL,
    code CHAR(15) NOT NULL,
    name VARCHAR(80) NOT NULL,
    price BIGINT NOT NULL,
    unit VARCHAR(10) NOT NULL,
    remark VARCHAR(200),
    deleted SMALLINT,
    creator CHAR(32) NOT NULL,
    created_time BIGINT NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE orders(
    ID CHAR(32) NOT NULL,
    biz_date INT NOT NULL,
    order_no CHAR(20) NOT NULL UNIQUE,
    status SMALLINT NOT NULL,
    remark VARCHAR(200),
    creator CHAR(32) NOT NULL,
    created_time BIGINT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY fk_order_user (creator) REFERENCES user (ID)
);

CREATE TABLE order_detail(
    ID CHAR(32) NOT NULL,
    order_no CHAR(20) NOT NULL,
    seq INT,
    item_id CHAR(32) NOT NULL,
    price BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    unit VARCHAR(10) NOT NULL,
    remark VARCHAR(200),
    PRIMARY KEY (ID),
    FOREIGN KEY fk_order_detail_order (order_no) REFERENCES orders (order_no)
);

CREATE TABLE sys_seq(
    ID CHAR(32) NOT NULL,
    seq_key VARCHAR(20),
    value SMALLINT,
    PRIMARY KEY (ID)
);