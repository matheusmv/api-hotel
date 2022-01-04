INSERT INTO `users` (`id`, `email`, `password`, `locked`, `enabled`) VALUES (1, 'will@email.com', 'will_password', false, true);
INSERT INTO `users` (`id`, `email`, `password`, `locked`, `enabled`) VALUES (2, 'alex@email.com', 'alex_password', false, true);


INSERT INTO `profiles` (`first_name`, `last_name`, `user_id`) VALUES ('william', 'adams', 1);
INSERT INTO `profiles` (`first_name`, `last_name`, `user_id`) VALUES ('alex', 'jones', 2);


INSERT INTO `rooms` (`id`, `category`, `status`, `cost`) VALUES (1, 'STANDARD', 'AVAILABLE', 80.0);
INSERT INTO `rooms` (`id`, `category`, `status`, `cost`) VALUES (2, 'STANDARD', 'AVAILABLE', 80.0);
INSERT INTO `rooms` (`id`, `category`, `status`, `cost`) VALUES (3, 'MASTER', 'AVAILABLE', 100.0);
INSERT INTO `rooms` (`id`, `category`, `status`, `cost`) VALUES (4, 'LUX', 'AVAILABLE', 150.0);
INSERT INTO `rooms` (`id`, `category`, `status`, `cost`) VALUES (5, 'SUPERIOR_MASTER', 'AVAILABLE', 200.0);


INSERT INTO `accommodations` (`id`, `status`, `check_in`, `check_out`, `user_id`) VALUES (1, 'PRE_RESERVATION', NOW(), DATEADD(day, 7, NOW()), 1);
INSERT INTO `accommodations` (`id`, `status`, `check_in`, `check_out`, `user_id`) VALUES (2, 'CHECKED_IN', NOW(), DATEADD(day, 3, NOW()), 2);


INSERT INTO `accommodation_room` (`accommodation_id`, `room_id`) VALUES (1, 3);
INSERT INTO `accommodation_room` (`accommodation_id`, `room_id`) VALUES (2, 2);


UPDATE `rooms` SET `status` = 'OCCUPIED' WHERE `id` = 2;


INSERT INTO `room_services` (`id`, `description`, `cost`, `accommodation_id`) VALUES (1, 'food', 25.20, 2);
INSERT INTO `room_services` (`id`, `description`, `cost`, `accommodation_id`) VALUES (2, 'drink', 9.00, 2);
