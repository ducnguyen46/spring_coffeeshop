use coffeeshop;
INSERT INTO coffeeshop.role VALUES
(1, "admin"),
(2, "employee"),
(3, "customer");

INSERT INTO coffeeshop.category VALUES 
(1, 'Coffee'),
(2, 'Tea');

INSERT INTO coffeeshop.product (image, name, price, category_id) VALUES 
('https://product.hstatic.net/1000075078/product/capu-nong_a2a47a422fa94e8194e9d4c4badba9d3_master.jpg', 'Cappuccino', 50000, 1),
('https://product.hstatic.net/1000075078/product/caramel-macchiato-nong_667b90cf1e20493899e6727ae8c1b071_master.jpg', 'Caramel Macchiato', 50000, 1),
('https://product.hstatic.net/1000075078/product/latte-nong_ffcd92de11f74937bce4197823246d07_master.jpg', 'Latte', 50000, 1),
('https://product.hstatic.net/1000075078/product/cafe-sua-da_9073dfe2143d428a91a370e79df77e49_master.jpg', 'Milk Coffee', 32000, 1),
('https://product.hstatic.net/1000075078/product/matcha-macchiato_c37b0e0c1c714d0091ee4f3052088193_master.jpg', 'Matcha Macchiato', 45000, 2),
('https://product.hstatic.net/1000075078/product/tra-dao-cam-sapng_58268b7877cd4209b8fc3fa1d4909511_master.jpg', 'Peach Orange Lemongrass Tea', 45000, 2),
('https://product.hstatic.net/1000075078/product/605da09f717e5d00114a3cd8_app_long_nhan_hat_chia_copy-min_15afd5872ab74b5fbb55414e965768bd_master.png', 'Longan Tea', '45000', 2);