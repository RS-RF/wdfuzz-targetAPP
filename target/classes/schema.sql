DROP TABLE IF EXISTS sys_user_role;
DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_dept;

CREATE TABLE sys_dept (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(50) NOT NULL,
    status VARCHAR(10) DEFAULT 'open',
    email VARCHAR(100),
    update_time DATETIME
);

CREATE TABLE sys_role (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE sys_user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    real_name VARCHAR(50),
    dept_id INT,
    email VARCHAR(100),
    phone VARCHAR(20),
    status VARCHAR(10) DEFAULT 'active',
    create_time DATETIME,
    FOREIGN KEY (dept_id) REFERENCES sys_dept(dept_id)
);

CREATE TABLE sys_user_role (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES sys_user(user_id),
    FOREIGN KEY (role_id) REFERENCES sys_role(role_id)
);

-- 插入初始数据
INSERT INTO sys_dept (dept_name, status, email, update_time) VALUES
('技术部', 'open', 'tech@example.com', NOW()),
('市场部', 'open', 'market@example.com', NOW()),
('财务部', 'closed', 'finance@example.com', NOW());

INSERT INTO sys_role (role_name) VALUES ('admin'), ('user'), ('guest');

INSERT INTO sys_user (username, password, real_name, dept_id, email, phone, status, create_time) VALUES
('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '管理员', 1, 'admin@example.com', '13800138000', 'active', NOW()),
('alice', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '张三', 1, 'alice@example.com', '13800138001', 'active', NOW()),
('bob', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '李四', 2, 'bob@example.com', '13800138002', 'active', NOW());

INSERT INTO sys_user_role (user_id, role_id) VALUES
(1, 1), (2, 2), (3, 2);