-- 如果application中有配置的话，schema.sql和data.sql会依次执行，以注入测试数据
INSERT INTO goods(`uuid`, `name`, `desc`, `state`, `del_flag`) VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'iphone', 'Apple new iphone', 0, 0);