/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : oasys

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/12/2019 22:47:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aoa_attachment_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_attachment_list`;
CREATE TABLE `aoa_attachment_list` (
  `attachment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '附件ID',
  `attachment_name` varchar(255) DEFAULT NULL COMMENT '附件名',
  `attachment_path` varchar(255) DEFAULT NULL COMMENT '附件路径',
  `attachment_shuffix` varchar(255) DEFAULT NULL COMMENT '附件后缀',
  `attachment_size` varchar(255) DEFAULT NULL COMMENT '附件大小',
  `attachment_type` varchar(255) DEFAULT NULL COMMENT '附件类型',
  `model` varchar(255) DEFAULT NULL COMMENT '模型',
  `upload_time` datetime DEFAULT NULL COMMENT '附件上传时间',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=244 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_attachment_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_attachment_list` VALUES (3, '5.jpg', '/2017/09/罗密欧/a554a26e-546f-4da5-b9ed-80454851e590.jpg', 'jpg', '175797', 'image/jpeg', 'note', '2017-09-18 16:33:25', '1');
INSERT INTO `aoa_attachment_list` VALUES (6, '4.jpg', '/2017/09/罗密欧/74b9678a-1689-4a62-9345-68825e256cd6.jpg', 'jpg', '133831', 'image/jpeg', 'note', '2017-09-15 11:01:08', '1');
INSERT INTO `aoa_attachment_list` VALUES (7, '3.jpg', '/2017/09/罗密欧/fb8d46c2-fe8c-4e5e-9d1e-a7e937a16d77.jpg', 'jpg', '231999', 'image/jpeg', 'note', '2017-09-15 11:04:38', '1');
INSERT INTO `aoa_attachment_list` VALUES (8, '3.jpg', '/2017/09/罗密欧/67ea8f24-1a07-4618-acf8-7a4b2f093e0d.jpg', 'jpg', '231999', 'image/jpeg', 'note', '2017-09-15 11:09:21', '1');
INSERT INTO `aoa_attachment_list` VALUES (9, '2.jpg', '/2017/09/罗密欧/2818321d-76df-4b3f-80ea-a62effe28690.jpg', 'jpg', '302654', 'image/jpeg', 'note', '2017-09-23 16:43:50', '1');
INSERT INTO `aoa_attachment_list` VALUES (10, '5.jpg', '/2017/09/罗密欧/e9a07fda-551f-4351-af86-68dfe5e8bad4.jpg', 'jpg', '175797', 'image/jpeg', 'note', '2017-09-15 20:11:22', '1');
INSERT INTO `aoa_attachment_list` VALUES (11, '5.jpg', '/2017/09/罗密欧/0cdd59d1-1d49-4e03-aa9c-2f56779303f1.jpg', 'jpg', '175797', 'image/jpeg', 'note', '2017-09-15 20:14:50', '1');
INSERT INTO `aoa_attachment_list` VALUES (12, '5.jpg', '/2017/09/罗密欧/9700c576-58bc-4036-aecd-e704b22f7175.jpg', 'jpg', '175797', 'image/jpeg', 'note', '2017-09-15 20:37:24', '1');
INSERT INTO `aoa_attachment_list` VALUES (13, '5.jpg', '/2017/09/罗密欧/eec316a6-f7e8-4b85-a8d5-72f2af01256a.jpg', 'jpg', '175797', 'image/jpeg', 'note', '2017-09-15 23:06:24', '1');
INSERT INTO `aoa_attachment_list` VALUES (44, '1.jpg', '/2017/09/罗密欧/aa5be2a8-5705-4199-b1ba-0df2424e3eb8.jpg', 'jpg', '191177', 'image/jpeg', 'note', '2017-09-23 15:30:09', '1');
INSERT INTO `aoa_attachment_list` VALUES (46, '4.jpg', '/2017/09/罗密欧/f459a35a-439a-4d4d-a684-731d3bc48c88.jpg', 'jpg', '133831', 'image/jpeg', 'note', '2017-09-23 16:11:11', '1');
INSERT INTO `aoa_attachment_list` VALUES (47, '1.jpg', '/2017/09/罗密欧/44bc1ad7-0e2e-4569-afc1-385783a955bf.jpg', 'jpg', '191177', 'image/jpeg', 'note', '2017-09-23 16:37:05', '1');
INSERT INTO `aoa_attachment_list` VALUES (48, 'touxiang.jpg', '/2017/09/罗密欧/32bd13b9-40f6-4273-bb4a-96a064db8931.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-09-28 19:40:05', '1');
INSERT INTO `aoa_attachment_list` VALUES (49, '30D06FF1176D3C568E37CBE221D2E542.png', '/2017/09/罗密欧/db7577dd-c8aa-4276-a0af-44a1a19866f8.png', 'png', '71260', 'image/png', 'mail', '2017-09-28 21:24:38', '1');
INSERT INTO `aoa_attachment_list` VALUES (50, 'wenwu.gif', '/2017/09/罗密欧/ebbf1830-0808-4cd8-ac43-f40bef5eb514.gif', 'gif', '3532', 'image/gif', 'mail', '2017-09-28 21:27:45', '1');
INSERT INTO `aoa_attachment_list` VALUES (51, 'wenwu.gif', '/2017/09/罗密欧/f86b2292-0ebe-4d34-bf44-ef042b9b7869.gif', 'gif', '3532', 'image/gif', 'mail', '2017-09-28 21:30:40', '1');
INSERT INTO `aoa_attachment_list` VALUES (52, 'touxiang.jpg', '/2017/09/罗密欧/8235e27e-3ad3-4b86-bd6d-f26503d9f394.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-09-28 21:37:44', '1');
INSERT INTO `aoa_attachment_list` VALUES (53, 'touxiang.jpg', '/2017/09/罗密欧/fc55113a-d2ed-4d7a-bed1-8659c9cb301e.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-09-28 21:46:48', '1');
INSERT INTO `aoa_attachment_list` VALUES (54, 'touxiang.jpg', '/2017/09/罗密欧/e2bbea23-4b30-4407-b0c2-0fdced499a54.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-09-28 21:53:24', '1');
INSERT INTO `aoa_attachment_list` VALUES (55, 'touxiang.jpg', '/2017/09/罗密欧/3e3f94aa-b956-460f-811a-91af4438f9f3.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-09-28 22:00:37', '1');
INSERT INTO `aoa_attachment_list` VALUES (56, 'touxiang.jpg', '/2017/09/罗密欧/0c75fe6e-0e3b-4e3e-b1c2-50de92f09664.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-09-28 22:03:46', '1');
INSERT INTO `aoa_attachment_list` VALUES (57, 'touxiang.jpg', '/2017/09/罗密欧/9ef69729-1a49-4d3c-9ed1-75a601d0ae20.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-09-28 22:20:12', '1');
INSERT INTO `aoa_attachment_list` VALUES (58, '截图.png', '/2017/09/罗密欧/61c319da-b1ea-4d83-815c-5abb824e977c.png', 'png', '195652', 'image/png', 'mail', '2017-09-29 22:09:51', '1');
INSERT INTO `aoa_attachment_list` VALUES (59, 'touxiang.jpg', '/2017/10/朱丽叶/e59201dd-65ef-4f0f-801d-999d31be6d75.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-10-01 12:46:44', '2');
INSERT INTO `aoa_attachment_list` VALUES (60, 'touxiang.jpg', '/2017/10/罗密欧/e54faef8-b6aa-4451-8fef-a7c14aea2b86.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-10-01 19:39:14', '1');
INSERT INTO `aoa_attachment_list` VALUES (61, '30D06FF1176D3C568E37CBE221D2E542.png', '/2017/10/罗密欧/7ab2398a-0295-4e53-8037-10e10b5519fb.png', 'png', '71260', 'image/png', 'mail', '2017-10-02 14:49:56', '1');
INSERT INTO `aoa_attachment_list` VALUES (62, 'touxiang.jpg', '/2017/10/罗密欧/e2036a84-4bf0-4637-bf0f-18888745986d.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-10-06 11:02:49', '1');
INSERT INTO `aoa_attachment_list` VALUES (64, '4.jpg', '/2017/10/罗密欧/280308d8-2aca-40af-8868-b138aee8d71d.jpg', 'jpg', '133831', 'image/jpeg', 'note', '2017-10-07 16:03:03', '1');
INSERT INTO `aoa_attachment_list` VALUES (65, '1.jpg', '/2017/10/罗密欧/eabc7cbe-5406-491a-a7f5-52214af201cc.jpg', 'jpg', '191177', 'image/jpeg', 'note', '2017-10-07 16:03:58', '1');
INSERT INTO `aoa_attachment_list` VALUES (66, 'touxiang.jpg', '/2017/10/光宇/ea6c9723-9a0f-46e0-adbc-1cf41b44a805.jpg', 'jpg', '12124', 'image/jpeg', 'aoa_bursement', '2017-10-12 23:25:57', '18');
INSERT INTO `aoa_attachment_list` VALUES (67, 'touxiang.jpg', '/2017/10/伊丽莎白/b11342e1-bcf1-4196-b6a3-b900a5ce1c7a.jpg', 'jpg', '12124', 'image/jpeg', 'aoa_bursement', '2017-10-14 21:22:35', '3');
INSERT INTO `aoa_attachment_list` VALUES (68, 'touxiang.jpg', '/2017/10/光宇/d2377f04-95b7-49a3-95d1-e7ea7d51b204.jpg', 'jpg', '12124', 'image/jpeg', 'aoa_bursement', '2017-10-15 19:17:46', '18');
INSERT INTO `aoa_attachment_list` VALUES (69, 'touxiang.jpg', '/2017/10/光宇/ab5ebe75-a3ca-482f-96ea-ab353b3521fd.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-10-16 17:17:51', '18');
INSERT INTO `aoa_attachment_list` VALUES (70, 'touxiang.jpg', '/2017/10/罗密欧/3190c54b-ccdd-435c-8796-59f3d714b605.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-10-16 17:42:16', '1');
INSERT INTO `aoa_attachment_list` VALUES (71, '3.jpg', '/2017/10/罗密欧/49cca32e-a317-4cb3-b804-7a7ffe6b70ea.jpg', 'jpg', '231999', 'image/jpeg', 'note', '2017-10-18 16:13:02', '1');
INSERT INTO `aoa_attachment_list` VALUES (72, 'touxiang.jpg', '/2017/10/罗密欧/9bb7b8a0-cdc2-4e6a-bbf9-76741ec6d9f8.jpg', 'jpg', '12124', 'image/jpeg', 'mail', '2017-10-18 17:45:16', '1');
INSERT INTO `aoa_attachment_list` VALUES (73, 'timg.jpeg', '/2017/10/soli/f8055ab3-eb20-47bd-b015-b5b602ddb905.jpeg', 'jpeg', '696381', 'image/jpeg', 'note', '2017-10-19 23:37:37', '5');
INSERT INTO `aoa_attachment_list` VALUES (74, '2.jpg', '/2017/10/小李父斯基/294ccc18-1710-4fbf-8fff-4d547102d9d4.jpg', 'jpg', '302654', 'image/jpeg', 'note', '2017-10-20 10:35:00', '4');
INSERT INTO `aoa_attachment_list` VALUES (75, '3.jpg', '/2017/10/小李父斯基/7d7ffa12-5120-4c2d-85f0-71f3e61cde78.jpg', 'jpg', '231999', 'image/jpeg', 'note', '2017-10-20 10:36:07', '4');
INSERT INTO `aoa_attachment_list` VALUES (76, '5.jpg', '/2017/10/甄姬/9fbe4e2b-21be-40a4-bc95-0e10fdbc6183.jpg', 'jpg', '175797', 'image/jpeg', 'note', '2017-10-20 10:40:03', '7');
INSERT INTO `aoa_attachment_list` VALUES (77, '3.jpg', '/2017/10/罗密欧/1b01a1e2-17bf-4e96-98e5-dc8f30526c1c.jpg', 'jpg', '231999', 'image/jpeg', 'note', '2017-10-22 09:21:27', '1');
INSERT INTO `aoa_attachment_list` VALUES (78, '4.jpg', '/2017/10/罗密欧/96d0f196-b218-4e26-88e5-5ec1116271a1.jpg', 'jpg', '133831', 'image/jpeg', 'note', '2017-10-22 09:13:12', '1');
INSERT INTO `aoa_attachment_list` VALUES (79, '4.jpg', '/2017/10/罗密欧/3ac1f528-dac7-4635-8911-2d39e3ac6b03.jpg', 'jpg', '133831', 'image/jpeg', 'note', '2017-10-22 09:26:33', '1');
INSERT INTO `aoa_attachment_list` VALUES (80, '2.jpg', '/2017/10/罗密欧/5026b08c-354d-427d-8fb2-37c0f7b70199.jpg', 'jpg', '302654', 'image/jpeg', 'note', '2017-10-22 09:33:49', '1');
INSERT INTO `aoa_attachment_list` VALUES (81, '1.jpg', '/2017/10/罗密欧/000d6a4f-1a29-44fc-8daf-fe4208eebc54.jpg', 'jpg', '191177', 'image/jpeg', 'note', '2017-10-22 10:00:19', '1');
INSERT INTO `aoa_attachment_list` VALUES (82, '1.jpg', '/2017/10/罗密欧/976c2665-b059-4303-8e59-1ebc1a495ea5.jpg', 'jpg', '191177', 'image/jpeg', 'note', '2017-10-22 11:28:16', '1');
INSERT INTO `aoa_attachment_list` VALUES (83, NULL, NULL, NULL, NULL, NULL, 'aoa_bursement', NULL, NULL);
INSERT INTO `aoa_attachment_list` VALUES (84, '翠香-1.jpg', '/2019/11/soli/7287c6c7-d082-485a-91c6-ffd6b8ff0c30.jpg', 'jpg', '297712', 'image/jpeg', 'aoa_bursement', '2019-11-02 11:07:10', '5');
INSERT INTO `aoa_attachment_list` VALUES (85, '猕猴桃标签.png', '/2019/11/soli/40702bc2-27a9-490d-954b-e8a6e2598914.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-02 11:24:20', '5');
INSERT INTO `aoa_attachment_list` VALUES (86, '猕猴桃单果白图.png', '/2019/11/soli/ede71644-c898-44aa-97f5-635563e5f1b5.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-02 16:29:57', '5');
INSERT INTO `aoa_attachment_list` VALUES (87, '猕猴桃白图.png', '/2019/11/soli/f14c22a7-4ad3-4efb-a801-18f848ba311a.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-02 16:37:25', '5');
INSERT INTO `aoa_attachment_list` VALUES (88, '猕猴桃白图.png', '/2019/11/soli/98730403-cd9f-4e6d-8dc3-55b6810b39dd.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-02 17:41:33', '5');
INSERT INTO `aoa_attachment_list` VALUES (89, '猕猴桃单果白图.png', '/2019/11/soli/c371faf1-f79b-4145-979f-299ca6189b55.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-03 09:49:15', '5');
INSERT INTO `aoa_attachment_list` VALUES (90, '猕猴桃白图.png', '/2019/11/soli/269fa185-747c-4640-b78b-d76ba0a2f9ba.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-03 18:12:57', '5');
INSERT INTO `aoa_attachment_list` VALUES (91, '猕猴桃白图.png', '/2019/11/soli/9337490e-35f2-4194-bd5e-fc6ee1b3780b.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-03 22:05:43', '5');
INSERT INTO `aoa_attachment_list` VALUES (92, '猕猴桃单果白图.png', '/2019/11/soli/f0216632-3fe1-44d3-be3f-d5a303ba0d95.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-04 09:08:47', '5');
INSERT INTO `aoa_attachment_list` VALUES (93, '猕猴桃单果白图.png', '/2019/11/soli/6badfe5b-0897-4242-99cd-7e5ed3054bad.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-04 09:34:41', '5');
INSERT INTO `aoa_attachment_list` VALUES (94, '桂香猕猴桃logo.png', '/2019/11/soli/f09dbd7e-cd8c-466d-a1d9-16b24be31af5.png', 'png', '52886', 'image/png', 'aoa_bursement', '2019-11-04 09:45:43', '5');
INSERT INTO `aoa_attachment_list` VALUES (95, '猕猴桃标签.png', '/2019/11/soli/7b8c6e15-d0bd-4765-a7d5-d2aa7845fd86.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-04 09:59:30', '5');
INSERT INTO `aoa_attachment_list` VALUES (96, '猕猴桃白图.png', '/2019/11/soli/d88eaf33-a200-4caf-829b-1b4751aac27e.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-04 10:18:15', '5');
INSERT INTO `aoa_attachment_list` VALUES (97, '猕猴桃标签.png', '/2019/11/soli/ead11b31-f775-4322-876d-ed8324970533.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-04 11:31:34', '5');
INSERT INTO `aoa_attachment_list` VALUES (98, '猕猴桃标签.png', '/2019/11/soli/e9b27e48-e50d-48b9-bb57-ad58bdc6a0db.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-04 11:37:54', '5');
INSERT INTO `aoa_attachment_list` VALUES (99, '猕猴桃白图.png', '/2019/11/soli/f3f8146e-a663-4b2a-92a6-43abe1c6de1d.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-04 23:01:41', '5');
INSERT INTO `aoa_attachment_list` VALUES (100, '猕猴桃单果白图.png', '/2019/11/soli/92146c86-f95b-404e-8ee7-46afca3377c5.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 19:59:46', '5');
INSERT INTO `aoa_attachment_list` VALUES (101, '猕猴桃单果白图.png', '/2019/11/soli/bd6e13f6-de1f-4d77-8843-6f0c526ae090.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 20:09:17', '5');
INSERT INTO `aoa_attachment_list` VALUES (102, '猕猴桃单果白图.png', '/2019/11/soli/fecad9f3-aafc-44a2-aad4-3b23a3ed5235.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 22:10:10', '5');
INSERT INTO `aoa_attachment_list` VALUES (103, '猕猴桃单果白图.png', '/2019/11/soli/ae7d5c98-700a-4ee4-bd82-64aa02ddb97c.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 22:12:27', '5');
INSERT INTO `aoa_attachment_list` VALUES (104, '猕猴桃单果白图.png', '/2019/11/soli/f0cd8766-8b7a-4898-97c2-8cf959aee1ab.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 22:30:02', '5');
INSERT INTO `aoa_attachment_list` VALUES (105, '猕猴桃单果白图.png', '/2019/11/soli/e478cde3-e920-4a71-ae08-d5400f3b48d5.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 22:39:15', '5');
INSERT INTO `aoa_attachment_list` VALUES (106, '猕猴桃单果白图.png', '/2019/11/soli/d3d822ee-a863-4d09-a070-63979671fc15.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 22:43:53', '5');
INSERT INTO `aoa_attachment_list` VALUES (107, '猕猴桃单果白图.png', '/2019/11/soli/6a78cee8-872f-4a7d-b9cf-cf151fd38f09.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 22:56:38', '5');
INSERT INTO `aoa_attachment_list` VALUES (108, '猕猴桃单果白图.png', '/2019/11/soli/23aa5b1c-75b8-4b4e-89ad-d1e211e9ba86.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 23:19:18', '5');
INSERT INTO `aoa_attachment_list` VALUES (109, '猕猴桃标签.png', '/2019/11/soli/486b7531-aab8-43f7-bdce-7e56c8408c23.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-08 23:22:51', '5');
INSERT INTO `aoa_attachment_list` VALUES (110, '猕猴桃单果白图.png', '/2019/11/soli/615eb9b3-9f2f-4f2c-a4a0-63b5ffabe9c0.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-08 23:34:42', '5');
INSERT INTO `aoa_attachment_list` VALUES (111, '猕猴桃单果白图.png', '/2019/11/soli/21e5c3af-b584-4519-a9cf-f1d9aa6b4eac.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-09 09:03:01', '5');
INSERT INTO `aoa_attachment_list` VALUES (112, '猕猴桃白图.png', '/2019/11/soli/6c83e2d4-e6f1-4d79-9875-43d837c70986.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-09 09:05:41', '5');
INSERT INTO `aoa_attachment_list` VALUES (113, '猕猴桃单果白图.png', '/2019/11/soli/a6b06637-08a7-454c-a866-c1fe8d39da5a.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-09 09:42:56', '5');
INSERT INTO `aoa_attachment_list` VALUES (114, '猕猴桃标签.png', '/2019/11/soli/ffe8e7d0-3369-461f-b903-5831d12782ba.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-09 10:38:27', '5');
INSERT INTO `aoa_attachment_list` VALUES (115, '猕猴桃白图.png', '/2019/11/soli/59c47dec-7cec-4917-901d-56223c023e10.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-09 10:56:46', '5');
INSERT INTO `aoa_attachment_list` VALUES (116, '猕猴桃单果白图.png', '/2019/11/soli/8c158285-58fd-4a5e-8f86-6c9a6e3a23ad.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-09 22:41:06', '5');
INSERT INTO `aoa_attachment_list` VALUES (117, '桂香猕猴桃logo.png', '/2019/11/soli/70a47d68-24ec-458d-b6a7-884d2e62c364.png', 'png', '52886', 'image/png', 'aoa_bursement', '2019-11-09 23:33:09', '5');
INSERT INTO `aoa_attachment_list` VALUES (118, '猕猴桃单果白图.png', '/2019/11/soli/74c17847-590c-4640-8335-e4db80f33173.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-09 23:44:57', '5');
INSERT INTO `aoa_attachment_list` VALUES (119, '猕猴桃白图.png', '/2019/11/soli/01f9ace8-1bc8-4a7c-8a1d-bf0fa446490d.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-09 23:48:07', '5');
INSERT INTO `aoa_attachment_list` VALUES (120, '猕猴桃标签.png', '/2019/11/soli/8e8ad239-c999-4f04-832d-298a9b170c66.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-10 09:27:11', '5');
INSERT INTO `aoa_attachment_list` VALUES (121, '猕猴桃标签.png', '/2019/11/soli/659d0bb0-a8bc-4bf1-8c78-f433a813436e.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-10 09:28:54', '5');
INSERT INTO `aoa_attachment_list` VALUES (122, '猕猴桃标签.png', '/2019/11/soli/7e62a914-af1c-49c0-8265-27c4d2f8b902.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-10 09:31:14', '5');
INSERT INTO `aoa_attachment_list` VALUES (123, '猕猴桃单果白图.png', '/2019/11/soli/9cb1c2cd-a4ad-4834-bbaa-f1351bc1b87f.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 09:38:14', '5');
INSERT INTO `aoa_attachment_list` VALUES (124, '猕猴桃单果白图.png', '/2019/11/soli/64d4eecc-a174-42fb-845e-c4eb51e8d6ee.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 09:50:06', '5');
INSERT INTO `aoa_attachment_list` VALUES (125, '猕猴桃单果白图.png', '/2019/11/soli/51ebe322-85e4-4508-a064-bcbf661aef57.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 09:52:30', '5');
INSERT INTO `aoa_attachment_list` VALUES (126, '猕猴桃单果白图.png', '/2019/11/soli/d9f6711c-d7d6-44ee-8ec4-0760af340b6d.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 10:04:23', '5');
INSERT INTO `aoa_attachment_list` VALUES (127, '猕猴桃白图.png', '/2019/11/soli/e79f6994-d5a8-43f5-8f38-cdec67a703c8.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-10 10:08:06', '5');
INSERT INTO `aoa_attachment_list` VALUES (128, '猕猴桃单果白图.png', '/2019/11/soli/e1174612-5bf7-4654-be74-3aefda992766.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 10:18:33', '5');
INSERT INTO `aoa_attachment_list` VALUES (129, '猕猴桃单果白图.png', '/2019/11/soli/2b36866e-d29c-4c57-befe-ed8e1d006295.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 10:25:28', '5');
INSERT INTO `aoa_attachment_list` VALUES (130, '猕猴桃标签.png', '/2019/11/soli/5990b47f-656a-4cf0-92d1-45830e97d62a.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-10 10:51:26', '5');
INSERT INTO `aoa_attachment_list` VALUES (131, '猕猴桃单果白图.png', '/2019/11/soli/e9adcae7-9b81-444b-b2b8-e43ec66d3b56.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 10:53:59', '5');
INSERT INTO `aoa_attachment_list` VALUES (132, '猕猴桃标签.png', '/2019/11/soli/447c45cd-fef8-4ef2-b931-74fcc4f20f79.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-10 10:54:43', '5');
INSERT INTO `aoa_attachment_list` VALUES (133, '猕猴桃单果白图.png', '/2019/11/soli/6f8cfab5-bf5b-4bae-951e-b5be8c761544.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 10:56:14', '5');
INSERT INTO `aoa_attachment_list` VALUES (134, '猕猴桃单果白图.png', '/2019/11/soli/d0cbc81f-6059-4169-a640-bd6f05e694bb.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 18:10:09', '5');
INSERT INTO `aoa_attachment_list` VALUES (135, '猕猴桃单果白图.png', '/2019/11/soli/ee9c0f18-aa38-4817-a93d-b3ebe003b4a8.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-10 18:13:17', '5');
INSERT INTO `aoa_attachment_list` VALUES (136, '猕猴桃标签.png', '/2019/11/soli/b3124da6-a413-4f86-acd6-0c109b5d5919.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-10 18:14:14', '5');
INSERT INTO `aoa_attachment_list` VALUES (137, '猕猴桃白图.png', '/2019/11/soli/e8eb21a5-ef9a-4ae3-b713-10fc0e8cf052.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-10 18:15:36', '5');
INSERT INTO `aoa_attachment_list` VALUES (138, '猕猴桃单果白图.png', '/2019/11/soli/d4e1bf7b-34f5-40bb-a62b-53e597af1fee.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-11 21:44:02', '5');
INSERT INTO `aoa_attachment_list` VALUES (139, '猕猴桃单果白图.png', '/2019/11/soli/d2b887f2-d6c5-4980-87b4-ac31376a249e.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 11:31:28', '5');
INSERT INTO `aoa_attachment_list` VALUES (140, '猕猴桃单果白图.png', '/2019/11/soli/d45db684-46e1-407f-b115-11f545449bcb.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 11:36:08', '5');
INSERT INTO `aoa_attachment_list` VALUES (141, '猕猴桃单果白图.png', '/2019/11/soli/16c3ae07-9736-400d-9bed-12753aa03a53.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 11:36:39', '5');
INSERT INTO `aoa_attachment_list` VALUES (142, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/man/resources/attachment/2019/11/soli/c8bb056c-d8da-471b-ac26-9417c0cddce5.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 11:47:07', '5');
INSERT INTO `aoa_attachment_list` VALUES (143, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/3b0b7b86-0305-493c-9cab-adb636160781.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 11:50:23', '5');
INSERT INTO `aoa_attachment_list` VALUES (144, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/4c65ce3b-56e7-4106-8008-b3c356f5ea70.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 12:32:06', '5');
INSERT INTO `aoa_attachment_list` VALUES (145, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/5c268703-c44f-48b1-a466-6579b1b36ff5.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 12:38:36', '5');
INSERT INTO `aoa_attachment_list` VALUES (146, '坏果比赔.gif', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/6e85429d-0df8-4dd0-bc74-7532f0b42447.gif', 'gif', '485769', 'image/gif', 'aoa_bursement', '2019-11-12 13:02:58', '5');
INSERT INTO `aoa_attachment_list` VALUES (147, '猕猴桃白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/46be57f1-fc0c-45bb-99a0-d903724a8e21.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-12 13:09:42', '5');
INSERT INTO `aoa_attachment_list` VALUES (148, '猕猴桃标签.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/7f37d745-3a0e-470e-9f20-177298e9e49d.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-12 13:12:03', '5');
INSERT INTO `aoa_attachment_list` VALUES (149, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/0d1e795b-227c-45a1-8d3a-acb94ee04c05.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 14:11:31', '5');
INSERT INTO `aoa_attachment_list` VALUES (150, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/bbcdb8a4-2c90-4937-9a5a-e7a6e46c8f10.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 14:14:37', '5');
INSERT INTO `aoa_attachment_list` VALUES (151, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/aa5e8d9d-e772-42df-8625-219d5179608c.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 14:20:22', '5');
INSERT INTO `aoa_attachment_list` VALUES (152, '猕猴桃标签.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/eb87a894-13fd-4b00-9fa5-2d0d8d7a9888.png', 'png', '408757', 'image/png', 'aoa_bursement', '2019-11-12 22:28:03', '5');
INSERT INTO `aoa_attachment_list` VALUES (153, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/0fd01fd9-86c5-4737-b11b-869fc9d48d8a.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 22:34:06', '5');
INSERT INTO `aoa_attachment_list` VALUES (154, '猕猴桃白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/15421e46-2ca5-429d-a812-8bbf530141ad.png', 'png', '647475', 'image/png', 'aoa_bursement', '2019-11-12 22:36:35', '5');
INSERT INTO `aoa_attachment_list` VALUES (155, '猕猴桃单果白图.png', '/Users/fuzhou/Desktop/linsuoting/oasys2/src/main/resources/attachment/2019/11/soli/0c36dd60-b76b-4245-879f-15e7f260c0c9.png', 'png', '624614', 'image/png', 'aoa_bursement', '2019-11-12 22:44:45', '5');
INSERT INTO `aoa_attachment_list` VALUES (156, '猕猴桃单果白图.png', '/2019/11/soli/6a9f4d3e-e8b5-41a7-ba97-b93842939bf8.png', 'png', '624614', 'image/png', 'mail', '2019-11-13 19:01:37', '5');
INSERT INTO `aoa_attachment_list` VALUES (157, '猕猴桃白图.png', '/2019/11/soli/7c4472cd-7a27-4268-81a5-cddf01b25b8f.png', 'png', '647475', 'image/png', 'mail', '2019-11-15 20:48:57', '5');
INSERT INTO `aoa_attachment_list` VALUES (158, '猕猴桃单果白图.png', '/2019/11/soli/a6043608-c930-46e5-adcc-820083ea9898.png', 'png', '624614', 'image/png', 'mail', '2019-11-15 21:40:32', '5');
INSERT INTO `aoa_attachment_list` VALUES (159, '猕猴桃单果白图.png', '/2019/11/soli/d8de7188-a99b-4919-b605-3710ac735478.png', 'png', '624614', 'image/png', 'mail', '2019-11-17 14:42:41', '5');
INSERT INTO `aoa_attachment_list` VALUES (160, '猕猴桃标签.png', '/2019/11/soli/9dcbf63c-3eca-42ad-9016-a9bd6a9da65b.png', 'png', '408757', 'image/png', 'mail', '2019-11-17 15:50:11', '5');
INSERT INTO `aoa_attachment_list` VALUES (161, '翠香-1.jpg', '/2019/11/soli/329075c4-1bb2-4b3d-b5d7-e6af1aa24b0e.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-17 15:55:33', '5');
INSERT INTO `aoa_attachment_list` VALUES (162, '翠香-2.jpg', '/2019/11/soli/b0062c2a-af63-402c-9845-7137a36d932f.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-17 16:04:15', '5');
INSERT INTO `aoa_attachment_list` VALUES (163, '翠香-1.jpg', '/2019/11/soli/f0f7b122-d467-49d3-9172-65dc2ba27582.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-17 16:14:33', '5');
INSERT INTO `aoa_attachment_list` VALUES (164, '猕猴桃标签.png', '/2019/11/soli/9ebdd22c-9b46-4579-a626-d93e1ddda1de.png', 'png', '408757', 'image/png', 'mail', '2019-11-17 16:27:44', '5');
INSERT INTO `aoa_attachment_list` VALUES (165, '猕猴桃标签.png', '/2019/11/soli/5175b499-2ce7-4ca0-8ef3-e2ae86653888.png', 'png', '408757', 'image/png', 'mail', '2019-11-17 16:31:32', '5');
INSERT INTO `aoa_attachment_list` VALUES (166, '猕猴桃白图.png', '/2019/11/soli/fb187b9c-76b1-4c8b-8fb7-24c7e900d6fd.png', 'png', '647475', 'image/png', 'mail', '2019-11-17 16:38:57', '5');
INSERT INTO `aoa_attachment_list` VALUES (167, '猕猴桃白图.png', '/2019/11/伊丽莎白/7dffb777-bf0c-453b-844e-76c3cae491e6.png', 'png', '647475', 'image/png', 'mail', '2019-11-17 17:01:35', '3');
INSERT INTO `aoa_attachment_list` VALUES (168, '多果园-logo.png', '/2019/11/伊丽莎白/3f7ea303-a23f-462a-a27e-77ca04c877e7.png', 'png', '14046', 'image/png', 'mail', '2019-11-17 21:09:31', '3');
INSERT INTO `aoa_attachment_list` VALUES (169, '多果园-logo.png', '/2019/11/soli/4e1474ef-9041-4000-9b8a-9cedff610518.png', 'png', '14046', 'image/png', 'mail', '2019-11-17 21:24:59', '5');
INSERT INTO `aoa_attachment_list` VALUES (170, '翠香-2.jpg', '/2019/11/伊丽莎白/1d23e980-f525-467a-98fe-bdd061d6e803.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-17 21:36:15', '3');
INSERT INTO `aoa_attachment_list` VALUES (171, '翠香-2.jpg', '/2019/11/伊丽莎白/fb3b7cee-4270-4910-97ee-204952da2c15.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-17 21:43:18', '3');
INSERT INTO `aoa_attachment_list` VALUES (172, '翠香-2.jpg', '/2019/11/伊丽莎白/c3e6c4ed-d7b0-4178-914b-740886f2dc8b.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-17 21:46:05', '3');
INSERT INTO `aoa_attachment_list` VALUES (173, '翠香-2.jpg', '/2019/11/soli/f900cb0c-244c-4148-b6d3-e70b227b242f.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-17 21:54:09', '5');
INSERT INTO `aoa_attachment_list` VALUES (174, '翠香-1.jpg', '/2019/11/伊丽莎白/3f0312b1-78de-4aea-acf3-2044559394a2.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-17 21:57:32', '3');
INSERT INTO `aoa_attachment_list` VALUES (175, '翠香-2.jpg', '/2019/11/伊丽莎白/f3426cd2-1f43-4800-97e2-d1c5c52afca2.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-17 22:04:43', '3');
INSERT INTO `aoa_attachment_list` VALUES (176, '翠香-1.jpg', '/2019/11/伊丽莎白/9f8f8029-de58-4ee0-a206-13f44ff2af0a.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-17 22:11:57', '3');
INSERT INTO `aoa_attachment_list` VALUES (177, '翠香-1.jpg', '/2019/11/soli/f0165e88-0b27-4a10-8ba0-5352f60190fe.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-17 22:21:00', '5');
INSERT INTO `aoa_attachment_list` VALUES (178, '翠香-1.jpg', '/2019/11/soli/ea38306e-3663-4bc3-9977-a3fb05e38dd9.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-17 22:26:01', '5');
INSERT INTO `aoa_attachment_list` VALUES (179, '翠香-1.jpg', '/2019/11/soli/2ca935b2-74ff-4f61-8e71-2c9baca17a85.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-17 22:42:53', '5');
INSERT INTO `aoa_attachment_list` VALUES (180, '翠香-1.jpg', '/2019/11/伊丽莎白/61470790-aec8-41c4-8956-22193f9a3987.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-18 09:08:17', '3');
INSERT INTO `aoa_attachment_list` VALUES (181, '翠香-1.jpg', '/2019/11/伊丽莎白/e3edd027-a345-4e6d-80cc-77d0e9bb0c8a.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-18 09:33:28', '3');
INSERT INTO `aoa_attachment_list` VALUES (182, '翠香-2.jpg', '/2019/11/伊丽莎白/fa8d703d-f8b2-46b0-8e45-faa6b9bab7ce.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-18 09:40:59', '3');
INSERT INTO `aoa_attachment_list` VALUES (183, '翠香-2.jpg', '/2019/11/soli/dfc03384-f81b-4499-b54f-c6b65da1826b.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-18 09:49:25', '5');
INSERT INTO `aoa_attachment_list` VALUES (184, '翠香-2.jpg', '/2019/11/soli/e58771aa-5050-41ac-8ad3-b118709ea034.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-18 09:58:13', '5');
INSERT INTO `aoa_attachment_list` VALUES (185, '翠香-1.jpg', '/2019/11/soli/03b51e6f-a4f3-4c1b-97b1-0604021aa2ff.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-18 10:01:02', '5');
INSERT INTO `aoa_attachment_list` VALUES (186, '翠香-2.jpg', '/2019/11/soli/c971b5a2-97aa-420c-a1ae-fbcc5931d221.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-18 10:14:11', '5');
INSERT INTO `aoa_attachment_list` VALUES (187, '翠香-1.jpg', '/2019/11/soli/20b4aaef-0ddc-4359-8f0e-9f35657af7c0.jpg', 'jpg', '297712', 'image/jpeg', 'mail', '2019-11-18 17:16:40', '5');
INSERT INTO `aoa_attachment_list` VALUES (188, '翠香-2.jpg', '/2019/11/soli/41dc3e07-0293-4d21-ad12-677bcc30641c.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-18 17:28:42', '5');
INSERT INTO `aoa_attachment_list` VALUES (189, '翠香-2.jpg', '/2019/11/soli/6f44e369-29b1-4132-923b-c59545dbc059.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-18 17:36:22', '5');
INSERT INTO `aoa_attachment_list` VALUES (190, '翠香-2.jpg', '/2019/11/soli/766ea07f-a43b-4a17-8d81-90dd7139552b.jpg', 'jpg', '977016', 'image/jpeg', 'mail', '2019-11-18 17:58:50', '5');
INSERT INTO `aoa_attachment_list` VALUES (191, '翠香-2.jpg', '/2019/11/soli/8d570efc-04df-4423-9412-e15e49a95d72.jpg', 'jpg', '977016', 'image/jpeg', 'note', '2019-11-22 16:05:53', '5');
INSERT INTO `aoa_attachment_list` VALUES (192, '翠香-1.jpg', '/2019/11/soli/d9c4534a-328c-4ed3-b073-6dc5517c7859.jpg', 'jpg', '297712', 'image/jpeg', NULL, '2019-11-22 20:27:30', '5');
INSERT INTO `aoa_attachment_list` VALUES (193, '441565529998_.pic_hd.jpg', '/2019/11/soli/d944926e-a129-4f08-ac88-d6fdaec1a747.jpg', 'jpg', '1031494', 'image/jpeg', NULL, '2019-11-22 20:50:21', '5');
INSERT INTO `aoa_attachment_list` VALUES (194, '猕猴桃白图.png', '/2019/11/soli/af256f92-cb71-4a48-b21e-90b84fcdd6ba.png', 'png', '647475', 'image/png', NULL, '2019-11-22 21:30:04', '5');
INSERT INTO `aoa_attachment_list` VALUES (195, '441565529998_.pic_hd.jpg', '/2019/11/盛如思/40cc4b8b-834e-4ec3-a797-7ff225df93db.jpg', 'jpg', '1031494', 'image/jpeg', NULL, '2019-11-23 16:36:00', '14');
INSERT INTO `aoa_attachment_list` VALUES (196, '翠香-1.jpg', '/2019/11/盛如思/86194b9e-025d-4e96-b981-b4a4e4e11b58.jpg', 'jpg', '297712', 'image/jpeg', NULL, '2019-11-23 16:39:03', '14');
INSERT INTO `aoa_attachment_list` VALUES (197, '翠香-1.jpg', '/2019/11/盛如思/a2f12c03-690b-415e-8508-3e9c595d87c6.jpg', 'jpg', '297712', 'image/jpeg', NULL, '2019-11-23 16:40:23', '14');
INSERT INTO `aoa_attachment_list` VALUES (198, '翠香-1.jpg', '/2019/11/盛如思/4f3824ac-afd6-44ed-a0a5-344b5211408c.jpg', 'jpg', '297712', 'image/jpeg', NULL, '2019-11-23 16:54:54', '14');
INSERT INTO `aoa_attachment_list` VALUES (199, '441565529998_.pic_hd.jpg', '/2019/11/盛如思/04f31057-8373-4fa1-9b8d-58fc66b9c7f9.jpg', 'jpg', '1031494', 'image/jpeg', NULL, '2019-11-23 16:55:35', '14');
INSERT INTO `aoa_attachment_list` VALUES (200, '翠香-2.jpg', '/2019/11/盛如思/e8644f2d-fffc-4638-97f1-3574415d6d96.jpg', 'jpg', '977016', 'image/jpeg', NULL, '2019-11-23 17:00:15', '14');
INSERT INTO `aoa_attachment_list` VALUES (201, '431565529997_.pic_hd.jpg', '/2019/11/盛如思/415b981f-b702-4509-8222-708e77943df7.jpg', 'jpg', '983607', 'image/jpeg', NULL, '2019-11-23 17:03:00', '14');
INSERT INTO `aoa_attachment_list` VALUES (202, '441565529998_.pic_hd.jpg', '/2019/11/盛如思/39644a5e-2771-467d-9746-3c0b3805653f.jpg', 'jpg', '1031494', 'image/jpeg', NULL, '2019-11-23 17:08:35', '14');
INSERT INTO `aoa_attachment_list` VALUES (203, '翠香-1.jpg', '/2019/11/盛如思/3d0dd46e-0224-4998-8ebe-c40e063261a4.jpg', 'jpg', '297712', 'image/jpeg', NULL, '2019-11-23 17:09:56', '14');
INSERT INTO `aoa_attachment_list` VALUES (204, '翠香-1.jpg', '/2019/11/李楚堂/44ec3db3-d1f4-4f68-82e9-4b3785c5f1ab.jpg', 'jpg', '297712', 'image/jpeg', NULL, '2019-11-23 22:02:22', '15');
INSERT INTO `aoa_attachment_list` VALUES (205, '翠香-1.jpg', '/2019/11/soli/8f5af682-de87-47e1-8ccf-535db8207294.jpg', 'jpg', '297712', 'image/jpeg', NULL, '2019-11-23 23:23:49', '5');
INSERT INTO `aoa_attachment_list` VALUES (206, '141565423289_.pic.jpg', '/2019/11/soli/e4890cee-f224-494b-aa58-44d5f72f2efb.jpg', 'jpg', '84925', 'image/jpeg', NULL, '2019-11-27 10:06:32', '5');
INSERT INTO `aoa_attachment_list` VALUES (207, 'mysql.txt', '/2019/12/伊丽莎白/4b0c11cc-7839-4d15-8b9a-f7763d9f5476.txt', 'txt', '131', 'text/plain', 'note', '2019-12-05 09:35:57', '3');
INSERT INTO `aoa_attachment_list` VALUES (208, 'spring-webmvc.txt', '/2019/12/伊丽莎白/c51b77d3-b16e-438d-a9ef-107ee1aa626e.txt', 'txt', '308', 'text/plain', 'note', '2019-12-05 10:27:15', '3');
INSERT INTO `aoa_attachment_list` VALUES (209, 'spring-webmvc.txt', '/2019/12/伊丽莎白/197ea301-f477-4afd-bae4-b15205cceed0.txt', 'txt', '308', 'text/plain', 'note', '2019-12-05 15:57:58', '3');
INSERT INTO `aoa_attachment_list` VALUES (210, 'spring-webmvc.txt', '/2019/12/伊丽莎白/f2d868cc-987a-4a23-9c77-72072323bf2b.txt', 'txt', '308', 'text/plain', 'note', '2019-12-05 16:05:54', '3');
INSERT INTO `aoa_attachment_list` VALUES (211, 'spring-webmvc.txt', '/2019/12/伊丽莎白/050fa915-17d2-405a-8596-a5acf564d26a.txt', 'txt', '308', 'text/plain', 'note', '2019-12-05 16:11:57', '3');
INSERT INTO `aoa_attachment_list` VALUES (212, 'mysql.txt', '/2019/12/伊丽莎白/b78e1a47-42e7-4c84-b2b6-acb68bd4b8a6.txt', 'txt', '131', 'text/plain', 'note', '2019-12-05 16:36:43', '3');
INSERT INTO `aoa_attachment_list` VALUES (213, 'MyBatis.txt', '/2019/12/伊丽莎白/5dc38b2f-fc76-45be-9396-f3c53443456b.txt', 'txt', '125', 'text/plain', 'note', '2019-12-05 16:39:01', '3');
INSERT INTO `aoa_attachment_list` VALUES (214, 'MyBatis.txt', '/2019/12/伊丽莎白/586f85f4-b973-47b6-9ebb-f7a37fe0d782.txt', 'txt', '125', 'text/plain', 'note', '2019-12-05 16:43:33', '3');
INSERT INTO `aoa_attachment_list` VALUES (215, '131565423288_.pic.jpg', '/2019/12/伊丽莎白/773c5054-5fb8-4e77-b182-92472188d365.jpg', 'jpg', '80089', 'image/jpeg', 'note', '2019-12-05 20:15:39', '3');
INSERT INTO `aoa_attachment_list` VALUES (216, '201565423295_.pic.jpg', '/2019/12/伊丽莎白/5700a65e-ce1a-4f54-a714-acc5d870f742.jpg', 'jpg', '103691', 'image/jpeg', 'note', '2019-12-06 10:26:23', '3');
INSERT INTO `aoa_attachment_list` VALUES (217, '201565423295_.pic.jpg', '/2019/12/伊丽莎白/d49168a2-03bf-4392-ad5e-0a75b58025d9.jpg', 'jpg', '103691', 'image/jpeg', 'note', '2019-12-06 10:28:09', '3');
INSERT INTO `aoa_attachment_list` VALUES (218, '181565423293_.pic.jpg', '/2019/12/伊丽莎白/871c61ca-08c8-4e98-b1d9-6e7ff3122bd5.jpg', 'jpg', '150636', 'image/jpeg', 'note', '2019-12-06 10:50:03', '3');
INSERT INTO `aoa_attachment_list` VALUES (219, '201565423295_.pic.jpg', '/2019/12/伊丽莎白/21497b61-d6a9-43ac-80bf-586222a2246b.jpg', 'jpg', '103691', 'image/jpeg', 'note', '2019-12-06 15:02:55', '3');
INSERT INTO `aoa_attachment_list` VALUES (220, '191565423294_.pic.jpg', '/2019/12/伊丽莎白/dd9db1dc-8977-47cb-8043-3970e9c15825.jpg', 'jpg', '102541', 'image/jpeg', 'note', '2019-12-06 15:18:30', '3');
INSERT INTO `aoa_attachment_list` VALUES (221, '191565423294_.pic.jpg', '/2019/12/伊丽莎白/d0d18e58-257d-48c2-aff2-014cda315f97.jpg', 'jpg', '102541', 'image/jpeg', 'note', '2019-12-06 16:31:49', '3');
INSERT INTO `aoa_attachment_list` VALUES (222, '211565423296_.pic.jpg', '/2019/12/伊丽莎白/19bd04b1-60b1-46d9-a007-d4b8200c52c6.jpg', 'jpg', '113490', 'image/jpeg', 'note', '2019-12-06 16:32:50', '3');
INSERT INTO `aoa_attachment_list` VALUES (223, '221565423297_.pic.jpg', '/2019/12/伊丽莎白/0f529822-4d01-4416-94ae-4ae1d595e8af.jpg', 'jpg', '55323', 'image/jpeg', 'note', '2019-12-06 16:33:49', '3');
INSERT INTO `aoa_attachment_list` VALUES (224, '191565423294_.pic.jpg', '/2019/12/伊丽莎白/0125902d-5346-44bc-8cc2-3b201051d04d.jpg', 'jpg', '102541', 'image/jpeg', 'note', '2019-12-06 16:34:17', '3');
INSERT INTO `aoa_attachment_list` VALUES (225, '111565423286_.pic.jpg', '/2019/12/伊丽莎白/7c027280-5136-4b4b-b0c3-b95a1adbaa69.jpg', 'jpg', '79989', 'image/jpeg', 'note', '2019-12-06 16:35:02', '3');
INSERT INTO `aoa_attachment_list` VALUES (226, '151565423290_.pic.jpg', '/2019/12/伊丽莎白/9876d797-5db4-4705-8b55-a940bf90d856.jpg', 'jpg', '62397', 'image/jpeg', 'note', '2019-12-06 16:54:42', '3');
INSERT INTO `aoa_attachment_list` VALUES (227, '191565423294_.pic.jpg', '/2019/12/伊丽莎白/55068a81-aeeb-48c7-afe9-a7a39fc0e78f.jpg', 'jpg', '102541', 'image/jpeg', 'aoa_bursement', '2019-12-11 09:09:13', '3');
INSERT INTO `aoa_attachment_list` VALUES (228, '201565423295_.pic.jpg', '/2019/12/伊丽莎白/66255f4a-f605-46b3-ad52-6ed9cb22b610.jpg', 'jpg', '103691', 'image/jpeg', 'aoa_bursement', '2019-12-11 09:33:09', '3');
INSERT INTO `aoa_attachment_list` VALUES (229, '181565423293_.pic.jpg', '/2019/12/伊丽莎白/0c307f4a-4e92-498b-9370-731bb8d08d32.jpg', 'jpg', '150636', 'image/jpeg', 'aoa_bursement', '2019-12-12 17:49:48', '3');
INSERT INTO `aoa_attachment_list` VALUES (230, '221565423297_.pic.jpg', '/2019/12/伊丽莎白/a2316fa6-7f45-49db-a819-769381141f0f.jpg', 'jpg', '55323', 'image/jpeg', 'aoa_bursement', '2019-12-12 22:11:25', '3');
INSERT INTO `aoa_attachment_list` VALUES (231, '211565423296_.pic.jpg', '/2019/12/伊丽莎白/57c08cc5-3867-4321-bdd4-c330a38bdff1.jpg', 'jpg', '113490', 'image/jpeg', 'aoa_bursement', '2019-12-13 09:33:43', '3');
INSERT INTO `aoa_attachment_list` VALUES (232, '231565423298_.pic.jpg', '/2019/12/伊丽莎白/37670ee2-cbb4-47c4-b036-9c078e09df48.jpg', 'jpg', '70925', 'image/jpeg', 'aoa_bursement', '2019-12-13 09:40:35', '3');
INSERT INTO `aoa_attachment_list` VALUES (233, '211565423296_.pic.jpg', '/2019/12/伊丽莎白/38cded02-4977-4b71-9f89-ef4f17eab186.jpg', 'jpg', '113490', 'image/jpeg', 'aoa_bursement', '2019-12-13 09:56:56', '3');
INSERT INTO `aoa_attachment_list` VALUES (234, '211565423296_.pic.jpg', '/2019/12/伊丽莎白/a75dd401-6fd9-4daa-9060-00e43bddc0a4.jpg', 'jpg', '113490', 'image/jpeg', 'aoa_bursement', '2019-12-13 19:23:21', '3');
INSERT INTO `aoa_attachment_list` VALUES (235, '171565423292_.pic.jpg', '/2019/12/伊丽莎白/8154cdd1-0a36-4631-ad9e-c6a24ae1c01d.jpg', 'jpg', '79989', 'image/jpeg', 'aoa_bursement', '2019-12-14 19:07:48', '3');
INSERT INTO `aoa_attachment_list` VALUES (236, '李子5.png', '/2019/12/伊丽莎白/94aa474d-ff09-473f-8453-6df2a0c60d86.png', 'png', '760454', 'image/png', 'aoa_bursement', '2019-12-14 19:47:32', '3');
INSERT INTO `aoa_attachment_list` VALUES (237, '191565423294_.pic.jpg', '/2019/12/伊丽莎白/47f565d7-226a-44fa-8750-4aabf9dd3cd3.jpg', 'jpg', '102541', 'image/jpeg', 'aoa_bursement', '2019-12-14 20:23:03', '3');
INSERT INTO `aoa_attachment_list` VALUES (238, '201565423295_.pic.jpg', '/2019/12/伊丽莎白/a76bedea-0785-4177-9132-910eb45a43e9.jpg', 'jpg', '103691', 'image/jpeg', 'aoa_bursement', '2019-12-14 21:13:21', '3');
INSERT INTO `aoa_attachment_list` VALUES (239, '181565423293_.pic.jpg', '/b3b6cd79-6b3c-437a-8c46-1fc6d19ce929.jpg', 'jpg', '150636', 'image/jpeg', 'aoa_bursement', '2019-12-14 21:53:17', '3');
INSERT INTO `aoa_attachment_list` VALUES (240, '141565423289_.pic.jpg', '/248e4273-f4b3-4c84-8571-7dbf3ad8991c.jpg', 'jpg', '84925', 'image/jpeg', 'aoa_bursement', '2019-12-14 22:15:18', '3');
INSERT INTO `aoa_attachment_list` VALUES (241, '211565423296_.pic.jpg', '/537a2ca0-8f96-458e-98e4-f291e39420b0.jpg', 'jpg', '113490', 'image/jpeg', 'aoa_bursement', '2019-12-14 22:23:55', '3');
INSERT INTO `aoa_attachment_list` VALUES (242, '191565423294_.pic.jpg', '/4fe66aa4-e620-4eaa-8e57-c8ea852edafc.jpg', 'jpg', '102541', 'image/jpeg', 'aoa_bursement', '2019-12-14 22:26:26', '3');
INSERT INTO `aoa_attachment_list` VALUES (243, '221565423297_.pic.jpg', '/ac70115e-62b5-4313-a19f-1ee87c4e596e.jpg', 'jpg', '55323', 'image/jpeg', 'aoa_bursement', '2019-12-14 22:30:02', '3');
COMMIT;

-- ----------------------------
-- Table structure for aoa_attends_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_attends_list`;
CREATE TABLE `aoa_attends_list` (
  `attends_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '考勤表ID',
  `attends_ip` varchar(20) DEFAULT NULL COMMENT '考勤表登录IP',
  `attends_remark` varchar(20) DEFAULT NULL COMMENT '考勤备注',
  `attends_time` datetime DEFAULT NULL COMMENT '考勤时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '考勤状态ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '考勤类型ID',
  `attends_user_id` bigint(20) DEFAULT NULL COMMENT '考勤用户ID',
  `attend_hmtime` varchar(255) DEFAULT NULL COMMENT '考勤时分',
  `week_ofday` varchar(255) DEFAULT NULL COMMENT '星期几',
  `holiday_days` double(255,0) DEFAULT '0' COMMENT '请假天数',
  `holiday_start` date DEFAULT NULL COMMENT '请假开始时间',
  PRIMARY KEY (`attends_id`),
  KEY `FKaxgqsm98npnl1rxysh9upfjee` (`attends_user_id`),
  CONSTRAINT `FKaxgqsm98npnl1rxysh9upfjee` FOREIGN KEY (`attends_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_attends_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_attends_list` VALUES (1, '127.0.0.1', '上班正常4', '2017-09-27 10:16:36', 12, 8, 26, '08:16', '星期三', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (3, '127.0.0.1', '下班正常', '2019-10-01 16:49:13', 10, 9, 15, '18:49', '星期二', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (12, NULL, NULL, '2017-09-28 22:17:16', 11, 8, 2, '22:17', '星期四', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (13, '192.168.43.91', '', '2019-09-20 22:35:24', 12, 9, 14, '21:35', '星期四', 2, '2019-09-01');
INSERT INTO `aoa_attends_list` VALUES (14, '192.168.43.91', '14号上班', '2019-09-17 09:04:10', 11, 8, 15, '09:50', '星期五', 1, '2019-09-01');
INSERT INTO `aoa_attends_list` VALUES (15, '192.168.43.91', '15号下班', '2019-09-18 18:49:42', 12, 9, 16, '18:00', '星期五', 2, '2019-09-01');
INSERT INTO `aoa_attends_list` VALUES (23, '192.168.43.91', '14号下班', '2019-09-20 09:03:20', 11, 8, 14, '10:08', '星期四', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (24, '192.168.43.91', '15号上班', '2019-09-18 10:49:32', 11, 8, 15, '11:49', '星期五', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (25, NULL, NULL, '2017-10-01 20:29:38', 10, 9, 2, '20:29', '星期日', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (27, NULL, NULL, '2017-10-02 18:53:15', 10, 9, 2, '18:53', '星期一', 3, NULL);
INSERT INTO `aoa_attends_list` VALUES (28, NULL, NULL, '2017-10-03 12:30:51', 11, 8, 2, '12:30', '星期二', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (29, NULL, NULL, '2017-10-05 13:26:12', 11, 8, 2, '13:26', '星期四', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (30, NULL, NULL, '2017-10-05 13:29:58', 12, 9, 2, '13:29', '星期四', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (31, NULL, NULL, '2017-10-07 16:11:07', 11, 8, 2, '16:11', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (32, NULL, NULL, '2017-10-07 16:24:15', 10, 9, 2, '16:24', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (33, NULL, NULL, '2017-10-08 10:19:24', 11, 8, 2, '10:19', '星期日', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (34, NULL, NULL, '2017-10-09 10:59:13', 11, 8, 2, '10:59', '星期一', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (35, '192.168.43.91', NULL, '2017-10-09 14:05:52', 12, 9, 2, '14:05', '星期一', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (36, '172.31.16.188', NULL, '2017-10-09 16:08:00', 11, 8, 1, '16:08', '星期一', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (37, '192.168.43.91', NULL, '2017-10-12 15:22:36', 11, 8, 1, '15:22', '星期四', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (39, '172.31.17.170', NULL, '2017-10-21 15:08:36', 11, 8, 5, '15:08', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (40, '172.31.17.170', NULL, '2017-10-21 15:09:16', 12, 9, 5, '15:09', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (41, '172.31.17.170', '娃娃们,你们好', '2019-10-07 15:09:58', 11, 9, 15, '15:09', '星期二', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (42, '172.31.17.170', NULL, '2017-10-21 15:10:05', 12, 9, 6, '15:10', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (43, '172.31.17.170', NULL, '2017-10-21 15:10:53', 11, 8, 7, '15:10', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (44, '172.31.17.170', NULL, '2017-10-21 15:11:09', 12, 9, 7, '15:11', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (45, '172.31.17.170', '迟到了 尴尬', '2019-10-07 09:03:34', 11, 8, 16, '16:03', '星期一', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (47, '172.31.17.170', NULL, '2017-10-21 16:18:39', 11, 8, 3, '16:18', '星期六', 0, NULL);
INSERT INTO `aoa_attends_list` VALUES (48, '192.168.1.233', NULL, '2017-10-22 10:28:57', 11, 8, 7, '10:28', '星期日', NULL, NULL);
INSERT INTO `aoa_attends_list` VALUES (49, NULL, NULL, NULL, NULL, 47, 5, NULL, NULL, 4, '2019-11-10');
INSERT INTO `aoa_attends_list` VALUES (50, NULL, NULL, NULL, NULL, 47, 5, NULL, NULL, 4, '2019-11-10');
COMMIT;

-- ----------------------------
-- Table structure for aoa_bursement
-- ----------------------------
DROP TABLE IF EXISTS `aoa_bursement`;
CREATE TABLE `aoa_bursement` (
  `bursement_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '费用报销表ID',
  `all_money` double DEFAULT NULL COMMENT '总钱数',
  `allinvoices` int(11) DEFAULT NULL COMMENT '票据总数',
  `burse_time` datetime DEFAULT NULL COMMENT '报销日期',
  `financial_advice` varchar(255) DEFAULT NULL COMMENT '财务意见说明',
  `manager_advice` varchar(255) DEFAULT NULL COMMENT '经理意见及说明',
  `name` varchar(255) DEFAULT NULL COMMENT '相关客户',
  `type_id` bigint(20) DEFAULT NULL COMMENT '报销方式（现金，刷卡）',
  `operation_name` bigint(20) DEFAULT NULL COMMENT '报销人员',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '流程主表ID',
  `user_name` bigint(20) DEFAULT NULL COMMENT '证明人',
  PRIMARY KEY (`bursement_id`),
  KEY `FKt3xu5y23deh0mtqkfk3ly6219` (`operation_name`),
  KEY `FK666vswh4nl3voq8qalu73v2sq` (`pro_id`),
  KEY `FKgnqp4eax31sh7mn3lt2su7olr` (`user_name`),
  CONSTRAINT `FK666vswh4nl3voq8qalu73v2sq` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`),
  CONSTRAINT `FKgnqp4eax31sh7mn3lt2su7olr` FOREIGN KEY (`user_name`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKt3xu5y23deh0mtqkfk3ly6219` FOREIGN KEY (`operation_name`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_bursement
-- ----------------------------
BEGIN;
INSERT INTO `aoa_bursement` VALUES (32, 10662, 6, '2019-11-10 18:10:09', NULL, '批准了', '老二', 26, 5, 111, 3);
COMMIT;

-- ----------------------------
-- Table structure for aoa_catalog
-- ----------------------------
DROP TABLE IF EXISTS `aoa_catalog`;
CREATE TABLE `aoa_catalog` (
  `catalog_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录id',
  `catalog_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '目录名字',
  `parent_id` int(11) DEFAULT NULL COMMENT '判断id',
  `cata_user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`catalog_id`),
  KEY `FKbsk5nkjlqmd8j9rmkarse6j1x` (`cata_user_id`),
  CONSTRAINT `FKbsk5nkjlqmd8j9rmkarse6j1x` FOREIGN KEY (`cata_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_catalog
-- ----------------------------
BEGIN;
INSERT INTO `aoa_catalog` VALUES (1, 'note', 1, 1);
INSERT INTO `aoa_catalog` VALUES (2, '诗词记录', 1, 1);
INSERT INTO `aoa_catalog` VALUES (9, '秒懂百科', 1, 2);
INSERT INTO `aoa_catalog` VALUES (11, '上课要案', 1, 3);
INSERT INTO `aoa_catalog` VALUES (12, '错题收集', 1, 3);
INSERT INTO `aoa_catalog` VALUES (32, '规划(3)', 1, 1);
INSERT INTO `aoa_catalog` VALUES (33, '根目录', 1, NULL);
INSERT INTO `aoa_catalog` VALUES (34, '规划(4)', 1, 1);
INSERT INTO `aoa_catalog` VALUES (35, '学习笔记', NULL, 5);
INSERT INTO `aoa_catalog` VALUES (39, '日常笔记(2)', NULL, 3);
INSERT INTO `aoa_catalog` VALUES (40, '日常笔记(3)', NULL, 3);
INSERT INTO `aoa_catalog` VALUES (41, '日常笔记(4)', NULL, 3);
COMMIT;

-- ----------------------------
-- Table structure for aoa_comment_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_comment_list`;
CREATE TABLE `aoa_comment_list` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论列表ID',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL COMMENT '评论时间',
  `comment_user_id` bigint(20) DEFAULT NULL COMMENT '评论人归属人ID',
  `reply_id` bigint(20) DEFAULT NULL COMMENT '回复表ID',
  PRIMARY KEY (`comment_id`),
  KEY `FK2k00kkfhh93949ybod7qn56ax` (`comment_user_id`),
  KEY `FKeopff14rxco5thbwwlu7exglo` (`reply_id`),
  CONSTRAINT `FK2k00kkfhh93949ybod7qn56ax` FOREIGN KEY (`comment_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKeopff14rxco5thbwwlu7exglo` FOREIGN KEY (`reply_id`) REFERENCES `aoa_reply_list` (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_comment_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_comment_list` VALUES (2, '范德萨发', '2017-10-01 22:07:29', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (8, '@朱丽叶 你要干嘛？', '2017-10-02 13:37:48', 1, 2);
INSERT INTO `aoa_comment_list` VALUES (9, '哇哇哇，interesting', '2017-10-02 13:38:20', 1, 3);
INSERT INTO `aoa_comment_list` VALUES (10, 'N这个死鬼', '2017-10-02 13:48:28', 1, 4);
INSERT INTO `aoa_comment_list` VALUES (15, '有什么问题么？', '2017-10-02 16:48:21', 1, 8);
INSERT INTO `aoa_comment_list` VALUES (21, 'fasd fds ', '2017-10-03 00:35:14', 1, 7);
INSERT INTO `aoa_comment_list` VALUES (23, '年轻人，年轻的一批', '2017-10-03 00:52:28', 1, 16);
INSERT INTO `aoa_comment_list` VALUES (24, '你要干嘛？', '2017-10-03 00:55:03', 1, 14);
INSERT INTO `aoa_comment_list` VALUES (25, ' 哇哇，你真的是过分呀', '2017-10-03 00:55:27', 1, 9);
INSERT INTO `aoa_comment_list` VALUES (26, '大四范德萨', '2017-10-03 01:03:01', 1, 17);
INSERT INTO `aoa_comment_list` VALUES (27, '范德萨发爱迪生', '2017-10-03 01:03:43', 1, 17);
INSERT INTO `aoa_comment_list` VALUES (29, '@罗密欧 你好；', '2017-10-03 11:20:37', 1, 17);
INSERT INTO `aoa_comment_list` VALUES (30, '@罗密欧 你好；；', '2017-10-03 11:21:25', 1, 17);
INSERT INTO `aoa_comment_list` VALUES (31, ' 回复你又没有问题；', '2017-10-03 11:22:06', 1, 18);
INSERT INTO `aoa_comment_list` VALUES (34, '发生大法师', '2017-10-04 01:33:18', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (35, '富士达发', '2017-10-04 01:36:40', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (36, '范德萨', '2017-10-04 01:36:48', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (37, '@朱丽叶 有意思', '2017-10-04 01:37:51', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (38, '你哟啊干嘛？', '2017-10-04 01:38:05', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (39, '@朱丽叶 回复可以么？', '2017-10-04 01:40:22', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (40, ' 来恢复把', '2017-10-04 01:41:28', 2, 62);
INSERT INTO `aoa_comment_list` VALUES (41, '第一次回复是可以的', '2017-10-04 01:45:47', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (42, '@朱丽叶 第二次回复', '2017-10-04 01:46:07', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (43, '@朱丽叶 第二次回复，第三次回复', '2017-10-04 01:46:25', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (44, '@朱丽叶  你就是朱丽叶呀', '2017-10-04 01:46:43', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (45, '@朱丽叶  你就是朱丽叶呀，我不是，我什么都不是', '2017-10-04 01:46:58', 2, 61);
INSERT INTO `aoa_comment_list` VALUES (46, ' 没有东西是吧', '2017-10-04 01:51:41', 2, 64);
INSERT INTO `aoa_comment_list` VALUES (47, '@朱丽叶  克可达', '2017-10-04 01:51:51', 2, 64);
INSERT INTO `aoa_comment_list` VALUES (48, '你要干啥？', '2017-10-04 01:52:00', 2, 64);
INSERT INTO `aoa_comment_list` VALUES (49, ' 我也想知道为什么？', '2017-10-04 01:53:02', 2, 66);
INSERT INTO `aoa_comment_list` VALUES (50, ' 来，再加一条', '2017-10-04 01:54:12', 2, 66);
INSERT INTO `aoa_comment_list` VALUES (51, '这一次试试', '2017-10-04 01:56:16', 2, 67);
INSERT INTO `aoa_comment_list` VALUES (52, '第八条', '2017-10-04 01:57:53', 2, 67);
INSERT INTO `aoa_comment_list` VALUES (53, ' 再试一下', '2017-10-04 01:59:52', 2, 67);
INSERT INTO `aoa_comment_list` VALUES (54, '发生', '2017-10-04 03:25:38', 2, 60);
INSERT INTO `aoa_comment_list` VALUES (55, '范德萨', '2017-10-04 03:25:43', 2, 60);
INSERT INTO `aoa_comment_list` VALUES (56, '@朱丽叶发 是粉色是', '2017-10-04 03:25:59', 2, 60);
INSERT INTO `aoa_comment_list` VALUES (57, '@朱丽叶 现在开始没有entity了', '2017-10-04 03:26:34', 2, 60);
INSERT INTO `aoa_comment_list` VALUES (58, ' 再是一次', '2017-10-04 03:29:28', 2, 60);
INSERT INTO `aoa_comment_list` VALUES (59, ' 回复一下', '2017-10-04 03:30:23', 2, 60);
INSERT INTO `aoa_comment_list` VALUES (60, ' 没有评论，我怎么办嘛\n', '2017-10-04 03:31:42', 2, 71);
INSERT INTO `aoa_comment_list` VALUES (61, '再来一次', '2017-10-04 03:31:56', 2, 72);
INSERT INTO `aoa_comment_list` VALUES (64, '@朱丽叶6666666', '2017-10-05 23:02:39', 2, 73);
INSERT INTO `aoa_comment_list` VALUES (65, '@朱丽叶 地方撒', '2017-10-05 23:03:14', 2, 73);
INSERT INTO `aoa_comment_list` VALUES (66, '@朱丽叶6767', '2017-10-05 23:04:05', 2, 73);
INSERT INTO `aoa_comment_list` VALUES (67, '@朱丽叶鼎折覆餗', '2017-10-05 23:04:24', 2, 73);
INSERT INTO `aoa_comment_list` VALUES (68, '让他', '2017-10-05 23:07:36', 2, 58);
INSERT INTO `aoa_comment_list` VALUES (69, '手动阀', '2017-10-05 23:07:47', 2, 58);
INSERT INTO `aoa_comment_list` VALUES (70, '@朱丽叶大', '2017-10-05 23:07:54', 2, 58);
INSERT INTO `aoa_comment_list` VALUES (71, '发生', '2017-10-05 23:18:47', 7, 73);
INSERT INTO `aoa_comment_list` VALUES (72, '@甄姬而我若', '2017-10-05 23:19:06', 7, 73);
INSERT INTO `aoa_comment_list` VALUES (73, ' 加一条评论', '2017-10-06 13:38:56', 1, 33);
INSERT INTO `aoa_comment_list` VALUES (74, ' 再加一条', '2017-10-06 13:39:19', 1, 33);
INSERT INTO `aoa_comment_list` VALUES (75, ' 哟哟\n', '2017-10-06 13:46:02', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (76, '@朱丽叶  回复有问题么？', '2017-10-06 13:46:13', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (81, '回复jia1', '2017-10-06 14:16:20', 2, 84);
INSERT INTO `aoa_comment_list` VALUES (82, ' 有问题么？', '2017-10-06 15:25:41', 2, 58);
INSERT INTO `aoa_comment_list` VALUES (83, '没有问题撒', '2017-10-06 16:53:48', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (84, '', '2017-10-06 16:54:05', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (85, '@朱丽叶 一点点小小的问题', '2017-10-06 16:54:05', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (86, '', '2017-10-06 16:54:18', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (87, '@朱丽叶 ？？', '2017-10-06 16:54:18', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (88, '', '2017-10-06 16:54:18', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (89, '', '2017-10-06 16:54:18', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (90, ' 不知道发生什么问题了', '2017-10-06 16:56:22', 2, 2);
INSERT INTO `aoa_comment_list` VALUES (91, '该配合你演出的我视而不见???', '2017-10-08 15:24:03', 8, 73);
INSERT INTO `aoa_comment_list` VALUES (92, '@罗密欧 好吧，你很棒棒', '2017-10-08 15:27:41', 8, 3);
INSERT INTO `aoa_comment_list` VALUES (93, '@朱丽叶888', '2019-12-15 16:21:27', 3, 73);
INSERT INTO `aoa_comment_list` VALUES (94, 'pppp', '2019-12-15 16:22:16', 3, 73);
INSERT INTO `aoa_comment_list` VALUES (95, 'ooo', '2019-12-15 16:23:23', 3, 73);
INSERT INTO `aoa_comment_list` VALUES (96, '回复一楼', '2019-12-17 23:09:43', 3, 47);
INSERT INTO `aoa_comment_list` VALUES (97, '@伊丽莎白再次伊丽莎白回复001', '2019-12-17 23:10:45', 3, 47);
INSERT INTO `aoa_comment_list` VALUES (98, '回复评论001', '2019-12-18 09:57:59', 3, 91);
INSERT INTO `aoa_comment_list` VALUES (99, '@伊丽莎白在此回复伊丽莎白', '2019-12-18 10:04:23', 3, 91);
INSERT INTO `aoa_comment_list` VALUES (100, '@伊丽莎白二次评论啦', '2019-12-18 10:15:23', 3, 91);
INSERT INTO `aoa_comment_list` VALUES (101, '@伊丽莎白 第三次评论啦', '2019-12-18 10:17:30', 3, 91);
INSERT INTO `aoa_comment_list` VALUES (102, '@伊丽莎白 第四次评论', '2019-12-18 10:19:44', 3, 91);
INSERT INTO `aoa_comment_list` VALUES (103, '回复啦001', '2019-12-19 09:01:55', 3, 6);
COMMIT;

-- ----------------------------
-- Table structure for aoa_dept
-- ----------------------------
DROP TABLE IF EXISTS `aoa_dept`;
CREATE TABLE `aoa_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_addr` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门地址',
  `dept_fax` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '传真',
  `dept_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门名字',
  `dept_tel` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门电话',
  `email` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门email',
  `deptmanager` bigint(20) DEFAULT NULL COMMENT '部门领导ID',
  `end_time` datetime DEFAULT NULL COMMENT '部门下班时间',
  `start_time` datetime DEFAULT NULL COMMENT '部门上班时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_dept
-- ----------------------------
BEGIN;
INSERT INTO `aoa_dept` VALUES (1, '五楼', '你好吗', '总经办', '000111', '666666@fjhirg.com', 28, NULL, NULL);
INSERT INTO `aoa_dept` VALUES (2, '四楼', NULL, '研发部', '66666666', 'as@fwgh', 9, '2017-09-13 19:04:07', '2010-05-23 00:00:00');
INSERT INTO `aoa_dept` VALUES (3, '三楼', NULL, '财务部', '233333', '153@qq.com', 5, '2017-09-19 16:46:26', '2016-09-19 16:46:32');
INSERT INTO `aoa_dept` VALUES (4, '六楼', NULL, '市场部', '666888', 'aaluoxiang@foxmail.com', 6, '2016-07-19 16:48:09', '2014-09-19 16:48:20');
INSERT INTO `aoa_dept` VALUES (5, '六楼', '你好', '人事部', '99999999', '0000999@qq.com', 2, NULL, NULL);
INSERT INTO `aoa_dept` VALUES (21, '十五楼', '加油', '亲友队', '123456', '666666@fjhirg.com', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_detailsburse
-- ----------------------------
DROP TABLE IF EXISTS `aoa_detailsburse`;
CREATE TABLE `aoa_detailsburse` (
  `detailsburse_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descript` varchar(255) DEFAULT NULL,
  `detailmoney` double NOT NULL,
  `invoices` int(11) DEFAULT NULL,
  `produce_time` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `bursment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`detailsburse_id`),
  KEY `FKi02w0bghxr73fsc5sbpeyqdnn` (`bursment_id`),
  CONSTRAINT `FKi02w0bghxr73fsc5sbpeyqdnn` FOREIGN KEY (`bursment_id`) REFERENCES `aoa_bursement` (`bursement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_detailsburse
-- ----------------------------
BEGIN;
INSERT INTO `aoa_detailsburse` VALUES (24, '买东西啦啦', 9875, 4, '2019-11-10 18:08:27', '车辆油费', 32);
INSERT INTO `aoa_detailsburse` VALUES (25, '水果', 787, 2, '2019-11-08 18:09:33', '招待费', 32);
COMMIT;

-- ----------------------------
-- Table structure for aoa_director
-- ----------------------------
DROP TABLE IF EXISTS `aoa_director`;
CREATE TABLE `aoa_director` (
  `director_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '外部通讯录表ID',
  `address` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户地址',
  `company_number` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '公司电话',
  `email` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户邮箱',
  `image_path` int(11) DEFAULT NULL COMMENT '用户图像',
  `phone_number` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户电话',
  `pinyin` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户名拼音',
  `remark` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '备注',
  `sex` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '性别',
  `user_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户名',
  `user_id` bigint(20) DEFAULT NULL COMMENT '创建此外部通讯录用户ID',
  `companyname` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '公司名',
  PRIMARY KEY (`director_id`),
  KEY `FKi6pfdnqhbc6js940e2o1vape5` (`user_id`),
  CONSTRAINT `FKi6pfdnqhbc6js940e2o1vape5` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_director
-- ----------------------------
BEGIN;
INSERT INTO `aoa_director` VALUES (1, '', '', '153@qq.com', NULL, '18173328976', 'zhangsan', '', '男', '张三', 1, '百度科技有限公司');
INSERT INTO `aoa_director` VALUES (2, '35栋517', '66666', '123@qq.com', NULL, '18634344455', 'xiongtao', 'nice！', '男', '熊涛', 1, '517小分队');
INSERT INTO `aoa_director` VALUES (3, '湖南省株洲市', '10023', '153@gmail.com', NULL, '18877665544', 'wangwu', '范德萨', '男', '王五', 1, 'google公司');
INSERT INTO `aoa_director` VALUES (5, '湖南省株洲市天元区', '96578888888', '1899999@qq.com', NULL, '18899999900', 'zhangqifeng', '卫龙、你爱吗？，我不是很爱', '女', '张奇风', 2, '辣条有限公司+百度');
INSERT INTO `aoa_director` VALUES (6, '34栋', '888666', '188@qq.com', NULL, '18866554433', 'songjia', '宋氏集团总裁', '男', '宋佳', 1, '宋氏集团');
INSERT INTO `aoa_director` VALUES (7, '泰山西路', '41233243', '123@qq.com', NULL, '18877665544', 'xiaoli', '没有什么备注', '男', '小李', 2, 'xi小小公司');
INSERT INTO `aoa_director` VALUES (8, '湖工大', '98877', '123@qq.com', NULL, '18877665544', 'xiongxiong', 'interesting', '男', '熊熊', 1, '工大ccu');
INSERT INTO `aoa_director` VALUES (9, '35栋517', '517666', 'asdf@163.com', NULL, '18899887766', 'xuxu', '小分队的名字不错', '男', 'xuxu', 1, '517小分队');
INSERT INTO `aoa_director` VALUES (10, '团员去', '98877', '12345@qq.com', NULL, '18173328976', 'aa', '有事', '男', 'aa', 18, 'google');
INSERT INTO `aoa_director` VALUES (11, 'timg.jpeg', '12342', '12345@qq.com', 73, '18876665544', 'wanglaowu', '有意思', '男', '王老五', 5, '联通');
INSERT INTO `aoa_director` VALUES (12, '湖南工业大学', '12415', '8888888@qq.com', 228, '13356789090', 'dierfenlei01', '天猫001', '男', '第二分类01', 3, '天猫01');
INSERT INTO `aoa_director` VALUES (13, '湖南工业大学', '12415', '8888888@qq.com', 229, '13512341234', 'lin02', '天猫02天猫02', '男', 'lin02', 3, '天猫02');
INSERT INTO `aoa_director` VALUES (14, '泰山西路', '12415', '8888888@qq.com', 230, '13899859987', 'lin03', '天猫03天猫03天猫03天猫03', '男', 'lin03', 3, '天猫03');
INSERT INTO `aoa_director` VALUES (27, '湖南工业大学', '12415', '8888888@qq.com', 243, '13590897898', 'tupian008', '图片008图片008图片008', '女', '图片008', 3, '图片008图片008');
COMMIT;

-- ----------------------------
-- Table structure for aoa_director_users
-- ----------------------------
DROP TABLE IF EXISTS `aoa_director_users`;
CREATE TABLE `aoa_director_users` (
  `director_users_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录用户表ID',
  `catelog_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '外部通讯录的目录名',
  `is_handle` int(11) DEFAULT NULL COMMENT '内外部要不用户0内部1外部',
  `director_id` bigint(20) DEFAULT NULL COMMENT '外部通讯录ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '被分享人用户ID',
  `share_user_id` bigint(20) DEFAULT NULL COMMENT '分享人ID（主动）',
  `sharetime` datetime DEFAULT NULL COMMENT '分享时间',
  PRIMARY KEY (`director_users_id`),
  KEY `FK675oqfmv4kx9w6bgi9rgsb8nw` (`director_id`),
  KEY `FK7hq4xk2ja9eka4210qkqq03hi` (`user_id`),
  KEY `FKibwkjvmp9383ltkfew1kyy6ny` (`share_user_id`),
  CONSTRAINT `FK675oqfmv4kx9w6bgi9rgsb8nw` FOREIGN KEY (`director_id`) REFERENCES `aoa_director` (`director_id`),
  CONSTRAINT `FK7hq4xk2ja9eka4210qkqq03hi` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKibwkjvmp9383ltkfew1kyy6ny` FOREIGN KEY (`share_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_director_users
-- ----------------------------
BEGIN;
INSERT INTO `aoa_director_users` VALUES (2, '大学咯', 1, 2, 1, NULL, '2017-10-15 18:49:46');
INSERT INTO `aoa_director_users` VALUES (4, '大学同学', 1, NULL, 2, NULL, NULL);
INSERT INTO `aoa_director_users` VALUES (5, '', 1, 5, 1, NULL, NULL);
INSERT INTO `aoa_director_users` VALUES (10, '', 1, 1, 1, NULL, NULL);
INSERT INTO `aoa_director_users` VALUES (14, '', 1, 6, 1, NULL, '2017-10-15 18:39:36');
INSERT INTO `aoa_director_users` VALUES (15, '同学情', 1, 3, 2, 1, '2017-10-14 16:20:49');
INSERT INTO `aoa_director_users` VALUES (19, NULL, 1, 1, 3, 1, '2017-10-14 16:30:26');
INSERT INTO `aoa_director_users` VALUES (20, '小李父斯基的分类', 1, 1, 4, 1, '2017-10-14 16:30:27');
INSERT INTO `aoa_director_users` VALUES (21, NULL, 0, 1, 5, 1, '2017-10-14 16:30:27');
INSERT INTO `aoa_director_users` VALUES (22, '重要客户', 1, 5, 2, 1, '2017-10-14 16:31:31');
INSERT INTO `aoa_director_users` VALUES (23, NULL, 1, 5, 3, 1, '2017-10-14 16:31:31');
INSERT INTO `aoa_director_users` VALUES (25, NULL, 0, 5, 5, 1, '2017-10-14 16:31:31');
INSERT INTO `aoa_director_users` VALUES (26, NULL, 1, 3, 8, 1, '2017-10-14 16:32:35');
INSERT INTO `aoa_director_users` VALUES (27, NULL, 0, 3, 10, 1, '2017-10-14 16:33:23');
INSERT INTO `aoa_director_users` VALUES (28, NULL, 0, 2, 9, 1, '2017-10-14 16:37:02');
INSERT INTO `aoa_director_users` VALUES (29, NULL, 0, 6, 6, 1, '2017-10-14 16:39:48');
INSERT INTO `aoa_director_users` VALUES (30, NULL, 0, 3, 14, 1, '2017-10-14 16:40:55');
INSERT INTO `aoa_director_users` VALUES (31, NULL, 0, 3, 22, 1, '2017-10-14 16:42:22');
INSERT INTO `aoa_director_users` VALUES (32, '', 1, 3, 23, 1, '2017-10-14 16:48:06');
INSERT INTO `aoa_director_users` VALUES (33, NULL, 0, 5, 14, 1, '2017-10-14 16:48:39');
INSERT INTO `aoa_director_users` VALUES (34, '重要客户', 1, 7, 1, 2, '2017-10-14 21:46:48');
INSERT INTO `aoa_director_users` VALUES (36, '', 1, 8, 1, NULL, '2017-10-15 18:46:05');
INSERT INTO `aoa_director_users` VALUES (37, '大学咯', 0, NULL, 1, NULL, '2017-10-15 18:48:56');
INSERT INTO `aoa_director_users` VALUES (38, NULL, 0, NULL, 1, NULL, '2017-10-15 18:50:57');
INSERT INTO `aoa_director_users` VALUES (39, NULL, 1, 9, 1, NULL, '2017-10-15 18:52:05');
INSERT INTO `aoa_director_users` VALUES (40, '重要客户', 0, NULL, 1, NULL, '2017-10-15 18:53:02');
INSERT INTO `aoa_director_users` VALUES (41, '同学情', 0, NULL, 2, NULL, '2017-10-15 18:58:34');
INSERT INTO `aoa_director_users` VALUES (42, NULL, 0, NULL, 3, NULL, '2017-10-15 19:01:00');
INSERT INTO `aoa_director_users` VALUES (43, '第二分类', 0, NULL, 3, NULL, '2017-10-15 19:01:35');
INSERT INTO `aoa_director_users` VALUES (44, '小李父斯基的分类', 0, NULL, 4, NULL, '2017-10-15 19:11:54');
INSERT INTO `aoa_director_users` VALUES (45, NULL, 0, 1, 7, 4, '2017-10-15 19:13:26');
INSERT INTO `aoa_director_users` VALUES (46, NULL, 0, 1, 8, 4, '2017-10-15 19:13:26');
INSERT INTO `aoa_director_users` VALUES (47, NULL, 0, 1, 9, 4, '2017-10-15 19:13:27');
INSERT INTO `aoa_director_users` VALUES (48, 'yoyo', 0, NULL, 4, NULL, '2017-10-15 23:54:26');
INSERT INTO `aoa_director_users` VALUES (49, NULL, 0, 5, 7, 4, '2017-10-15 23:54:50');
INSERT INTO `aoa_director_users` VALUES (50, '', 1, 10, 18, NULL, '2017-10-18 19:54:11');
INSERT INTO `aoa_director_users` VALUES (51, 'aaa', 0, NULL, 18, NULL, '2017-10-18 19:54:46');
INSERT INTO `aoa_director_users` VALUES (52, '', 1, 11, 5, NULL, '2017-10-19 23:37:37');
INSERT INTO `aoa_director_users` VALUES (53, NULL, 0, 3, 9, 23, '2018-02-03 22:16:38');
INSERT INTO `aoa_director_users` VALUES (54, NULL, 0, 3, 13, 23, '2018-02-03 22:20:57');
INSERT INTO `aoa_director_users` VALUES (55, NULL, 0, 5, 11, 1, '2018-02-03 22:34:09');
INSERT INTO `aoa_director_users` VALUES (56, '', 0, NULL, 3, NULL, '2019-12-10 18:08:18');
INSERT INTO `aoa_director_users` VALUES (63, NULL, 0, 12, 1, 3, '2019-12-13 10:06:11');
INSERT INTO `aoa_director_users` VALUES (64, NULL, 0, 12, 2, 3, '2019-12-13 10:06:11');
INSERT INTO `aoa_director_users` VALUES (65, NULL, 0, 12, 4, 3, '2019-12-13 10:06:11');
INSERT INTO `aoa_director_users` VALUES (66, NULL, 0, 12, 6, 3, '2019-12-13 10:06:11');
INSERT INTO `aoa_director_users` VALUES (68, NULL, 0, 12, 12, 3, '2019-12-13 17:32:11');
INSERT INTO `aoa_director_users` VALUES (69, NULL, 0, 12, 28, 3, '2019-12-13 17:32:21');
INSERT INTO `aoa_director_users` VALUES (70, NULL, 0, 13, 1, 3, '2019-12-13 19:33:10');
INSERT INTO `aoa_director_users` VALUES (71, NULL, 0, 13, 2, 3, '2019-12-13 19:33:10');
INSERT INTO `aoa_director_users` VALUES (72, NULL, 0, 13, 4, 3, '2019-12-13 19:33:10');
INSERT INTO `aoa_director_users` VALUES (73, NULL, 0, 13, 12, 3, '2019-12-13 19:33:10');
INSERT INTO `aoa_director_users` VALUES (74, NULL, 0, 12, 9, 3, '2019-12-13 19:38:20');
INSERT INTO `aoa_director_users` VALUES (75, NULL, 0, 14, 1, 3, '2019-12-13 19:41:28');
INSERT INTO `aoa_director_users` VALUES (76, NULL, 0, 14, 2, 3, '2019-12-13 19:41:28');
INSERT INTO `aoa_director_users` VALUES (77, NULL, 0, NULL, 3, NULL, '2019-12-13 23:28:19');
INSERT INTO `aoa_director_users` VALUES (78, '', 0, NULL, 3, NULL, '2019-12-13 23:40:19');
INSERT INTO `aoa_director_users` VALUES (79, '第三分类', 0, NULL, 3, NULL, '2019-12-14 19:06:30');
INSERT INTO `aoa_director_users` VALUES (88, '第三分类', 1, 27, 3, NULL, '2019-12-14 22:30:04');
COMMIT;

-- ----------------------------
-- Table structure for aoa_discuss_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_discuss_list`;
CREATE TABLE `aoa_discuss_list` (
  `discuss_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '讨论表ID',
  `attachment_id` int(11) DEFAULT NULL COMMENT '附件ID',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `visit_num` int(11) DEFAULT NULL COMMENT '访问量',
  `discuss_user_id` bigint(20) DEFAULT NULL COMMENT '讨论归属人ID',
  `vote_id` bigint(20) DEFAULT NULL COMMENT '投票ID',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`discuss_id`),
  KEY `FKt8hvx0ai5fto20mmxmy2g8j4g` (`discuss_user_id`),
  KEY `FK17yi8arj4vjdr5mm5dhjov10j` (`vote_id`),
  CONSTRAINT `FK17yi8arj4vjdr5mm5dhjov10j` FOREIGN KEY (`vote_id`) REFERENCES `aoa_vote_list` (`vote_id`),
  CONSTRAINT `FKt8hvx0ai5fto20mmxmy2g8j4g` FOREIGN KEY (`discuss_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_discuss_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_discuss_list` VALUES (1, NULL, 'fdsfasfdsfasfsa', '2017-09-29 21:48:28', NULL, 'fsda', 19, 43, 1, NULL, '2017-09-29 21:48:28');
INSERT INTO `aoa_discuss_list` VALUES (6, NULL, '富士达奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥', '2017-09-29 21:48:28', NULL, 'what????', 20, 16, 2, NULL, '2017-10-04 18:06:39');
INSERT INTO `aoa_discuss_list` VALUES (7, NULL, '发生地方撒范德萨反反复复付付付付付付付付付付付付8', '2017-09-30 13:07:03', NULL, '发生富士达', 19, 20, 2, NULL, '2017-10-05 22:58:38');
INSERT INTO `aoa_discuss_list` VALUES (8, NULL, 'fsdaaaaaaaaaaaaaaafsaaaaaaaaaaa', '2017-09-30 13:12:33', NULL, '同一人', 19, 32, 2, NULL, '2017-10-05 22:59:02');
INSERT INTO `aoa_discuss_list` VALUES (9, NULL, '发生的多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多', '2017-09-30 13:16:51', NULL, '范德萨', 20, 11, 2, NULL, '2017-09-30 13:07:03');
INSERT INTO `aoa_discuss_list` VALUES (12, NULL, 'fsdaaaaaaaaaaaaaaafsaaaaaaaaaaa', '2017-09-30 15:30:26', NULL, '修改了这个名字2333', 19, 96, 2, NULL, '2017-10-04 21:24:09');
INSERT INTO `aoa_discuss_list` VALUES (13, NULL, '<p>\r\n	今天还是不错的，完成了一些内容，比如：修复了分页的小bug；还有一些其他的东西；再把讨论区好好的晚上一下\r\n</p>', '2017-10-01 14:25:26', NULL, '第一天的公告,++小整合', 19, 359, 1, NULL, '2017-10-01 14:25:26');
INSERT INTO `aoa_discuss_list` VALUES (14, NULL, 'afsdddddddd fasdddddddddddddddd', '2017-10-01 14:37:39', NULL, 'fads ', 19, 29, 1, NULL, '2017-10-01 14:37:39');
INSERT INTO `aoa_discuss_list` VALUES (15, NULL, 'afsddddddddddddddddddddddddddddddddddddddd', '2017-10-01 14:40:08', NULL, 'dsaf', 19, 26, 1, NULL, '2017-10-01 14:40:08');
INSERT INTO `aoa_discuss_list` VALUES (17, NULL, '<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	每个对象在出生的时候就有一把钥匙（监视器Monitor），那么被synchronized 修饰的方法相当于给方法加了一个锁，这个方法就可以进行同步，在多线程的时候，不会出现线程安全问题。\r\n</p>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	<span>注：Monitor是 Java中用以实现线程之间的互斥与协作的主要手段，它可以看成是对象或者 Class的锁。每一个对象都有，也仅有一个 Monitor。</span>\r\n</p>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	下面通过一张图片进行讲解：\r\n</p>\r\n<h4 id=\"1一张图片\" style=\"font-family:&quot;font-weight:300;color:#3F3F3F;font-size:1.25em;background-color:#FFFFFF;\">\r\n	<a name=\"t0\"></a>1.一张图片\r\n</h4>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	<span>图片看不清，请点击这里 ：</span>&nbsp;<a href=\"http://img.blog.csdn.net/20170929230249738?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMDY0ODU1NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" target=\"_blank\">高清大图</a>\r\n</p>\r\n<p style=\"color:#3F3F3F;font-family:&quot;background-color:#FFFFFF;\">\r\n	<img src=\"http://img.blog.csdn.net/20170929230249738?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMDY0ODU1NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\" title=\"\" style=\"height:auto;\" />\r\n</p>\r\n<h4 id=\"2图片对应的代码\" style=\"font-family:&quot;font-weight:300;color:#3F3F3F;font-size:1.25em;background-color:#FFFFFF;\">\r\n	<a name=\"t1\"></a>2.图片对应的代码\r\n</h4>\r\n<pre class=\"prettyprint\"><span class=\"hljs-keyword\" style=\"color:#000088;\">import</span> java.util.Date; <span class=\"hljs-javadoc\" style=\"color:#880000;\">/**\r\n * 测试的object类\r\n *\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @author</span>:dufy\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @version</span>:1.0.0\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @date</span> 2017/9/29\r\n *<span class=\"hljs-javadoctag\" style=\"color:#660066;\"> @email</span> 742981086@qq.com\r\n */</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-class\"><span class=\"hljs-keyword\" style=\"color:#000088;\">class</span> <span class=\"hljs-title\" style=\"color:#660066;\">ObjectTest</span> {</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">synchronized</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">void</span> <span class=\"hljs-title\">methodA</span>(){ <span class=\"hljs-keyword\" style=\"color:#000088;\">try</span> {\r\n            System.out.println(<span class=\"hljs-string\" style=\"color:#008800;\">\"This is methodA ....\"</span> + Thread.currentThread().getName() + <span class=\"hljs-string\" style=\"color:#008800;\">\": \"</span> + <span class=\"hljs-keyword\" style=\"color:#000088;\">new</span> Date());\r\n            Thread.sleep(<span class=\"hljs-number\" style=\"color:#006666;\">1000</span>);\r\n        } <span class=\"hljs-keyword\" style=\"color:#000088;\">catch</span> (InterruptedException e) {\r\n            e.printStackTrace();\r\n        }\r\n\r\n    } <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">void</span> <span class=\"hljs-title\">methodB</span>(){\r\n\r\n        System.out.println(<span class=\"hljs-string\" style=\"color:#008800;\">\"This is methodB ....\"</span> + Thread.currentThread().getName() + <span class=\"hljs-string\" style=\"color:#008800;\">\": \"</span> + <span class=\"hljs-keyword\" style=\"color:#000088;\">new</span> Date());\r\n    } <span class=\"hljs-keyword\" style=\"color:#000088;\">public</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">synchronized</span> <span class=\"hljs-keyword\" style=\"color:#000088;\">void</span> <span class=\"hljs-title\">methodC</span>(){ <span class=\"hljs-keyword\" style=\"color:#000088;\">try</span> {\r\n            System.out.println(<span class=\"hljs-string\" style=\"color:#008800;\">\"This is methodC ....\"</span> + Thread.currentThread().getName() + <span class=\"hljs-string\" style=\"color:#008800;\">\": \"</span> + <span class=\"hljs-keyword\" style=\"color:#000088;\">new</span> Date());\r\n            Thread.sleep(<span class=\"hljs-number\" style=\"color:#006666;\">3000</span>);\r\n        } <span class=\"hljs-keyword\" style=\"color:#000088;\">catch</span> (InterruptedException e) {\r\n            e.printStackTrace();\r\n        }\r\n\r\n    }\r\n\r\n\r\n}</pre>', '2017-10-01 15:18:40', NULL, 'fsdaaaaaaaaaa ', 21, 8, 1, NULL, '2017-10-01 15:18:40');
INSERT INTO `aoa_discuss_list` VALUES (23, NULL, 'afdsssssssssssssssssssssssssssssssssssssssssfffffffffffffffffHHHHHHFFFFFFFFFF1111112222222', '2017-10-01 16:38:44', NULL, 'yyyyyyyyyyHHHHHHHHHFFFFFF11111112222', 21, 4, 1, NULL, '2017-10-01 16:38:44');
INSERT INTO `aoa_discuss_list` VALUES (31, NULL, '投票标题test1111投票标题test1111投票标题test1111投票标题test1111', '2017-10-03 21:53:12', NULL, '投票标题test1111', 21, 15, 2, 1, '2017-10-03 21:53:12');
INSERT INTO `aoa_discuss_list` VALUES (32, NULL, '他的44444他的44444他的44444他的44444', '2017-10-03 21:55:10', NULL, '他的44444', 21, 71, 2, 2, '2017-10-03 21:55:09');
INSERT INTO `aoa_discuss_list` VALUES (33, NULL, '&nbsp;投票的测试&nbsp;投票的测试&nbsp;投票的测试&nbsp;投票的测试', '2017-10-03 23:25:08', NULL, ' 投票的测试随机颜色的测试', 21, 92, 2, 3, '2017-10-03 23:25:07');
INSERT INTO `aoa_discuss_list` VALUES (34, NULL, '这是一个多选的投票这是一个多选的投票这是一个多选的投票', '2017-10-04 02:58:16', NULL, '这是一个多选的投票', 21, 16, 2, 4, '2017-10-04 02:58:15');
INSERT INTO `aoa_discuss_list` VALUES (35, NULL, '想去哪个地方，尽情发言，，，，，，，反正我们也不会去的，<img src=\"http://localhost:8080/plugins/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost:8080/plugins/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost:8080/plugins/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" />', '2017-10-04 03:19:52', NULL, '旅欧地点投票，单选', 21, 24, 2, 5, '2017-10-04 03:19:52');
INSERT INTO `aoa_discuss_list` VALUES (37, NULL, '未开始时间投票测试未开始时间投票测试未开始时间投票测试', '2017-10-04 15:27:36', NULL, 'xiugai ；未开始时间投票测试', 21, 23, 2, 7, '2017-10-04 18:05:52');
INSERT INTO `aoa_discuss_list` VALUES (38, NULL, 'dfasfsdfafdsfsfasddddddddddddddddddd222', '2017-10-04 16:01:49', NULL, '修改d  ;我知道能够修改成功,在修改依稀呢？', 21, 10, 2, 8, '2017-10-04 18:03:16');
INSERT INTO `aoa_discuss_list` VALUES (39, NULL, '333333333333333333333333333333333333333333333333333333', '2017-10-05 22:54:27', NULL, '电风扇', 21, 1, 2, 9, '2017-10-05 22:54:26');
INSERT INTO `aoa_discuss_list` VALUES (40, NULL, '<h2>\r\n	这是投票11234这是投票11234这是投票11234这是投票11234这是投票11234这是投票11234这是投票11234\r\n</h2>', '2017-10-05 22:57:41', NULL, '这是投票11234', 21, 2, 2, 10, '2017-10-05 22:57:41');
INSERT INTO `aoa_discuss_list` VALUES (41, NULL, '4555555555555555555555555555555555555555555', '2017-10-05 22:58:29', NULL, '手动阀123', 21, 3, 2, 11, '2017-10-06 17:03:53');
INSERT INTO `aoa_discuss_list` VALUES (42, NULL, '4444444444444这是投票11234这是投票11234', '2017-10-05 23:17:52', NULL, '大师傅', 20, 4, 7, NULL, '2017-10-05 23:17:52');
INSERT INTO `aoa_discuss_list` VALUES (43, NULL, '188@qq.com188@qq.com188@qq.com188@qq.com188@qq.com188@qq.com', '2017-10-05 23:25:50', NULL, '范德萨', 21, 2, 7, 12, '2017-10-05 23:25:50');
INSERT INTO `aoa_discuss_list` VALUES (51, NULL, '多选投票多选投票多选投票多选投票多选投票多选投票多选投票多选投票多选投票多选投票', '2019-12-20 14:54:08', NULL, '多选投票', 21, 2, 3, 19, '2019-12-20 14:54:08');
INSERT INTO `aoa_discuss_list` VALUES (52, NULL, '第二次多选投票第二次多选投票第二次多选投票第二次多选投票第二次多选投票第二次多选投票第二次多选投票', '2019-12-20 14:58:42', NULL, '第二次多选投票', 21, 4, 3, 20, '2019-12-20 14:58:42');
INSERT INTO `aoa_discuss_list` VALUES (53, NULL, '有事找你001有事找你001有事找你001有事找你001有事找你001有事找你001有事找你001有事找你001', '2019-12-20 15:04:02', NULL, '有事找你001', 21, 6, 3, 21, '2019-12-20 15:04:02');
INSERT INTO `aoa_discuss_list` VALUES (55, NULL, '伊丽莎白的投票伊丽莎白的投票伊丽莎白的投票伊丽莎白的投票伊丽莎白的投票伊丽莎白的投票伊丽莎白的投票伊丽莎白的投票', '2019-12-20 19:52:59', NULL, '伊丽莎白的投票', 21, 11, 3, 22, '2019-12-20 19:52:59');
INSERT INTO `aoa_discuss_list` VALUES (56, NULL, '伊丽莎白的投票2伊丽莎白的投票2伊丽莎白的投票2伊丽莎白的投票2伊丽莎白的投票2伊丽莎白的投票2', '2019-12-20 19:54:05', NULL, '伊丽莎白的投票2', 21, 15, 3, 23, '2019-12-20 19:54:05');
COMMIT;

-- ----------------------------
-- Table structure for aoa_evection
-- ----------------------------
DROP TABLE IF EXISTS `aoa_evection`;
CREATE TABLE `aoa_evection` (
  `evection_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '出差表ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事意见',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '领导意见',
  PRIMARY KEY (`evection_id`),
  KEY `FKql1c10e5u2vefisjqjbu2d5pa` (`pro_id`),
  CONSTRAINT `FKql1c10e5u2vefisjqjbu2d5pa` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_evection
-- ----------------------------
BEGIN;
INSERT INTO `aoa_evection` VALUES (25, 29, 113, NULL, '可以可以');
INSERT INTO `aoa_evection` VALUES (26, 28, 118, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (27, 28, 119, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (28, 28, 120, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (29, 28, 121, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (30, 28, 122, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (31, 28, 123, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (32, 28, 124, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (33, 28, 125, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (34, 28, 126, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (35, 28, 127, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (36, 28, 128, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (37, 28, 129, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (38, 28, 130, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (39, 28, 131, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (40, 28, 133, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (41, 28, 134, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (42, 28, 135, NULL, NULL);
INSERT INTO `aoa_evection` VALUES (43, 28, 136, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_evectionmoney
-- ----------------------------
DROP TABLE IF EXISTS `aoa_evectionmoney`;
CREATE TABLE `aoa_evectionmoney` (
  `evectionmoney_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '费用报销表ID',
  `financial_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '财务意见',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '经理意见',
  `money` double DEFAULT NULL COMMENT '钱数',
  `name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '关联客户',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '流程主表ID',
  `pro` int(255) DEFAULT NULL,
  PRIMARY KEY (`evectionmoney_id`),
  KEY `FKcpuubnshaf2cg47hns9m0h1dq` (`pro_id`),
  CONSTRAINT `FKcpuubnshaf2cg47hns9m0h1dq` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_evectionmoney
-- ----------------------------
BEGIN;
INSERT INTO `aoa_evectionmoney` VALUES (11, NULL, 'bu xing', 3200, '老二', 112, NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_file_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_file_list`;
CREATE TABLE `aoa_file_list` (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_shuffix` varchar(255) DEFAULT NULL COMMENT '文件后缀名',
  `content_type` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '文件类型',
  `model` varchar(255) DEFAULT NULL COMMENT '所属模块',
  `path_id` bigint(20) DEFAULT NULL COMMENT '路径表ID',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `file_user_id` bigint(20) DEFAULT NULL COMMENT '文件关联用户表ID',
  `file_istrash` bigint(1) unsigned zerofill DEFAULT '0' COMMENT '是否是垃圾文件0不是1是',
  `file_isshare` bigint(20) DEFAULT NULL COMMENT '是否是分享文件',
  PRIMARY KEY (`file_id`),
  KEY `FKfshy9n300pqxjsweo9247jgqs` (`path_id`),
  KEY `FKlj6l9qroivus28aiqluue4bew` (`file_user_id`),
  CONSTRAINT `FKfshy9n300pqxjsweo9247jgqs` FOREIGN KEY (`path_id`) REFERENCES `aoa_file_path` (`path_id`),
  CONSTRAINT `FKlj6l9qroivus28aiqluue4bew` FOREIGN KEY (`file_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_file_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_file_list` VALUES (11, '121565423287_.pic.jpg', '/2019/11/soli/f7a1219f-39fa-4577-ae34-0f8ad0fca42a.jpg', 'jpg', 'image/jpeg', NULL, 94, 84925, '2019-11-28 15:25:44', 5, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (12, '91565423283_.pic.jpg', '/2019/11/soli/f0a904f9-3022-4ef7-afc9-f08ae78706eb.jpg', 'jpg', 'image/jpeg', NULL, 94, 317044, '2019-11-28 15:27:50', 5, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (13, '131565423288_.pic(2).jpg', '/2019/11/soli/f95bd636-2ab5-4586-9b98-64fc5990e207.jpg', 'jpg', 'image/jpeg', NULL, 94, 80089, '2019-11-28 15:31:37', 5, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (14, 'java入门到精通.xmind', '/2019/11/soli/24510911-ecd9-4ed7-a388-e5d5c965220f.xmind', 'xmind', 'application/vnd.xmind.workbook', NULL, 101, 249002, '2019-11-28 15:38:35', 5, 0, 1);
INSERT INTO `aoa_file_list` VALUES (15, 'java入门到精通.pdf', '/2019/11/soli/0a4cc8d1-415a-4fea-b3e1-c4953ae3e338.pdf', 'pdf', 'application/pdf', NULL, 94, 179584, '2019-11-28 15:46:10', 5, 0, 1);
INSERT INTO `aoa_file_list` VALUES (16, 'java入门到精通(1).pdf', '/2019/11/soli/b5d40232-a798-476b-aafb-67881d25cf53.pdf', 'pdf', 'application/pdf', NULL, 94, 179584, '2019-11-29 11:22:42', 5, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (17, '131565423288_.pic(1).jpg', '/2019/11/soli/604cf628-dfb9-4844-a926-ecae4a2aadf4.jpg', 'jpg', 'image/jpeg', NULL, 94, 80089, '2019-11-29 17:24:37', 5, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (18, '211565423296_.pic.jpg', '/2019/11/soli/c84fbce4-142b-48b0-9e6a-a74990e06937.jpg', 'jpg', 'image/jpeg', NULL, 102, 113490, '2019-11-29 17:25:08', 5, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (19, '拷贝 131565423288_.pic(1).jpg', '/2019/11/soli/f83d6279-2a8b-4ec5-b3dd-6f0cf4d82111.jpg', 'jpg', 'image/jpeg', NULL, 101, 80089, '2019-11-29 17:37:28', 5, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (21, '141565423289_.pic(3).jpg', '/2019/11/伊丽莎白/777c0e83-ff2c-43e5-b6e6-82a714f19d4b.jpg', 'jpg', 'image/jpeg', NULL, 103, 84925, '2019-11-30 18:06:52', 3, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (22, '林.pic.jpg(1).pdf', '/2019/11/伊丽莎白/5b861f7c-2554-4fda-95c0-f8ae87a5f62d.pdf', 'pdf', 'application/pdf', NULL, 106, 179584, '2019-11-30 18:29:41', 3, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (23, '林.pic.jpg', '/2019/11/伊丽莎白/4c835ea5-0608-40ec-9f66-eac432bf0cce.jpg', 'jpg', 'image/jpeg', NULL, 107, 70925, '2019-11-30 19:04:40', 3, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (24, '林.pic(1).jpg', '/2019/11/伊丽莎白/c78de6d7-3d0e-4933-b0be-2a8966ce619b.jpg', 'jpg', 'image/jpeg', NULL, 103, 79989, '2019-11-30 23:01:18', 3, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (25, '拷贝 李子1.pic.jpg', '/2019/12/伊丽莎白/e3e0a13d-667f-407b-b681-9b38ef5663ab.jpg', 'jpg', 'image/jpeg', NULL, 103, 70925, '2019-12-02 18:16:16', 3, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (29, '151565423290_.pic(1).jpg', '/2019/12/伊丽莎白/50668db3-929d-4d91-acc5-dfc2b8591faa.jpg', 'jpg', 'image/jpeg', NULL, 103, 62397, '2019-12-02 21:59:29', 3, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (30, '141565423289_.pic(2).jpg', '/2019/12/伊丽莎白/9a1c6f5f-4ce8-4a3a-906d-ea1708c32016.jpg', 'jpg', 'image/jpeg', NULL, 103, 84925, '2019-12-02 22:01:16', 3, 1, 1);
INSERT INTO `aoa_file_list` VALUES (31, 'junit.txt', '/2019/12/伊丽莎白/95e473db-b862-4e59-8263-cdfc4f6f425f.txt', 'txt', 'text/plain', NULL, 103, 116, '2019-12-02 23:43:20', 3, 1, NULL);
INSERT INTO `aoa_file_list` VALUES (32, 'mysql.txt', '/2019/12/伊丽莎白/67d08fcf-ae9a-4b9e-8bb1-28b4bcd52354.txt', 'txt', 'text/plain', NULL, 105, 131, '2019-12-03 10:55:29', 3, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (33, 'MyBatis.txt', '/2019/12/伊丽莎白/65d37417-f710-40d2-9a2a-d7d7016ffce3.txt', 'txt', 'text/plain', NULL, 103, 125, '2019-12-03 11:01:13', 3, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (34, 'jstl.txt', '/2019/12/伊丽莎白/aeba8652-20ab-43f6-9239-6335b1de523b.txt', 'txt', 'text/plain', NULL, 103, 122, '2019-12-03 15:12:00', 3, 0, NULL);
INSERT INTO `aoa_file_list` VALUES (35, '4165392d-9744-48c1-b8ca-bba1d51351a0.txt', '/2019/12/伊丽莎白/4165392d-9744-48c1-b8ca-bba1d51351a0.txt', 'txt', 'text/plain', NULL, 108, 128, '2019-12-03 15:15:29', 3, 0, 0);
INSERT INTO `aoa_file_list` VALUES (36, '7c21179a-95ec-434d-94a0-e9be019c6c81.txt', '/2019/12/伊丽莎白/7c21179a-95ec-434d-94a0-e9be019c6c81.txt', 'txt', 'text/plain', NULL, 108, 308, '2019-12-03 15:49:18', 3, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_file_path
-- ----------------------------
DROP TABLE IF EXISTS `aoa_file_path`;
CREATE TABLE `aoa_file_path` (
  `path_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件夹路径表ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级文件夹id',
  `path_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '文件夹名',
  `path_user_id` bigint(20) DEFAULT NULL COMMENT '创建文件夹用户id',
  `path_istrash` bigint(20) DEFAULT '0' COMMENT '文件夹是否是垃圾文件夹',
  PRIMARY KEY (`path_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_file_path
-- ----------------------------
BEGIN;
INSERT INTO `aoa_file_path` VALUES (1, 0, '根目录', NULL, 0);
INSERT INTO `aoa_file_path` VALUES (6, 1, '罗密欧', 1, 0);
INSERT INTO `aoa_file_path` VALUES (89, 1, '无双', 10, 0);
INSERT INTO `aoa_file_path` VALUES (90, 1, '甄姬', 7, 0);
INSERT INTO `aoa_file_path` VALUES (91, 90, '新建文件夹', 7, 0);
INSERT INTO `aoa_file_path` VALUES (92, 91, '新建文件5夹', 7, 0);
INSERT INTO `aoa_file_path` VALUES (93, 1, '于彤', 13, 0);
INSERT INTO `aoa_file_path` VALUES (94, 1, 'soli', 5, 0);
INSERT INTO `aoa_file_path` VALUES (96, 0, '林', 5, 1);
INSERT INTO `aoa_file_path` VALUES (97, 0, '锁', 5, 1);
INSERT INTO `aoa_file_path` VALUES (98, 0, 'lin1', 5, 1);
INSERT INTO `aoa_file_path` VALUES (99, 0, '林', 5, 1);
INSERT INTO `aoa_file_path` VALUES (100, 99, 'lin1', 5, 2);
INSERT INTO `aoa_file_path` VALUES (101, 94, '林2', 5, 0);
INSERT INTO `aoa_file_path` VALUES (102, 94, '锁', 5, 0);
INSERT INTO `aoa_file_path` VALUES (103, 1, '伊丽莎白', 3, 0);
INSERT INTO `aoa_file_path` VALUES (105, 103, '林11', 3, 0);
INSERT INTO `aoa_file_path` VALUES (106, 0, '林son1', 3, 1);
INSERT INTO `aoa_file_path` VALUES (107, 0, '林11son2', 3, 1);
INSERT INTO `aoa_file_path` VALUES (108, 103, '锁22', 3, 0);
INSERT INTO `aoa_file_path` VALUES (109, 0, '锁33', 3, 1);
COMMIT;

-- ----------------------------
-- Table structure for aoa_holiday
-- ----------------------------
DROP TABLE IF EXISTS `aoa_holiday`;
CREATE TABLE `aoa_holiday` (
  `holiday_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `leave_days` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  `personnel_advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`holiday_id`),
  KEY `FK1glo2wpb4kuiop1ymjxs0knxj` (`pro_id`),
  CONSTRAINT `FK1glo2wpb4kuiop1ymjxs0knxj` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_holiday
-- ----------------------------
BEGIN;
INSERT INTO `aoa_holiday` VALUES (17, 1, 38, 114, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_in_mail_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_in_mail_list`;
CREATE TABLE `aoa_in_mail_list` (
  `mail_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '内部邮件列表ID',
  `mail_content` text COMMENT '邮件内容',
  `mail_create_time` datetime DEFAULT NULL COMMENT '邮件创建时间',
  `mail_file_id` bigint(20) DEFAULT NULL COMMENT '邮件附件ID',
  `mail_title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '邮件主题',
  `mail_type` bigint(20) DEFAULT NULL COMMENT '邮件类型(通知，公告，邮件）',
  `mail_in_push_user_id` bigint(20) DEFAULT NULL COMMENT '发件人ID',
  `in_receiver` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '收件人名字（可以是多个）',
  `mail_status_id` bigint(20) DEFAULT NULL COMMENT '邮件状态（一般，紧急，重要）',
  `mail_number_id` bigint(20) DEFAULT NULL COMMENT '外部邮件 账号ID',
  `mail_del` int(11) DEFAULT NULL COMMENT '邮箱是否已删除0未删除1已删除',
  `mail_push` int(11) DEFAULT NULL COMMENT '邮箱是否为新添加的',
  `mail_star` int(11) DEFAULT NULL COMMENT '邮件是否标记',
  PRIMARY KEY (`mail_id`),
  KEY `FK33o7j8f0xk8n8vrk576iktglc` (`mail_file_id`),
  KEY `FK933q7ouoddu584qg08rbvwvxi` (`mail_in_push_user_id`),
  KEY `FKghibt111d1yvc3f02x06sihjp` (`mail_number_id`),
  CONSTRAINT `FK33o7j8f0xk8n8vrk576iktglc` FOREIGN KEY (`mail_file_id`) REFERENCES `aoa_attachment_list` (`attachment_id`),
  CONSTRAINT `FK933q7ouoddu584qg08rbvwvxi` FOREIGN KEY (`mail_in_push_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKghibt111d1yvc3f02x06sihjp` FOREIGN KEY (`mail_number_id`) REFERENCES `aoa_mailnumber` (`mail_number_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_in_mail_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_in_mail_list` VALUES (2, '<p>\r\n	咕咕咕咕\r\n</p>\r\n<p>\r\n	一月又一月\r\n</p>', '2017-09-28 19:40:05', 48, '啊啊啊啊', 16, 1, '朱丽叶', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (3, '<p>\r\n	哈哈哈哈或\r\n</p>\r\n<p>\r\n	哈哈哈哈或或\r\n</p>', '2017-09-28 20:08:25', NULL, '啊啊啊啊啊', 16, 1, '664303632@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (4, '<p>\r\n	的点点滴滴多多多多\r\n</p>\r\n<p>\r\n	咯咯咯咯咯过过过\r\n</p>\r\n<p>\r\n	哈哈哈哈或或或或\r\n</p>', '2017-09-28 21:24:39', 49, '趣味体育活动当天的决定', 16, 1, '1533047354@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (5, '反反复复付', '2017-09-28 21:27:45', 50, '多对多', 16, 1, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (6, '凄凄切切群群群群群', '2017-09-28 21:30:40', 51, '凄凄切切', 16, 1, '1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (7, '<p>\r\n	咯咯咯咯咯\r\n</p>\r\n<p>\r\n	哈哈哈哈或\r\n</p>', '2017-09-28 21:37:44', 52, '凄凄切切', 16, 1, '1533047354@qq.com', 20, 1, 1, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (8, '沉浸在这美好的安然中，你会喜欢上这最绚丽的色彩，爱上这段沉静的时光，恋上这份清怡的静美。', '2017-09-28 21:46:48', 53, '试试', 16, 1, '1057245260@qq.com；1533047354@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (9, '<p>\r\n	沉浸在这美好的安然中，你会喜欢上这最绚丽的色彩，\r\n</p>\r\n<p>\r\n	爱上这段沉静的时光，恋上这份清怡的静美。\r\n</p>', '2017-09-28 21:53:25', 54, '试试', 16, 1, '1057245260@qq.com;1533047354@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (10, '<p>\r\n	<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">他便过来抱着我说：“孩子，爸爸也想给你一个妈妈。”可是，爸爸真的做不到。</span>\r\n</p>\r\n<p>\r\n	<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">爸爸会尽力像妈妈一样的爱你。我总是能从他的眼里看到晶莹闪光的东西，想掉又掉不下来。</span>\r\n</p>\r\n<p>\r\n	<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">那一年我四岁半,似懂非懂的点点头，迎合着我唯一能抓住的亲人。</span>\r\n</p>', '2017-09-28 22:00:37', 55, '再试试', 16, 1, '1533047354@qq.com;1057245260@qq.com', 20, 1, 1, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (11, '<a href=\"http://www.jj59.com/zti/tongnian/\" class=\"keywordlink\">童年</a><span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">的时光总是很短暂，最</span><a href=\"http://www.jj59.com/zti/kuaile/\" class=\"keywordlink\">快乐</a><span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">的几年都在恍惚的小学中度过了，那个时候学习没有什么压力，爸爸每天忙着赚钱。基本上也不怎么过问我的功课，但是只要我成绩下来了。就一定尝到劈头盖脸的一顿臭骂。无论他怎么忙，每天下班回家一定陪我，周末的</span><a href=\"http://www.jj59.com/zti/time/\" class=\"keywordlink\">时间</a><span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\">全是我的。所以，我放学就可以和朋友尽情玩耍。白天有同学陪，放学有爸爸陪。渐渐的也就忘却了妈妈的存在。随着时光的推移也就理解了爸爸口中的遥远是什么含义。</span><br />\r\n<span style=\"color:#333333;font-family:宋体;font-size:14px;background-color:#FFFFFF;\"> </span>', '2017-09-28 22:03:46', 56, '咯咯咯咯咯过过过', 16, 1, '1533047357@qq.com;1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (12, '<span style=\"color:#111111;font-family:Arial, Helvetica, sans-serif;font-size:14px;background-color:#FFFFFF;\">最近有个朋友生日，聚会上有人送了他一对精致的杯子做礼物，据说这对杯子做工质地讲究，连配图都出自绘画大师之手。然而，就在朋友得知这对杯子价格近千块的时候，他直接炸了：“不就是个盛水的东西，跟我用的十块钱的玻璃杯有什么区别？这俩杯子哪里值千多块钱啊！</span>', '2017-09-28 22:20:12', 57, '最后一次', 16, 1, '1533047354@qq.com;1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (13, '发发发发发发付或或或', '2017-09-29 13:57:20', NULL, '大家点击度假酒店', 16, 1, '朱丽叶;伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (15, '通过副本', '2017-09-29 19:53:52', NULL, '根本', 16, 2, '罗密欧', 20, NULL, 1, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (16, '<p>\r\n	我去复制一段话来\r\n</p>\r\n<p>\r\n	<span style=\"color:#404040;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">1953年秋天，27岁的赫夫纳向亲友借了8000美元，花500美元买下梦露半裸照的版权，创办了《花花公子》</span>\r\n</p>', '2017-09-29 22:09:52', 58, '我自己这边发的', 16, 1, '1057245260@qq.com;664303632@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (17, '儿歌个TV登革热vgt', '2017-09-30 15:52:07', NULL, '私事客服', 16, 2, '伊丽莎白;小李父斯基', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (18, '柔柔弱弱', '2017-09-30 16:24:46', NULL, '呃呃呃', 18, 2, '罗密欧', 20, NULL, 1, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (19, '哈哈不过', '2017-09-30 17:02:22', NULL, '得到', 16, 2, '小李父斯基', 21, NULL, 0, 1, 1);
INSERT INTO `aoa_in_mail_list` VALUES (20, '闺女胡', '2017-09-30 17:04:19', NULL, '嘉年华', 16, 2, '朱丽叶', 22, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (21, '房地产和好', '2017-09-30 17:26:05', NULL, '办法VSX', 16, 2, '朱丽叶', 20, NULL, 1, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (22, '还好吧GV', '2017-09-30 21:01:57', NULL, '密密麻麻', 16, 2, NULL, 20, NULL, 0, 0, 1);
INSERT INTO `aoa_in_mail_list` VALUES (23, '发v', '2017-10-01 12:46:44', 59, '信息', 16, 2, '罗密欧;朱丽叶', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (24, '得出', '2017-10-01 12:47:15', NULL, '就你那', 17, 2, '朱丽叶;伊丽莎白', 22, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (25, '反复发热的是v车<br />\r\n<hr />\r\n调查色粉', '2017-10-01 16:59:41', NULL, '【回复】发v显示', 16, 1, '朱丽叶;罗密欧', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (26, '湖不过均', '2017-10-01 12:48:07', NULL, '客家话', 16, 2, '朱丽叶;伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (27, '护肤措施', '2017-10-01 12:48:25', NULL, '举横幅', 16, 2, '朱丽叶;伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (28, '高铁都不', '2017-10-01 12:48:46', 60, '好一点v', 16, 2, '小李父斯基;soli;红之花', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (29, '谷朊粉', '2017-10-01 12:49:10', 61, '共同市场', 16, 2, '伊丽莎白;soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (30, '柔肤水过一遍', '2017-10-01 12:49:33', 62, '枯黄的', 16, 2, '朱丽叶;伊丽莎白;soli;红之花', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (32, '包含', '2017-10-01 14:36:12', NULL, '包含', 18, 1, '朱丽叶;伊丽莎白', 22, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (33, '<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;八月的夜空，月色清明，云彩轻扬；八月的芳草地，花香迷朦，一池秋水清浅温婉。在花开花谢的流转里，时光坐在月色背后，冷艳如初。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; ——题记\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 月光开始沉醉，起初，只是一抹淡淡的凝脂色，夜色宁静，慢慢明亮，圆润。像极了伊宁静盈暖的眼眸。七夕刚过，夜带着神秘的气息，薄薄的云彩，清透含蓄。抬头寻找，记忆中的渺渺银河，偌大的天宇，两三点星光，若隐若无，温柔的隔海相望。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 月光总是太美，让人遐想，让人怜爱。夏天的花影，次第流转，清风明月思年华，而爱情总是太美，遥远如星空，茫茫人间，有烟火色便为红尘，遇见，爱上，一生何求？\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 如果可以，有一片海可以穿越爱的极限，我愿意，与你一同前往。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 轻拨心灵的琴弦，远处，是否有伊在轻轻和奏？\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	<img src=\"https://www.yueduwen.com/uploads/allimg/c1408/140920921250-H521.jpg\" /><span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 爱是感动，爱是相守，爱是牵挂，爱是月光里最美的诗行。我知道，有一片天空，始终有我的等待，那是你的方向。只是，天涯咫尺，我只能执手泪眼问相思。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 用心把远方托付给远方，把故事深藏在星光深处。那些苦涩的回忆不是忧伤，那甜美的记忆已成芬芳，是我幸福的奢华，余有暗香。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 恬淡，遥远。像今夜的月亮。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 我还站在昨天的月光里，用心轻吻一朵月色下的玫瑰。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 今夜的月光是行走的思念，静静与我，相守。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 内心，一半是海水的潮湿，一半是火焰的炽热。守在月色下，开始朝着你的方向一路飞奔，把爱放在温热的掌心，一路小心的呵护，担心遗落在风雨中。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 月下的人间，盛开一条河流，我坐在河对岸，静静祈祷，相思过去，一切如旧，不曾挑明，只是以一种形式的相守，坚守你我的这份爱。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	&nbsp;&nbsp;&nbsp; 就像今晚的月亮，这么明亮，这么清澈，是你么，带着温暖的耳语，仿佛遥远，又近在咫尺。\r\n</p>', '2017-10-01 15:21:25', NULL, '的放入他', 16, 1, '朱丽叶', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (34, '发发发通天塔<br />\r\n<hr />\r\n反复发热的是v车<br />\r\n<hr />\r\n调查色粉', '2017-10-01 17:16:14', NULL, '【回复】【回复】发v显示', 16, 1, '朱丽叶', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (35, '给你<br />\r\n<hr />\r\n发v', '2017-10-01 17:24:15', NULL, '【转发】信息', 16, 1, '朱丽叶', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (37, '<table width=\"100%\" style=\"padding:0px;margin:0px;color:#333333;font-family:Helvetica, Arial, sans-serif;font-size:16px;background-color:#FFFFFF;\">\r\n	<tbody>\r\n		<tr>\r\n			<td>\r\n				<div id=\"contentMidPicAD\" style=\"padding:0px;margin:0px;vertical-align:top;\">\r\n				</div>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					<img alt=\"唯美图片爱情\" src=\"https://www.yueduwen.com/uploads/allimg/1702/1-1F226213T1602.jpg\" />\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					太过用力，会纠缠于内心，会让所有的饱满太过张力，是一张拉满了的弓，射得一定远吗?怕是会断掉。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					一场情事，泼墨太多了，用力太猛了，自己都收不住。洪水泛滥的结果是将自己淹没了。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					也许好的爱情应该是云淡风轻，安静地看着对方，对方是自己的一块清新的糖，想起时，安静地抿一下，就够了，有的时候，爱情需要距离，需要空间。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱上一个人，总会动荡些时日，半夜跑去写情书，私情这东西总怕沉溺。但不沉溺又是错的。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱这个人，哪怕知道他坏他烂，可是，因为贪恋这人世间的一点点爱一点点温暖，便飞蛾一样，扑向了火。这一场盛宴，是一个人的盛宴，与现实的爱情如此格格不入，不温暖，不体贴，不妥当，带着罂粟的邪恶与放荡——但她一意孤行，一定要一意孤行。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					最坚固的爱情是懂得一个人的灵魂与心，就像杨绛懂得钱钟书，这种懂得，似读一本值得读的好书，读一生，也不会倦。而他们的用力，是持续的温度，是持续的力度，一直是这样，不高，不低，不温，不火。<span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					用力地爱一个人，趁着还有一颗爱的心，其实是幸福——哪怕最后碎了灭了，而心里，永远会有这个人，永远会有。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					女人总对事物有所迷恋，而迷人比迷东西更诱人。大体说来，一是迷恋衣服，二是迷恋男人。衣服和男人同时到来，则男人第一。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱情是最不实用的东西，伤筋动骨的，不如迷恋别的东西实惠。迷恋这个东西，带着痴的成分，爱情这个东西，当个点缀时还好，可是，一用力起来就会盛大，又惊心动魄又无聊。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					太浓烈的爱情，来得快，一定去得也快。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱情原来是有条件的，原来是和别的气氛在一起的——特别是人前，如果感觉到他们在相爱，一个眼神就足够了。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					最干净的爱情，一定清淡似水，应该浓烈时浓烈，应该清淡时就清淡。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					只剩下爱情，一定离分手很近了，因为再也没有别的话——有趣的爱情，是和趣味、气味、气场相互联系的，比如两个人的共同爱好，哪怕一起爱上美食，其实最后拼的是生活习惯和灵魂距离。如果单纯色相吸引，爱情最难维持，时间最短的爱情一定是一见钟情——只凭貌相，那样的爱情过于单薄，连维持下去都要努力。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					最厚实的爱情，一定是踏实肯定，连缺点也要喜欢，连习惯都雷同，爱到忘记了爱是怎么回事，只记得他爱吃茴香馅，她爱穿安瑞井……如果只是为爱而爱，哪怕私奔到天涯，一定还要离散。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					爱一个人，需要傻到没有自己，和爱情相比，自己太轻了，太单了，太势孤了，而只有爱情，可以让人焕发了光彩，那样的熠熠夺目，是自己没有过的样子。就像张中行老先生说，还是男女之情最有意思。因为像鸦片，有瘾，有毒，离不了，忘不了，相互吸引，又相互刺痛。\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>', '2017-10-01 19:39:14', 60, '来了', 16, 1, '664303632@qq.com；1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (42, '咕咕咕咕拖拖拖拖多多多多多', '2017-10-01 20:29:51', NULL, '点点滴滴', 16, 1, '1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (43, '麻烦得很', '2017-10-02 14:49:56', 61, '给你给你', 16, 1, '1071766245@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (44, '<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	在一档电视节目中，主持人问马云，如果人生可以重来，你有什么遗憾需要弥补?马云淡淡地说，我的人生一切都刚刚好。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	这样的回答，可以说是自信，因为一切都恰到好处;也可以说是知足，因为没有留下遗憾。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	一切都刚刚好，这话说出来简单，做起来却大不易。什么叫刚刚好，理性一点说就是适度。什么叫度，理科老师告诉你，度就是一定事物保持自己质的数量界限，比如说冰点、熔点、沸点;文科老师告诉你，度就是事物所达到的境界，比如说高度、风度、气度。在《登徒子好色赋》中，宋玉用两个排比句，来描述东邻女孩的美貌：增之一分则太长，减之一分则太短;着粉则太白，施朱则太赤。这话听起来有些夸张，其实不过是说这个女孩长得恰如其分，刚刚好。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	世间一切事物，都是由过程表现出来的，这个过程无非是由量变到质变，由渐变到突变。变与不变的节点就是度。作为人生哲学的度，则是指在做人处世中拿捏的分寸，掌握的火候，遵循的法则。这种度，不是衡器测量出来的，而是用心掂量出来的。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	古代圣贤留给我们的人生智慧和哲理很多，以至于穷其一生也未必都能学完、用好，但若看多了、悟透了，就会觉得，大道至简，道法自然，归根结底不过两个字：适度。就是说，凡事有度，适可而止，过犹不及，物极必反。即便是优点，过了头也会坏事;即便是美德，过了头也会显得不美;只有恰到好处，才会趋于完美。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	比方说，性情耿直的人心直口快是优点，倘若不注意场合与对象，出言不逊，出口伤人，就会让人讨厌。蔡明表演的以“毒舌”为语言特征的小品，为什么会一再登上央视春晚舞台，并非人们喜欢“毒舌”，而是因为她塑造的“毒舌”，形象惟妙惟肖，语言尖酸刻薄，对缺乏口德者的讽刺力度入木三分，从而使人们在爆笑的同时，更加讨厌“毒舌”，远离“毒舌”，也能让那些以“刀子嘴豆腐心”自诩的人反观自照，明心见性，在社会交往中不再以“毒舌”相向。即便以“毒舌”显示幽默，也要看对方的接受能力，顾及他人的尊严。\r\n</p>', '2017-10-02 14:55:07', NULL, '多对多多对多多', 16, 1, '1071766245@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (45, '<table width=\"100%\" style=\"padding:0px;margin:0px;color:#333333;font-family:Helvetica, Arial, sans-serif;font-size:16px;background-color:#FFFFFF;\">\r\n	<tbody>\r\n		<tr>\r\n			<td>\r\n				<div id=\"contentMidPicAD\" style=\"padding:0px;margin:0px;vertical-align:top;\">\r\n				</div>\r\n<img alt=\"\" height=\"441\" src=\"http://www.yueduwen.com/uploads/allimg/c170225/14X01CI261Z-1131J.jpg\" width=\"590\" />\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					他一岁的时候，父亲被打成右派，被送进江西某农场劳动改造。他的母亲是一名小学教师，因为身边还带着大他一岁的哥哥，母亲自知没有多余的精力把他拉扯成人。就在一个雨夜，母亲怀抱着他，把他托付给原来的老邻居，即他日后经常挂在嘴边的张公张婆。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					张公是安徽人，人长得高大，心地善良，日本侵华时，他挑着担子，逃难来到湖南沅陵麻溪铺。张公的左脚就是在逃难时被日本飞机丢响的炸弹震坏的，因此，走起路来，一颠一颠的。保姆婆是从凤凰逃难到本地，当年她只有十五岁。两位苦难的人在异乡相依为命，他们一生没有生育。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					在麻溪铺镇上，临着街，张公和张婆拥有一间不大的屋子，那屋子由裱有报纸的隔板分成两小间。靠外的一间，是现代意义上的客厅。中间有一个火塘，火塘上有一个木架，常年挂着几排黑乎乎的东西，那是当地人喜欢的腊肉。在隆冬季节，大雪封山的日子，张婆会切下一段腊肉，把肉皮在炭火上烧烤。几分钟，洗出来之后，黑色的肉皮就变成黄金糕的颜色了。腊肉的香味极具诱惑。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					靠里那一间，他和张公张婆挤在一张木板床上，怕他半夜摔下来，老人让他睡在中间。那屋子下雨时漏雨，刮风时透风。于是，张公就在屋顶扯起一块塑料布。每逢下雨，瓦缝的水有节奏地滴进塑料布里，发出嗒—嗒—嗒—的声音。南方雨水多，那嗒嗒嗒的雨声就成了他的催眠曲。为了防止泥巴地发潮，张公张婆在那木板床的下面，塞满了黑乎乎的木炭，果木的清香残留在木炭的骨子里，伴着他一天天长大成人。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					转眼，他六岁了，到了读书的时候。有一天，张公拿过他削得尖尖的铅笔说，崽呀，这铅笔你若削尖了，一用力就断了，很浪费。张公示范着说，铅笔只要用菜刀把木头削掉，露出铅笔芯就可以写字了，这样既节省又不易折断。他一直按照张公的办法去做，以至于现在不仅能写得一手好字，关键是字粗而且大，极易辨认。在每一个小鸟啼叫的早晨和炊烟袅袅的黄昏，像吊死鬼儿一样贴在他屁股上的黄色书包里，除了几本卷了角的书本，就是一支秃头秃脑的铅笔。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					张婆做得一手好菜。当他还没有灶台高的时候，张婆搬来一个高脚竹椅子摆在灶台边，把他抱上去，他就趴在灶台上，看张婆怎样炒菜，怎样放佐料。他打小就明白了切菜的刀功极为重要，也懂得炒菜的时候哪些应该盖锅盖，哪些菜是不需要盖锅盖的。在每一道菜出锅的时候，他记得张婆都会用洁白的抹布在碗口边缘擦一圈，残留的痕迹便不复存在了。张婆常说，孔夫子不吃豆腐，吃东西讲究色香味，讲究刀法，老祖宗留下的够我们一辈子去学。\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					如今，他做饭做得可口，全家人都跟着他享口福。看到全家老小一脸享受地吃着他做的饭菜，他一脸的幸福。他夹一口菜，刨一口饭，敲一下碗边儿，嗯，可以，可以，这味道可以。<span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n				</p>\r\n				<p style=\"color:#434343;font-size:16px;text-indent:2em;\">\r\n					距离张公张婆的屋不远，有一所女子中学，张公是那学校的校工。当时的学校，没有电铃，上课下课，都是靠敲钟。张公就是那敲钟的人。钟也不是什么好材料做的，是一个长锈的铁环，用麻绳系着，挂在一根房梁上面。\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>', '2017-10-06 11:02:49', 62, '最后一试', 16, 1, '1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (46, '<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	<img alt=\"\" src=\"https://www.yueduwen.com/uploads/allimg/1705/1-1F520161G2E9.jpg\" /><img src=\"https://www.yueduwen.com/uploads/allimg/1705/1-1F520161G2E9.jpg\" />\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	去岁盛夏返乡，时近黄昏，禽鸟归巢，晚风吹拂，我独自漫步在房前不远处的三米宽的水泥质地镶有不锈钢围栏的小桥上。桥下流水潺潺，清澈见底。举目四望，满眼青翠，一片碧绿：周围稻田碧浪翻滚，稻穗飘香;稍远处玉米吐穗，绿叶婆娑;远处青山含黛，松柏飘香。白练似的水泥小路盘旋乡间逶迤远方，随之一同飘去的还有我的一片思绪。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	小时候，穿过一条狭窄蜿蜒的田埂来到小河边，就见一座木石结构的小桥横跨河上。小桥宽约两米，长有丈余，全桥由三根直径约二十公分的柏树为基底，上以质地坚硬的青石板严密覆盖，下有两根柏木立柱在河中支撑。我们村两个组的近三百群众都要通过该桥来往，去到对岸的碎石公路，走向远方。印象中，小桥从我记事起就一直存在，它是我们对外联系的纽带。尽管它外形单调，结构简单，却十分坚固，即使人们牵着体型硕大的黑水牛从上面悠然走过也安然无恙，而且还经受住了几次巨大洪水冲击的考验呢。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	童年的夏天，好像比现在还要炎热许多，蝉也叫得特别响亮，我和小伙伴们常在桥下游泳，河中嬉戏。有时仰头看着小桥，感觉它无比高大雄伟。如果有人敢站在桥上做出各种姿势往下跳水，常会赢得孩子们的无比羡慕和大声喝彩。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	小桥也是通向对岸外婆家的唯一大道，傍晚回家，外婆家的大黄狗必要送我回来。让我百思不得其解的是，大黄狗每次都是把我送到小桥边就默默离去了，从来不越雷池半步，好像它对桥心存敬畏，很放心把我交给小桥似的。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	遗憾的是，我长大成年了，小桥却衰老了。年久失修，上面的青石板风化掉落得厉害，最后只剩下三根孤零零的朽木了，大人们在上面还能如履平地，年幼的孩子们就惨了，很多只能在上面缓缓爬行，战战兢兢，如履薄冰。又过了一年，小桥的通过能力几乎完全丧失，大人们也早将关注的重点转移到了农作上，忙于打理自家的承包地。再加上雨水连年减少，河床干涸见底，河底裂纹密布，人们下河底爬河堤也不甚费力，小桥就渐渐被人们遗忘了，最后就连几根枯朽的柏木也不见踪影，可能是被村民扛回去作柴禾了吧。河水充盈时，人们往往行走于集体夯筑的土堰上，但不得不面对土堰随时崩塌的危险。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	一年夏天，暴发了三十年未遇的特大洪水。顷刻间，一切堤堰土崩瓦解，想要出行十分困难，况且还有许多农产品要运出去许多农资要运进来呢。人们这才认识到架座小桥的必要性，于是乎发动群众，有钱出钱，有力出力，准备建一座有两个桥墩的水泥板桥。<span class=\"yueduwencom\">（<a href=\"http://www.yueduwen.com/\">悦读文网</a>&nbsp;www.yueduwen.com）</span>\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	乡民的本性始终是淳朴良善的，认为修桥补路是积德行善，都踊跃出钱出力，很快前期准备就完成了。修桥由经验丰富的老石匠亲自掌墨，开始挖基脚，抬石头，拌水泥，砌桥墩，搭桥板。老石匠认为这可能是自己人生最后一件大作品，认真到了严苛的程度，所谓慢工出细活，这桥修了近半年之久。看到这座新落成的水泥板桥，听到人们的啧啧称赞，老石匠就好像看着自己的刚出生的孩子，高兴得裂开干瘪的嘴唇，嘿嘿地笑出声来。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	这一下，新桥很快就成了人们聚集谈天的场所。盛夏的夜晚，在桥上休憩纳凉的人语声久久不绝，争相述说着生活的美好;严冬的中午，沐浴暖阳的人笑声不断，竞相谈论着故乡的变迁。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	后来，村民个人集资，再加上国家补贴，开始将小桥两边安上不锈钢栏杆，并将穿过小桥两边的乡间小道拓宽硬化，通到家家户户，大大方便了人们出行。远在他乡多年未归的游子也纷纷驾车返乡，当漂亮舒适的轿车轻吻小桥时，他们说分明听到了小桥的咯咯笑声，好像是独自在家的慈母在热烈欢迎久别孩子的归来。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	突然“滴——滴——”声起，将我的思绪拉回眼前，原来是阔别多年的儿时好友晓敏在打招呼。我俩就在桥头攀谈起来，诉说着各自的生活和家乡的美好。\r\n</p>\r\n<p style=\"color:#434343;font-size:16px;text-indent:2em;font-family:Helvetica, Arial, sans-serif;background-color:#FFFFFF;\">\r\n	此时，夜色渐浓，小桥无语。是啊，故乡的小桥不仅见证了家乡由贫穷到富裕的发展变化，见证了家乡人们从奔波到闲适的生活，也必将见证家乡不可限量的辉煌未来。\r\n</p>', '2017-10-07 21:51:26', NULL, 'ssss', 16, 1, '1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (47, '发发发发发发付付付', '2017-10-16 17:17:51', 69, '啛啛喳喳', 16, 18, '甄嬛;无双', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (48, '多对多', '2017-10-16 17:42:16', 70, '多对多', 16, 1, '无双', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (49, '少时诵诗书所所所所所', '2017-10-18 17:45:16', 72, '少时诵诗书', 16, 1, '1057245260@qq.com', 20, 1, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (50, '给朱丽叶发的邮件，接受吧', '2019-11-13 19:01:37', 156, '给朱丽叶发的邮件', 16, 5, '朱丽叶', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (52, '<br />\r\n<hr />\r\n高铁都不做了', '2019-11-14 15:57:38', NULL, '【回复】好一点啊啊', 18, 5, '12345@qq.com', 20, 17, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (53, '<br />\r\n你好', '2019-11-14 19:44:27', NULL, '【转发】共同市场', 18, 5, '罗密欧', 22, NULL, 1, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (54, '发用纸啦', '2019-11-15 20:48:57', 157, '发通知拉', 17, 5, '123@qq.com', 21, 17, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (55, '不上课', '2019-11-15 21:39:21', NULL, '发通知拉2', 16, 5, '123456@qq.com', 21, 18, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (56, '安居房', '2019-11-15 21:40:32', 158, '发通知拉3', 18, 5, 'soli', 21, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (57, 'jAHnj 看', '2019-11-17 14:42:41', 159, '发通知拉2', 17, 5, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (58, '邮件来了', '2019-11-17 16:04:26', 162, '给你们三发邮件拉', 16, 5, '朱丽叶;伊丽莎白;soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (59, '<br />\r\n给你回复了', '2019-11-17 16:16:05', 163, '【回复】给你们三发邮件拉', 16, 5, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (60, '<br />\r\n给你回邮件啦啦啦啦啊啦啦啦\r\n<hr />', '2019-11-17 16:28:43', 164, '【回复】给你们三发邮件拉', 16, 5, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (61, '<br />\r\n世界之大\r\n<hr />', '2019-11-17 16:31:35', 165, '【回复】给你们三发邮件拉', 16, 5, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (62, '<br />\r\n<hr />\r\n<p>\r\n	邮件来\r\n</p>\r\n<p>\r\n	回复设置了\r\n</p>', '2019-11-17 16:38:59', 166, '【回复】给你们三发邮件拉', 16, 5, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (63, '<br />\r\n<hr />\r\n<p>\r\n	邮件来\r\n</p>\r\n<p>\r\n	给你回邮件啦啦啦啦了\r\n</p>', '2019-11-17 17:01:38', 167, '【回复】给你们三发邮件拉', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (64, 'soli你的有家来了', '2019-11-17 21:09:32', 168, '给soli的邮件', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (65, '3号你的邮件来了', '2019-11-17 21:25:11', 169, '发给3号的邮件', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (66, '5号你的邮件来了', '2019-11-17 21:36:16', 170, '给5号邮件', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (67, '5号你的邮件来了', '2019-11-17 21:43:18', 171, '给5号邮件', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (68, '3号5号你们的有家来了', '2019-11-17 21:46:07', 172, '给5号和3号的邮件', 16, 3, '伊丽莎白;soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (69, '给3号的11-17号的邮件', '2019-11-17 21:54:13', 173, '2019-11-17给3号的邮件', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (70, '邮件来了', '2019-11-17 21:57:34', 174, '给5号的邮件1', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (71, '给5号的邮件2', '2019-11-17 22:04:55', 175, '给5号邮件2', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (72, '5号你的邮件来了3', '2019-11-17 22:11:58', 176, '给5号邮件3', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (73, '3号给5号回复的邮件1<br />\r\n<hr />\r\n5号你的邮件来了3', '2019-11-17 22:21:05', 177, '【回复】给5号邮件3', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (74, '接收的：3号给5 号 的邮件2', '2019-11-17 22:26:03', 178, '3号给5号的邮件2', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (75, '回复给3号的邮件<br />\r\n<hr />\r\n5号你的邮件来了3', '2019-11-17 22:42:55', 179, '【回复】给5号邮件3', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (76, '给5号发通知拉', '2019-11-18 09:08:55', 180, '11-18邮件', 17, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (77, '回复给3号的邮件<br />\r\n<hr />\r\n5号你的邮件来了3', '2019-11-18 09:33:30', 181, '【回复】给5号邮件3', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (78, '<br />\r\n<hr />\r\n回复给3号的邮件<br />\r\n<hr />\r\n5号你的邮件来了3', '2019-11-18 09:41:01', 182, '转发【回复】给5号邮件3', 16, 3, 'soli', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (79, '5号邮件来了', '2019-11-18 09:49:28', 183, '给5号邮件4', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (80, '准备存草稿', '2019-11-18 09:58:29', 184, '给3号邮件来了', 16, 5, NULL, 20, NULL, 0, 0, 0);
INSERT INTO `aoa_in_mail_list` VALUES (81, '<br />\r\n<hr />\r\n准备存草稿', '2019-11-18 10:01:04', 185, '转发给3号邮件来了', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (82, '<br />\r\n<hr />\r\n准备存草稿', '2019-11-18 10:14:12', 186, '转发给3号邮件来了', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (83, '给你发通知拉1', '2019-11-18 17:17:05', 187, '给发通知啦', 16, 5, '942739886@qq.com', 20, 20, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (84, 'ak看N', '2019-11-18 17:28:43', 188, '发通知拉', 16, 5, '伊丽莎白', 20, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (85, '通知来了', '2019-11-18 17:36:29', 189, '发通知拉6', 16, 5, '伊丽莎白', 21, NULL, 0, 1, 0);
INSERT INTO `aoa_in_mail_list` VALUES (86, '邮件看基础', '2019-11-18 17:59:40', 190, '邮件11', 16, 5, '94273886@qq.com', 20, 21, 0, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_love_discuss_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_love_discuss_user`;
CREATE TABLE `aoa_love_discuss_user` (
  `discuss_id` bigint(20) NOT NULL COMMENT '讨论表ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `discuss_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '讨论表中间表',
  PRIMARY KEY (`discuss_user_id`) USING BTREE,
  KEY `FKkl0fitgg3qixkg5gg9mmjp5e7` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_love_discuss_user
-- ----------------------------
BEGIN;
INSERT INTO `aoa_love_discuss_user` VALUES (8, 1, 1);
INSERT INTO `aoa_love_discuss_user` VALUES (12, 1, 2);
INSERT INTO `aoa_love_discuss_user` VALUES (15, 1, 3);
INSERT INTO `aoa_love_discuss_user` VALUES (33, 1, 4);
INSERT INTO `aoa_love_discuss_user` VALUES (7, 2, 5);
INSERT INTO `aoa_love_discuss_user` VALUES (12, 2, 6);
INSERT INTO `aoa_love_discuss_user` VALUES (13, 2, 7);
INSERT INTO `aoa_love_discuss_user` VALUES (33, 2, 8);
INSERT INTO `aoa_love_discuss_user` VALUES (37, 2, 9);
INSERT INTO `aoa_love_discuss_user` VALUES (38, 2, 10);
INSERT INTO `aoa_love_discuss_user` VALUES (39, 2, 11);
INSERT INTO `aoa_love_discuss_user` VALUES (8, 3, 12);
INSERT INTO `aoa_love_discuss_user` VALUES (33, 3, 13);
INSERT INTO `aoa_love_discuss_user` VALUES (33, 7, 14);
INSERT INTO `aoa_love_discuss_user` VALUES (13, 8, 15);
INSERT INTO `aoa_love_discuss_user` VALUES (13, 3, 17);
INSERT INTO `aoa_love_discuss_user` VALUES (46, 3, 18);
INSERT INTO `aoa_love_discuss_user` VALUES (47, 3, 19);
INSERT INTO `aoa_love_discuss_user` VALUES (54, 3, 20);
INSERT INTO `aoa_love_discuss_user` VALUES (56, 3, 21);
INSERT INTO `aoa_love_discuss_user` VALUES (53, 3, 22);
INSERT INTO `aoa_love_discuss_user` VALUES (55, 3, 23);
COMMIT;

-- ----------------------------
-- Table structure for aoa_love_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_love_user`;
CREATE TABLE `aoa_love_user` (
  `reply_id` bigint(20) NOT NULL COMMENT '回复ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `reply_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回复中间表ID',
  PRIMARY KEY (`reply_user_id`),
  KEY `FK7fv96y8gbqcnb44qao4ey4rmn` (`user_id`),
  KEY `FKcuptpmm0l1e0b9pjv0xksqqai` (`reply_id`),
  CONSTRAINT `FK7fv96y8gbqcnb44qao4ey4rmn` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKcuptpmm0l1e0b9pjv0xksqqai` FOREIGN KEY (`reply_id`) REFERENCES `aoa_reply_list` (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_love_user
-- ----------------------------
BEGIN;
INSERT INTO `aoa_love_user` VALUES (7, 2, 1);
INSERT INTO `aoa_love_user` VALUES (9, 2, 2);
INSERT INTO `aoa_love_user` VALUES (6, 1, 3);
INSERT INTO `aoa_love_user` VALUES (3, 1, 4);
INSERT INTO `aoa_love_user` VALUES (2, 1, 5);
INSERT INTO `aoa_love_user` VALUES (9, 1, 6);
INSERT INTO `aoa_love_user` VALUES (16, 1, 7);
INSERT INTO `aoa_love_user` VALUES (15, 1, 8);
INSERT INTO `aoa_love_user` VALUES (14, 1, 9);
INSERT INTO `aoa_love_user` VALUES (17, 1, 10);
INSERT INTO `aoa_love_user` VALUES (18, 1, 11);
INSERT INTO `aoa_love_user` VALUES (62, 2, 12);
INSERT INTO `aoa_love_user` VALUES (61, 2, 13);
INSERT INTO `aoa_love_user` VALUES (67, 2, 14);
INSERT INTO `aoa_love_user` VALUES (4, 2, 15);
INSERT INTO `aoa_love_user` VALUES (2, 2, 16);
INSERT INTO `aoa_love_user` VALUES (2, 2, 17);
INSERT INTO `aoa_love_user` VALUES (3, 2, 18);
INSERT INTO `aoa_love_user` VALUES (3, 2, 19);
INSERT INTO `aoa_love_user` VALUES (60, 2, 20);
INSERT INTO `aoa_love_user` VALUES (68, 2, 21);
INSERT INTO `aoa_love_user` VALUES (69, 2, 22);
INSERT INTO `aoa_love_user` VALUES (72, 2, 23);
INSERT INTO `aoa_love_user` VALUES (72, 2, 24);
INSERT INTO `aoa_love_user` VALUES (73, 2, 25);
INSERT INTO `aoa_love_user` VALUES (73, 2, 26);
INSERT INTO `aoa_love_user` VALUES (59, 2, 27);
INSERT INTO `aoa_love_user` VALUES (59, 2, 28);
INSERT INTO `aoa_love_user` VALUES (59, 2, 29);
INSERT INTO `aoa_love_user` VALUES (59, 2, 30);
INSERT INTO `aoa_love_user` VALUES (59, 2, 31);
INSERT INTO `aoa_love_user` VALUES (59, 2, 32);
INSERT INTO `aoa_love_user` VALUES (84, 2, 33);
INSERT INTO `aoa_love_user` VALUES (73, 8, 34);
INSERT INTO `aoa_love_user` VALUES (73, 1, 35);
INSERT INTO `aoa_love_user` VALUES (89, 3, 36);
INSERT INTO `aoa_love_user` VALUES (2, 3, 37);
INSERT INTO `aoa_love_user` VALUES (5, 3, 39);
INSERT INTO `aoa_love_user` VALUES (92, 3, 40);
COMMIT;

-- ----------------------------
-- Table structure for aoa_mail_reciver
-- ----------------------------
DROP TABLE IF EXISTS `aoa_mail_reciver`;
CREATE TABLE `aoa_mail_reciver` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '中间表主键ID',
  `is_read` int(11) NOT NULL COMMENT '是否已读默认未读0',
  `mail_id` bigint(20) DEFAULT NULL COMMENT '内部邮件ID',
  `mail_reciver_id` bigint(20) DEFAULT NULL COMMENT '内部用户ID',
  `is_star` int(11) DEFAULT NULL COMMENT '是否星标',
  `is_del` int(11) DEFAULT NULL COMMENT '是否真正删除',
  PRIMARY KEY (`pk_id`),
  KEY `FKj8ki52vm052q6qdal2rkh2c9q` (`mail_id`),
  KEY `FK65vdrbmq9hu4hrhvtw6slwxlc` (`mail_reciver_id`),
  CONSTRAINT `FK65vdrbmq9hu4hrhvtw6slwxlc` FOREIGN KEY (`mail_reciver_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKj8ki52vm052q6qdal2rkh2c9q` FOREIGN KEY (`mail_id`) REFERENCES `aoa_in_mail_list` (`mail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_mail_reciver
-- ----------------------------
BEGIN;
INSERT INTO `aoa_mail_reciver` VALUES (3, 1, 5, 3, 0, 1);
INSERT INTO `aoa_mail_reciver` VALUES (5, 0, 13, 3, 0, 1);
INSERT INTO `aoa_mail_reciver` VALUES (6, 0, 15, 1, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (7, 1, 18, 1, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (8, 0, 19, 4, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (10, 1, 21, 2, 1, 0);
INSERT INTO `aoa_mail_reciver` VALUES (11, 1, 23, 1, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (12, 0, 23, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (13, 0, 24, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (14, 0, 24, 3, 0, 1);
INSERT INTO `aoa_mail_reciver` VALUES (15, 1, 25, 1, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (16, 0, 25, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (17, 0, 25, 4, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (18, 0, 26, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (19, 1, 26, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (20, 0, 27, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (21, 0, 27, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (22, 0, 28, 4, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (23, 1, 28, 5, 0, 1);
INSERT INTO `aoa_mail_reciver` VALUES (24, 0, 28, 6, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (25, 0, 29, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (27, 0, 30, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (28, 0, 30, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (29, 1, 30, 5, 0, 1);
INSERT INTO `aoa_mail_reciver` VALUES (30, 0, 30, 6, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (31, 0, 32, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (32, 0, 32, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (33, 0, 33, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (36, 1, 34, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (37, 1, 35, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (38, 0, 47, 9, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (39, 0, 47, 10, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (40, 0, 48, 10, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (41, 0, 50, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (42, 0, 53, 1, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (43, 0, 58, 2, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (44, 1, 58, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (45, 1, 58, 5, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (46, 0, 65, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (47, 0, 68, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (48, 1, 68, 5, 1, 0);
INSERT INTO `aoa_mail_reciver` VALUES (49, 0, 69, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (50, 1, 72, 5, 1, 0);
INSERT INTO `aoa_mail_reciver` VALUES (51, 0, 73, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (52, 0, 74, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (53, 1, 75, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (54, 1, 76, 5, 1, 0);
INSERT INTO `aoa_mail_reciver` VALUES (55, 1, 77, 5, 1, 0);
INSERT INTO `aoa_mail_reciver` VALUES (56, 1, 78, 5, 1, 0);
INSERT INTO `aoa_mail_reciver` VALUES (57, 0, 79, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (58, 0, 81, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (59, 0, 82, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (60, 0, 84, 3, 0, 0);
INSERT INTO `aoa_mail_reciver` VALUES (61, 0, 85, 3, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_mailnumber
-- ----------------------------
DROP TABLE IF EXISTS `aoa_mailnumber`;
CREATE TABLE `aoa_mailnumber` (
  `mail_number_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '邮箱账号表ID',
  `mail_account` varchar(255) NOT NULL COMMENT '邮箱账户',
  `mail_create_time` datetime DEFAULT NULL COMMENT '邮箱创建时间',
  `mail_des` varchar(255) DEFAULT NULL COMMENT '邮箱备注信息',
  `mail_type` bigint(20) DEFAULT NULL COMMENT '邮件账号类型',
  `mail_user_name` varchar(255) NOT NULL COMMENT '邮箱用户别名',
  `password` varchar(255) NOT NULL COMMENT '授权码',
  `status` bigint(20) DEFAULT NULL COMMENT '邮箱状态是否1有效2 无效',
  `mail_num_user_id` bigint(20) DEFAULT NULL COMMENT '邮箱用户ID',
  PRIMARY KEY (`mail_number_id`),
  KEY `FKn9qg20uba4xn2k5m62jrcyc6c` (`mail_num_user_id`),
  CONSTRAINT `FKn9qg20uba4xn2k5m62jrcyc6c` FOREIGN KEY (`mail_num_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_mailnumber
-- ----------------------------
BEGIN;
INSERT INTO `aoa_mailnumber` VALUES (1, '1057245260@qq.com', '2017-09-24 12:23:26', NULL, 1, '宋佳', 'scdvszfjjfrpbeaa', 1, 1);
INSERT INTO `aoa_mailnumber` VALUES (2, '664303632@qq.com', '2017-09-13 13:29:28', NULL, 1, '李明', '123456', 2, 1);
INSERT INTO `aoa_mailnumber` VALUES (3, '123456@qq.com', '2017-09-22 14:02:51', NULL, 2, 'ggg', '33333', 1, 1);
INSERT INTO `aoa_mailnumber` VALUES (4, '66@qq.com', '2017-09-24 18:26:31', '的点点滴滴', 1, '私事', '333', 1, 1);
INSERT INTO `aoa_mailnumber` VALUES (6, '66@qq.com', '2017-09-24 18:37:06', '的点点滴滴', 1, '滚滚滚', '55555', 2, 1);
INSERT INTO `aoa_mailnumber` VALUES (8, '123456@qq.com', '2017-09-28 20:33:06', 'hhh', 1, 'llll', '11111', 1, 2);
INSERT INTO `aoa_mailnumber` VALUES (9, '10@qq.com', '2017-09-25 18:45:52', '', 1, '多对多', '发vwv ', 1, 1);
INSERT INTO `aoa_mailnumber` VALUES (10, '45@qq.com', '2017-09-25 18:46:22', '是是是', 1, '吗vwjrerg ', '14982', 1, 1);
INSERT INTO `aoa_mailnumber` VALUES (11, '1234@qq.com', '2017-09-25 18:46:53', '', 1, '点点滴滴', 'dbetet', 2, 1);
INSERT INTO `aoa_mailnumber` VALUES (12, '12@qq.com', '2017-09-25 18:47:15', '', 1, '反反复复', '34455', 1, 1);
INSERT INTO `aoa_mailnumber` VALUES (13, '34@qq.com', '2017-09-25 18:47:35', '', 1, '别发额', '457895780', 1, 1);
INSERT INTO `aoa_mailnumber` VALUES (14, '123456@qq.com', '2019-11-12 18:59:08', '我的邮箱把', 1, '无误', '123', 1, 5);
INSERT INTO `aoa_mailnumber` VALUES (15, '123456@qq.com', '2019-11-12 19:01:22', '无效', 2, '网网', '456', 1, 5);
INSERT INTO `aoa_mailnumber` VALUES (17, '123456@qq.com', '2019-11-13 11:07:18', '十一月13号', 2, '十一月13号', '123', 1, 5);
INSERT INTO `aoa_mailnumber` VALUES (18, '123@qq.com', '2019-11-13 19:18:11', '爱迪生', 2, '网网', '123', 1, 5);
INSERT INTO `aoa_mailnumber` VALUES (19, '123456@qq.com', '2019-11-17 16:59:04', '我的新邮箱', 1, '琳琳', '123', 1, 3);
INSERT INTO `aoa_mailnumber` VALUES (20, '123456@qq.com', '2019-11-18 15:56:04', '新建的邮箱', 1, '无误2', '456', 1, 5);
INSERT INTO `aoa_mailnumber` VALUES (21, '942739886@qq.com', '2019-11-18 17:50:53', '我的邮件9', 1, '伊丽莎白', '123', 1, 5);
COMMIT;

-- ----------------------------
-- Table structure for aoa_note_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_note_list`;
CREATE TABLE `aoa_note_list` (
  `note_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '笔记id',
  `content` varchar(15000) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '笔记内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态id',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '笔记标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型id',
  `catalog_id` bigint(20) DEFAULT NULL COMMENT '目录id',
  `attach_id` bigint(20) DEFAULT NULL COMMENT '附件id',
  `is_collected` bigint(20) DEFAULT '0' COMMENT '是否收藏',
  `createman_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `receiver` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '笔记分享接收人名',
  PRIMARY KEY (`note_id`),
  KEY `FK3e1rxyyg851r231ln3ucnrg7q` (`catalog_id`),
  CONSTRAINT `FK3e1rxyyg851r231ln3ucnrg7q` FOREIGN KEY (`catalog_id`) REFERENCES `aoa_catalog` (`catalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_note_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_note_list` VALUES (1, 'sdfa', '2017-09-08 20:43:08', 8, 'hg', 6, 1, 46, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (90, 'zxc', '2017-09-07 19:12:07', 8, '90', 6, 2, 3, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (93, 'dfasf', '2017-09-14 10:04:34', 9, '93', 6, 1, 3, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (96, '哈哈', '2017-09-15 11:01:08', 8, '这张图片必须显示96', 5, 1, 6, 0, 2, NULL);
INSERT INTO `aoa_note_list` VALUES (101, '分享应该可以了吧', '2017-09-15 20:11:23', 8, '666101', 7, 1, 10, 1, 2, NULL);
INSERT INTO `aoa_note_list` VALUES (102, '快点老兄', '2017-09-15 20:14:51', 8, '666102', 7, 1, 11, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (111, '的说法', '2017-09-15 23:53:04', 8, '地方撒111', 7, 1, 7, 0, 1, '小李父斯基');
INSERT INTO `aoa_note_list` VALUES (120, 'dsaf', '2017-09-18 11:04:48', 8, 'werq 120', 5, 1, 9, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (122, 'dsaf但是', '2017-09-18 11:06:24', 8, '修改122', 5, 1, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (126, '大', '2017-09-23 11:43:05', 8, '地方撒发生126', 7, 1, NULL, 0, 1, 'soli;红之花');
INSERT INTO `aoa_note_list` VALUES (127, 'dsfa', '2017-09-23 12:34:05', 8, 'dfsa的127', 5, 1, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (128, 'sdaf', '2017-09-23 12:37:21', 8, 'dsa128', 6, 1, 42, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (137, '第三方', '2017-10-01 14:18:54', 8, '大师傅137', 7, 1, NULL, 0, 1, ';伊丽莎白');
INSERT INTO `aoa_note_list` VALUES (138, '发多少', '2017-10-01 14:30:48', 8, '分公司', 7, 1, NULL, 0, 1, '伊丽莎白');
INSERT INTO `aoa_note_list` VALUES (139, '士大夫', '2017-10-01 14:31:26', 8, '士大夫', 6, 1, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (140, '士大夫', '2017-10-01 14:36:19', 8, '手动阀', 7, 1, NULL, 0, 1, '伊丽莎白;小李父斯基');
INSERT INTO `aoa_note_list` VALUES (143, '发多少', '2017-10-01 14:57:13', 8, 'fdas ', 7, 1, NULL, 1, 1, ';发给');
INSERT INTO `aoa_note_list` VALUES (145, 'fd', '2017-10-01 16:01:33', 8, 'fggfd', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (146, '', '2017-10-01 16:02:51', 8, '新建发给', 5, 1, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (149, '地方撒1222222222222222', '2017-10-01 17:50:20', 8, '范德萨', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (150, '士大夫1111111111111', '2017-10-01 17:55:31', 8, '的是非得失', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (151, '更丰富付付付付付付付付付付付付付付付付', '2017-10-01 18:06:21', 8, '华哥', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (152, '22222222222222222222', '2017-10-01 18:09:32', 8, '地方撒', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (153, '1111111111111111111111', '2017-10-01 18:11:05', 8, '大师', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (154, '222222222222222222222', '2017-10-01 18:19:10', 8, '第三方', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (155, '哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或发凡方法付付', '2017-10-01 18:25:10', 8, '过后会或或', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (156, '东方时尚所说付发的大多多多多多多多', '2017-10-01 18:30:08', 8, ' 胡歌封帝', 5, 1, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (157, '东方时尚所所所所所所所所所', '2017-10-01 18:35:07', 8, '咯咯咯咯咯滚滚滚', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (158, '333333333333333', '2017-10-01 19:20:29', 8, '第三方', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (159, '2111111111111111111111111111', '2017-10-01 19:38:13', 8, '的说法', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (160, '2222222222222222222222222', '2017-10-01 19:42:55', 8, '的说法', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (161, '2222222222222222222222222222', '2017-10-01 19:49:55', 8, '大方法', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (162, '43333333333333333333333333', '2017-10-01 19:57:19', 8, '的说法', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (163, '444444444444444444444444444444444', '2017-10-01 19:59:18', 8, '第三方', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (164, '55555555555555555555555555555555', '2017-10-01 20:03:07', 8, '的说法', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (165, '3443242243333333333333', '2017-10-01 20:05:10', 8, '范德萨', 5, 1, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (166, '22222222222222222222222222', '2017-10-01 20:08:25', 8, '大对方是否收费', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (167, '3333333333333333333333', '2017-10-01 20:17:13', 8, '发生的', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (168, '11111111111111111111111', '2017-10-01 20:26:29', 8, '地方撒', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (169, '333333333333333333333', '2017-10-01 20:26:58', 8, '第', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (170, '知道吗 这个世界 随处都有万有引力', '2017-10-05 19:49:17', 8, '无语的n此房', 7, 1, NULL, 0, 1, '罗密欧;甄姬');
INSERT INTO `aoa_note_list` VALUES (171, '11111111111111111111111111111111111', '2017-10-05 20:19:31', 8, '的说法', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (172, '阿斯蒂芬三分333333333333', '2017-10-05 20:23:02', 8, '地方撒', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (173, '(⊙o⊙)…334334', '2017-10-05 20:23:27', 8, '的说法', 5, 2, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (174, '三大东方三大东方三大东方三大东方三大东方', '2017-10-05 20:25:30', 8, '三大东方', 7, 33, 226, 0, 3, '罗密欧;朱丽叶;伊丽莎白');
INSERT INTO `aoa_note_list` VALUES (175, '213131对方是否收费 23', '2017-10-05 20:27:17', 8, '范德萨23', 7, 1, NULL, 1, 1, '罗密欧;伊丽莎白');
INSERT INTO `aoa_note_list` VALUES (176, '2222222222222222222222222222', '2017-10-05 20:40:18', 8, '听说对方', 6, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (177, '233333333333333333333333', '2017-10-05 20:43:01', 8, '发生的发生', 7, 2, NULL, 0, 1, '小李父斯基;soli');
INSERT INTO `aoa_note_list` VALUES (178, '2333333333333333333333333333333', '2017-10-05 20:43:31', 9, '地方撒发生', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (179, '2333333333333333333333333333', '2017-10-05 20:48:03', 8, '大三', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (180, '33333333333333333333333', '2017-10-05 20:48:49', 8, '地方', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (181, '22222222222222222222222222222222', '2017-10-05 20:50:57', 8, '33333333333333', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (182, '3333333333333333', '2017-10-05 20:57:28', 9, '地方撒', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (183, '大师傅444444444444444444444', '2017-10-05 21:01:41', 8, '的说法', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (184, '3333333333333333333333333333333333', '2017-10-05 21:03:03', 8, 'ad231', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (187, '44444444444444444444444444444444444444', '2017-10-05 21:22:28', 8, '安抚第三方', 5, 1, NULL, 1, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (188, '324242533333333333333333390', '2017-10-05 22:48:20', 8, '大三', 5, 1, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (189, 'dsafffffff555555555555555555555555', '2017-10-06 11:15:14', 8, 'dfas ', 5, 33, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (190, '3333333333333333333333333333333333333', '2017-10-06 11:23:34', 8, 'sdfa ', 5, 33, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (191, '222222222222222222222222222222222222222222222222', '2017-10-06 11:29:14', 8, '34242423', 5, 33, NULL, 0, 7, NULL);
INSERT INTO `aoa_note_list` VALUES (192, '2323232323232323232323232323232323', '2017-10-06 22:29:33', 8, '发给', 5, 33, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (193, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这种程序可以通过网络传播并且能够跨平台运行。于是，世界各大</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/IT/16684878\">IT</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">企业为此纷纷投入了大量的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/Applet\">Applet</a><i>（Applet是一种将小程序嵌入到网页中进行执行的技术）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">，并将Oak更名为Java</span>', '2017-10-06 22:32:04', 8, '最终版本', 7, 33, 81, 0, 1, '丹琪;于彤');
INSERT INTO `aoa_note_list` VALUES (194, '444444444444444444444444444444', '2017-10-07 16:03:03', 8, '有附件', 5, 33, 64, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (195, '322222222222222222222222222222222222222222222', '2017-10-07 20:14:48', 9, '范德萨', 6, 33, NULL, 0, 23, NULL);
INSERT INTO `aoa_note_list` VALUES (196, '<a target=\"_blank\" href=\"https://baike.baidu.com/item/Java/85979\">Java</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">是一门</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1\">面向对象</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">编程语言，不仅吸收了</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/C%2B%2B\">C++</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">语言的各种优点，还摒弃了C++里难以理解的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%9A%E7%BB%A7%E6%89%BF\">多继承</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%8C%87%E9%92%88\">指针</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程</span><span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">[1]</span><a name=\"ref_[1]_12654100\"></a>&nbsp;<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">&nbsp;。</span>', '2017-10-08 16:22:44', 8, '上课要义', 5, 33, 77, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (198, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">由于在开发Oak语言时，尚且不存在运行字节码的硬件平台，所以为了在开发时可以对这种语言进行实验研究，他们就在已有的硬件和软件平台基础上，按照自己所指定的规范，用软件建设了一个运行平台，整个系统除了比C++更加简单之外，没有什么大的区别。1992年的夏天，当Oak语言开发成功后，研究者们向硬件生产商进行演示了Green操作系统、Oak的程序设计语言、类库和其硬件，以说服他们使用Oak语言生产硬件芯片，但是，硬件生产商并未对此产生极大的热情。因为他们认为，在所有人对Oak语言还一无所知的情况下，就生产硬件产品的风险实在太大了，所以Oak语言也就因为缺乏硬件的支持而无法进入市场，从而被搁置了下来</span>', '2017-10-18 15:39:45', 8, '测试', 5, 33, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (199, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">由于</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/C%2B%2B\">C++</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">所具有的优势，该项目组的研究人员首先考虑采用C++来编写程序。但对于</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A1%AC%E4%BB%B6\">硬件</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">资源极其匮乏的单片式系统来说，C++程序过于复杂和庞大。另外由于消费电子产品所采用的嵌入式处理器芯片的种类繁杂，如何让编写的程序</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%B7%A8%E5%B9%B3%E5%8F%B0\">跨平台</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">运行也是个难题。为了解决困难，他们首先着眼于语言的开发，假设了一种结构简单、符合嵌入式应用需要的硬件平台体系结构并为其制定了相应的规范，其中就定义了这种硬件平台的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%8C%E8%BF%9B%E5%88%B6\">二进制</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">机器码指令系统</span><i>（即后来成为“</i><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%AD%97%E8%8A%82%E7%A0%81\"><i>字节码</i></a><i>”的指令系统）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">，以待语言开发成功后，能有</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%8A%E5%AF%BC%E4%BD%93%E8%8A%AF%E7%89%87\">半导体芯片</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">生产商开发和生产这种硬件平台。对于新语言的设计，Sun公司研发人员并没有开发一种全新的语言，而是根据嵌入式软件的要求，对C++进行了改造，去除了留在C++的一些不太实用及影响安全的成分，并结合嵌入式系统的实时性要求，开发了一种称为</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/Oak\">Oak</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E8%AF%AD%E8%A8%80\">面向对象语言</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">。</span>', '2017-10-18 15:40:44', 8, '讨论', 7, 33, NULL, 0, 1, '甄姬2;无双');
INSERT INTO `aoa_note_list` VALUES (201, '312111111111111111111111111111111111111111111111111111111111', '2017-10-19 23:15:51', 8, '1231321', 5, 33, NULL, 0, 10, NULL);
INSERT INTO `aoa_note_list` VALUES (202, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">20世纪90年代，硬件领域出现了单片式计算机系统，这种价格低廉的系统一出现就立即引起了自动控制领域人员的注意，因为使用它可以大幅度提升消费类电子产品</span><i>（如电视机顶盒、面包烤箱、移动电话等）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%99%BA%E8%83%BD%E5%8C%96\">智能化</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">程度。Sun公司为了抢占市场先机，在1991年成立了一个称为Green的项目小组，</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B8%95%E7%89%B9%E9%87%8C%E5%85%8B/4831889\">帕特里克</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%A9%B9%E5%A7%86%E6%96%AF%C2%B7%E9%AB%98%E6%96%AF%E6%9E%97\">詹姆斯·高斯林</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、麦克·舍林丹和其他几个工程师一起组成的工作小组在</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8A%A0%E5%88%A9%E7%A6%8F%E5%B0%BC%E4%BA%9A\">加利福尼亚</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">州</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%97%A8%E6%B4%9B%E5%B8%95%E5%85%8B\">门洛帕克</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">市沙丘路的一个小工作室里面研究开发新技术，专攻计算机在家电产品上的嵌入式应用。</span>', '2017-10-22 01:04:54', 9, '2017某次笔记', 7, 33, 79, 0, 1, '甄姬;甄姬2');
INSERT INTO `aoa_note_list` VALUES (203, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">毛不易，网综《</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%98%8E%E6%97%A5%E4%B9%8B%E5%AD%90/20478071\">明日之子</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">》参赛选手，参加海选状况不断，他是明日之子唯一一个刚上场就录了三次音的选手，结果刚开口就被薛之谦闻到一股酒味，原来他上场前喝了几两白酒来缓解紧张，好不容易开始唱了，刚弹吉他，弦就断了，节目组帮忙换掉，张大大说不管怎么样都会送给他一把吉他，看起来他是一个十分有趣的小男生，一首《</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A6%82%E6%9E%9C%E6%9C%89%E4%B8%80%E5%A4%A9%E6%88%91%E5%8F%98%E5%BE%97%E5%BE%88%E6%9C%89%E9%92%B1\">如果有一天我变得很有钱</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">》内容很有趣，但是其中的落寞自嘲讥讽味道被薛之谦敏锐的发现了，他觉得毛不易可以走向更大的舞台，最终毛不易成功晋级。此后《巨星》唱出生活中的无奈，和《</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A6%82%E6%9E%9C%E6%9C%89%E4%B8%80%E5%A4%A9%E6%88%91%E5%8F%98%E5%BE%97%E5%BE%88%E6%9C%89%E9%92%B1\">如果有一天我变得很有钱</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">》异曲同工。之后他独创的《消愁》《像我这样的人》歌词字字扎入人心，听哭无数深夜里迷茫的人，“你写词写到我想给你跪”薛之谦这样赞赏他，“你被生活打了多少巴掌？”杨幂这样问到，一夜之间毛不易的《消愁》《像我这样的人》置顶流行音乐榜单，然而扎心依旧不断，一曲《借》直接让华晨宇给了他满分，他不仅歌唱的 好，词写的好，作曲的旋律也很美妙，其词曲不华丽不酷炫，却深深击中黑暗中迷茫前进的心。</span>', '2017-10-22 08:08:10', 9, '变重要', 7, 33, 80, 0, 1, '小李父斯基;甄姬');
INSERT INTO `aoa_note_list` VALUES (205, '<div>\r\n	<div>\r\n		<p>\r\n			下了直播软件我都不知道怎么玩，就在推荐的热门里面一个个点开看。纯粹好奇。<br />\r\n主播小姑娘绝大多数都很漂亮，小伙子也各有风采。<br />\r\n有的真的美丽俊朗到我想不通。\r\n		</p>\r\n		<p>\r\n			直播间里放烟花一样的撒礼物，哗啦哗啦的，浓妆艳抹的小姑娘不停的谢谢哥谢谢哥谢谢哥。<br />\r\n然后那些“哥”就继续哗啦哗啦的撒礼物。<br />\r\n一个比我胖3圈的胖妹直播吃火锅粉，全程无话，就呼哧呼哧的吃。收了2000金币……<br />\r\n简直颠覆我的认知。天上掉钱是不是就这个意思？\r\n		</p>\r\n		<p>\r\n			就在我准备关掉软件直接卸载的时候，鬼使神差看到了一个小伙子，戴着个大墨镜的头像，写着满满的“喊麦”两个字。<br />\r\n巧了，进去看看你吧。\r\n		</p>\r\n	</div>\r\n<br />\r\n作者：柯阿卡<br />\r\n链接：https://www.zhihu.com/question/38130123/answer/131454481<br />\r\n来源：知乎<br />\r\n著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\r\n</div>', '2017-10-22 09:12:41', 8, '今日笔记', 5, 33, 78, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (206, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了第二代Java平台（简称为Java2）的3个版本：</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/J2ME\">J2ME</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">（Java2 Micro Edition，Java2平台的微型版），应用于移动、无线及有限资源的环境；</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/J2SE\">J2SE</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">（Java 2 Standard Edition，Java 2平台的标准版），应用于桌面环境；</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/J2EE\">J2EE</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">（Java 2Enterprise Edition，Java 2平台的企业版），应用于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。</span>', '2017-10-22 11:28:16', 9, '论讲究', 7, 32, 82, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (207, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/Apple/3860362\">Apple</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/XML\">XML</a><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">支持、安全套接字</span><i>（Socket）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">支持</span><i>（通过SSL与TLS协议）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">、全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0</span><i>（内部版本号1.5.0）</i><span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">，代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、格式化I/O及可变参数。</span>', '2017-10-22 11:33:02', 8, '我的', 5, 2, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (208, '<div class=\"para\" style=\"font-size:14px;color:#333333;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">\r\n	2005年6月，在Java One大会上，Sun公司发布了Java SE 6。此时，Java的各种版本已经更名，已取消其中的数字2，如J2EE更名为<a target=\"_blank\" href=\"https://baike.baidu.com/item/JavaEE\">JavaEE</a>，J2SE更名为JavaSE，J2ME更名为<a target=\"_blank\" href=\"https://baike.baidu.com/item/JavaME\">JavaME</a>。<span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;\">[8]</span><a name=\"ref_[8]_12654100\"></a>&nbsp;\r\n</div>\r\n<div class=\"para\" style=\"font-size:14px;color:#333333;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">\r\n	2006年11月13日，Java技术的发明者Sun公司宣布，将Java技术作为免费软件对外发布。Sun公司正式发布的有关Java平台标准版的第一批源代码，以及Java迷你版的可执行源代码。从2007年3月起，全世界所有的开发人员均可对Java源代码进行修改<span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;\">[9]</span><a name=\"ref_[9]_12654100\"></a>&nbsp;&nbsp;。\r\n</div>', '2017-10-22 11:34:15', 8, '编程', 5, 33, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (209, '<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">2009年，甲骨文公司宣布收购Sun</span><span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">[10]</span><a name=\"ref_[10]_12654100\"></a>&nbsp;<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">&nbsp;。2010年，Java编程语言的共同创始人之一詹姆斯·高斯林从Oracle公司辞职。2011年，甲骨文公司举行了全球性的活动，以庆祝Java7的推出，随后Java7正式发布。2014年，甲骨文公司发布了Java8正式版</span><span style=\"font-size:12px;line-height:0;vertical-align:baseline;color:#3366CC;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">[11]</span><a name=\"ref_[11]_12654100\"></a>&nbsp;<span style=\"color:#333333;font-family:arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">&nbsp;。</span>', '2017-10-22 11:38:37', 8, '已经建立了', 5, 33, NULL, 0, 1, NULL);
INSERT INTO `aoa_note_list` VALUES (211, '大家好，我来了，飞起来吧，菲菲飞', '2019-11-07 08:50:27', 8, '上班记录', 6, 33, NULL, 0, 5, NULL);
INSERT INTO `aoa_note_list` VALUES (216, '我的错题笔记分享01我的错题笔记分享01我的错题笔记分享01我的错题笔记分享01我的错题笔记分享01', '2019-12-05 16:36:45', 8, '我的错题笔记分享01', 7, 12, 212, 0, 3, '伊丽莎白;小李父斯基;soli');
INSERT INTO `aoa_note_list` VALUES (218, '修改分享错题02分享错题02分享错题02分享错题02分享错题02', '2019-12-05 16:43:34', 8, '修改分享错题02', 7, 12, 214, 0, 3, '伊丽莎白;小李父斯基;soli');
INSERT INTO `aoa_note_list` VALUES (219, '加入图片<span>加入图片</span><span>加入图片</span><span>加入图片</span><span>加入图片</span><span>加入图片</span><span>加入图片</span>', '2019-12-05 20:15:41', 8, '修改有图片拉', 5, 33, 215, 1, 3, NULL);
INSERT INTO `aoa_note_list` VALUES (224, '错题收集001错题收集001错题收集001错题收集001错题收集001', '2019-12-06 15:18:31', 8, '错题收集001', 5, 12, 220, 1, 3, NULL);
INSERT INTO `aoa_note_list` VALUES (225, '笔记0001笔记0001笔记0001笔记0001笔记0001笔记0001', '2019-12-06 16:31:49', 8, '笔记0001', 5, 12, 221, 0, 3, NULL);
INSERT INTO `aoa_note_list` VALUES (226, '笔记0002笔记0002笔记0002笔记0002笔记0002笔记0002', '2019-12-06 16:32:50', 8, '笔记0002', 5, 11, 222, 0, 3, NULL);
INSERT INTO `aoa_note_list` VALUES (227, '笔记0003笔记0003笔记0003笔记0003笔记0003笔记0003', '2019-12-06 16:33:49', 9, '笔记0003', 6, 33, 223, 0, 3, NULL);
INSERT INTO `aoa_note_list` VALUES (228, '笔记0004笔记0004笔记0004笔记0004笔记0004笔记0004', '2019-12-06 16:34:18', 8, '笔记0004', 5, 12, 224, 1, 3, NULL);
INSERT INTO `aoa_note_list` VALUES (229, '笔记0005笔记0005笔记0005笔记0005笔记0005', '2019-12-06 16:35:02', 8, '笔记0005', 7, 33, 225, 0, 3, '罗密欧;朱丽叶;伊丽莎白;小李父斯基;soli');
COMMIT;

-- ----------------------------
-- Table structure for aoa_notepaper
-- ----------------------------
DROP TABLE IF EXISTS `aoa_notepaper`;
CREATE TABLE `aoa_notepaper` (
  `notepaper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '便签表主键ID',
  `concent` text CHARACTER SET utf8mb4  COMMENT '便签内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建标签时间',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '便签标题',
  `notepaper_user_id` bigint(20) DEFAULT NULL COMMENT '创建便签的用户ID',
  PRIMARY KEY (`notepaper_id`),
  KEY `FKsavcqw29haox5bu7y90it8jb7` (`notepaper_user_id`),
  CONSTRAINT `FKsavcqw29haox5bu7y90it8jb7` FOREIGN KEY (`notepaper_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_notepaper
-- ----------------------------
BEGIN;
INSERT INTO `aoa_notepaper` VALUES (1, '反反复复付付', '2017-09-21 22:49:12', 'wergfbebhet', 1);
INSERT INTO `aoa_notepaper` VALUES (2, 'gggggg', '2017-09-21 17:07:31', 'ggggg', 1);
INSERT INTO `aoa_notepaper` VALUES (3, '咯咯咯咯咯', '2017-09-21 22:46:21', '点点滴滴', NULL);
INSERT INTO `aoa_notepaper` VALUES (5, '密密麻麻木木木木木木', '2017-09-21 22:59:40', '咕咕咕咕', 1);
INSERT INTO `aoa_notepaper` VALUES (6, '呃呃呃', '2017-09-22 13:54:46', '凄凄切切', 1);
INSERT INTO `aoa_notepaper` VALUES (9, '巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不巴巴爸爸不不', '2017-09-22 15:08:28', '凄凄切切', 1);
INSERT INTO `aoa_notepaper` VALUES (10, '反反复复', '2017-09-25 17:04:12', '咕咕咕咕', 1);
INSERT INTO `aoa_notepaper` VALUES (11, '呜呜呜呜', '2017-09-25 17:04:27', '额鹅鹅鹅', 1);
INSERT INTO `aoa_notepaper` VALUES (12, '哈哈哈哈或', '2017-09-25 17:04:41', '哈哈哈哈或', 1);
INSERT INTO `aoa_notepaper` VALUES (13, '短发儿童heat哈人员建议他已经拿到挥汗如雨', '2017-09-25 17:04:51', '啦啦啦啦绿', 1);
INSERT INTO `aoa_notepaper` VALUES (14, '斤斤计较军军军', '2017-09-25 17:05:02', '咯咯咯咯咯过过过过', 1);
INSERT INTO `aoa_notepaper` VALUES (15, '郭碧婷混合双打国庆套qyy6u7ugv ', '2017-09-25 17:05:18', '点点滴滴', 1);
INSERT INTO `aoa_notepaper` VALUES (16, 'dsadssssssssss', '2017-10-14 23:59:39', 'fd', 1);
INSERT INTO `aoa_notepaper` VALUES (17, '此夜星辰非昨夜', '2017-10-15 00:00:20', '今天', 1);
INSERT INTO `aoa_notepaper` VALUES (18, '的说法', '2017-10-15 00:03:41', '是滴', 1);
INSERT INTO `aoa_notepaper` VALUES (23, '的说法', '2017-10-15 00:32:12', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (24, '士大夫', '2017-10-15 00:32:53', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (25, '的说法', '2017-10-15 00:33:35', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (26, '网速慢', '2017-10-15 00:33:52', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (27, '哈哈ui', '2017-10-15 00:36:55', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (28, '范德萨', '2017-10-16 18:28:08', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (29, '范德萨', '2017-10-16 18:28:11', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (30, '123456789', '2017-10-16 18:30:09', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (31, '范德萨', '2017-10-18 18:50:07', '无标题', 18);
INSERT INTO `aoa_notepaper` VALUES (32, '我们不一样', '2017-10-22 00:34:34', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (33, '我们不一样', '2017-10-22 00:34:36', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (34, '我们不一样', '2017-10-22 00:34:37', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (35, '我们不一样', '2017-10-22 00:34:38', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (36, '我们不一样', '2017-10-22 00:34:40', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (37, '一万头草泥吗', '2017-10-22 00:35:47', '无标题', 1);
INSERT INTO `aoa_notepaper` VALUES (39, '二次便签01便签01便签01便签01', '2019-12-23 16:06:01', '二次便签01', 3);
INSERT INTO `aoa_notepaper` VALUES (40, '三次修改了便签01便签01便签01便签01', '2019-12-23 15:53:23', '三次修改了便签01', 3);
COMMIT;

-- ----------------------------
-- Table structure for aoa_notice_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_notice_list`;
CREATE TABLE `aoa_notice_list` (
  `notice_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知表ID',
  `content` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '通知内容',
  `is_top` int(11) DEFAULT NULL COMMENT '该通知是否置顶',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `notice_time` datetime DEFAULT NULL COMMENT '发布通知的时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态ID',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '通知标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `url` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '通知内的链接',
  `user_id` bigint(20) DEFAULT NULL COMMENT '发布通知用户ID',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_notice_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_notice_list` VALUES (1, 'fdsa范德萨', 0, '2017-09-21 12:40:10', '2017-09-21 12:39:36', 14, 'interesting', 10, 'http://baidu.com', 1);
INSERT INTO `aoa_notice_list` VALUES (3, 'fsd fd a', 1, '2017-09-20 20:39:31', '2017-08-21 12:39:07', 14, 'fsa ', 12, 'fs ', 1);
INSERT INTO `aoa_notice_list` VALUES (4, 'fsdafds fdsa ', 1, '2017-09-21 13:25:39', '2017-09-21 12:39:13', 16, 'fdsafsa', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (5, 'fsd afs afsdf  s', 0, '2017-09-21 13:04:53', '2017-09-18 12:39:18', 14, 'what？？', 10, 'http://gson.cn/stu/996_1_20_2_cdetail_.html', 1);
INSERT INTO `aoa_notice_list` VALUES (7, '额，这个怎么描述呢？', 0, '2017-09-24 21:47:33', '2017-09-23 00:19:25', 15, '今天新增一个任务', 10, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (8, '11111111', 0, '2017-09-23 16:39:19', '2017-09-23 16:39:19', 14, '11111', 11, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (9, '2222222222', 0, '2017-09-23 16:39:40', '2017-09-23 16:39:40', 14, '2222222', 10, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (10, '33333333333333', 0, '2017-09-23 16:39:55', '2017-09-23 16:39:55', 14, '333333333', 10, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (11, '444444444444', 0, '2017-09-23 16:40:18', '2017-09-23 16:40:18', 14, '4444444444444', 10, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (12, '555555555', 0, '2017-09-23 16:40:43', '2017-09-23 16:40:43', 14, '555555555', 10, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (13, '6666666666', 0, '2017-09-23 16:40:58', '2017-09-23 16:40:58', 14, '66666666', 10, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (14, '77777777777', 0, '2017-09-23 16:41:12', '2017-09-23 16:41:12', 14, '77777777', 10, 'http://www.zxyoo.cn', 1);
INSERT INTO `aoa_notice_list` VALUES (15, 'fdsfa fdsa fds ', 0, '2017-09-24 15:35:55', '2017-09-24 15:35:55', 14, 'fdsfa ', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (16, 'fsd afsdf sa', 0, '2017-09-24 15:36:08', '2017-09-24 15:36:08', 14, 'fsd fs afa ', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (17, '312321', 0, '2017-09-24 18:44:39', '2017-09-24 15:36:18', 14, '31231', 11, '', 1);
INSERT INTO `aoa_notice_list` VALUES (18, '312413123', 0, '2017-09-24 15:36:27', '2017-09-24 15:36:27', 14, '321313', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (19, '312312314121414', 1, '2017-09-24 15:36:38', '2017-09-24 15:36:38', 14, '31231', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (20, '', 0, '2017-09-24 15:36:48', '2017-09-24 15:36:48', 14, '312312', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (21, '41241', 0, '2017-09-25 15:47:50', '2017-09-24 15:37:03', 14, '21313', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (22, '412431', 0, '2017-09-24 15:37:13', '2017-09-24 15:37:13', 14, '321312', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (23, '', 0, '2017-09-24 18:45:05', '2017-09-24 15:37:21', 14, '31231231', 12, '', 1);
INSERT INTO `aoa_notice_list` VALUES (24, '怎么办嘛？ 我没有树下？', 0, '2017-10-06 21:33:34', '2017-10-06 21:33:34', 16, '我下面没有员工，', 10, '', 2);
INSERT INTO `aoa_notice_list` VALUES (25, 'ijdfd', 0, '2018-02-04 01:07:27', '2018-02-04 01:07:27', 15, 'tonight so beatiful', 10, '', 1);
INSERT INTO `aoa_notice_list` VALUES (26, '西安666', 1, '2019-11-07 12:35:00', '2019-10-26 15:13:34', 16, '西安话摇滚就是得劲666', 11, '888', 5);
INSERT INTO `aoa_notice_list` VALUES (27, '好猕猴葡萄O', 1, '2019-11-06 08:30:31', '2019-11-06 08:30:31', 14, '张嘉译在猕猴桃果园', 10, '999', 3);
INSERT INTO `aoa_notice_list` VALUES (28, '好吃', 1, '2019-11-06 10:39:37', '2019-11-06 10:39:37', 14, '超燃翠香猕猴桃精图', 10, '000', 5);
INSERT INTO `aoa_notice_list` VALUES (29, '公告三', 1, '2019-11-06 10:40:46', '2019-11-06 10:40:46', 15, '公告3', 10, '333', 5);
INSERT INTO `aoa_notice_list` VALUES (30, '公告4 发布了', 1, '2019-11-06 11:47:55', '2019-11-06 10:42:06', 15, '公告4', 11, '444', 5);
INSERT INTO `aoa_notice_list` VALUES (31, '公告5发不了', 1, '2019-11-06 11:53:59', '2019-11-06 11:48:55', 15, '公告5', 10, '555', 5);
INSERT INTO `aoa_notice_list` VALUES (35, '我来啦', 0, '2019-11-06 16:05:23', '2019-11-06 16:05:23', 16, '通知拉伊丽莎白', 11, '000', 3);
INSERT INTO `aoa_notice_list` VALUES (36, '发布公告11了', 0, '2019-11-06 16:32:08', '2019-11-06 16:32:08', 15, '公告11', 10, '11111', 3);
INSERT INTO `aoa_notice_list` VALUES (37, '发布通知11了', 1, '2019-11-06 16:33:01', '2019-11-06 16:33:01', 15, '通知11', 11, '11111', 3);
INSERT INTO `aoa_notice_list` VALUES (38, '发布公告111', 1, '2019-11-06 20:09:44', '2019-11-06 20:09:44', 14, '公告111', 10, '111111', 3);
INSERT INTO `aoa_notice_list` VALUES (39, '发布公告222', 0, '2019-11-06 20:10:22', '2019-11-06 20:10:22', 14, '公告222', 10, '222222', 3);
INSERT INTO `aoa_notice_list` VALUES (40, '发布通知下班啦', 1, '2019-11-06 22:22:09', '2019-11-06 22:22:09', 15, '通知下班啦', 11, '888888', 3);
INSERT INTO `aoa_notice_list` VALUES (41, '发布公告999000', 1, '2019-11-07 12:37:26', '2019-11-06 23:00:58', 15, '公告999666', 10, '999000', 3);
INSERT INTO `aoa_notice_list` VALUES (42, '发布通知00', 0, '2019-11-07 08:41:59', '2019-11-07 08:41:59', 16, '通知00', 11, '通知00', 5);
INSERT INTO `aoa_notice_list` VALUES (43, '百度来了', 1, '2019-11-18 21:39:02', '2019-11-11 22:11:28', 14, '可以点了', 10, 'http://www.baidu.com', 5);
COMMIT;

-- ----------------------------
-- Table structure for aoa_notice_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `aoa_notice_user_relation`;
CREATE TABLE `aoa_notice_user_relation` (
  `relatin_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知与用户的关联表主键ID',
  `is_read` int(11) DEFAULT NULL COMMENT '是否已读，默认为0，未读',
  `relatin_notice_id` bigint(20) DEFAULT NULL COMMENT '公布通知表的ID',
  `relatin_user_id` bigint(20) DEFAULT NULL COMMENT '登录人用户ID（即接收通知的用户ID）',
  PRIMARY KEY (`relatin_id`),
  KEY `FKhxq8glkpb5qi1smn5gu142rky` (`relatin_notice_id`),
  KEY `FK52evvby6j47j24624ydi0o221` (`relatin_user_id`),
  CONSTRAINT `FK52evvby6j47j24624ydi0o221` FOREIGN KEY (`relatin_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKhxq8glkpb5qi1smn5gu142rky` FOREIGN KEY (`relatin_notice_id`) REFERENCES `aoa_notice_list` (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_notice_user_relation
-- ----------------------------
BEGIN;
INSERT INTO `aoa_notice_user_relation` VALUES (1, 1, 3, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (2, 0, 3, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (3, 0, 3, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (4, 1, 4, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (5, 0, 4, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (6, 0, 4, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (7, 0, 5, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (8, 0, 5, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (9, 0, 5, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (14, 1, 3, 1);
INSERT INTO `aoa_notice_user_relation` VALUES (15, 1, 4, 1);
INSERT INTO `aoa_notice_user_relation` VALUES (16, 1, 5, 1);
INSERT INTO `aoa_notice_user_relation` VALUES (17, 1, 7, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (18, 0, 7, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (19, 0, 7, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (20, 0, 8, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (21, 0, 8, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (22, 0, 8, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (23, 0, 9, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (24, 0, 9, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (25, 0, 9, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (26, 0, 10, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (27, 0, 10, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (28, 0, 10, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (29, 0, 11, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (30, 0, 11, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (31, 0, 11, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (32, 0, 12, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (33, 0, 12, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (34, 0, 12, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (35, 0, 13, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (36, 0, 13, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (37, 0, 13, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (38, 0, 14, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (39, 0, 14, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (40, 0, 14, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (41, 0, 15, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (42, 0, 15, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (43, 0, 15, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (44, 0, 16, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (45, 0, 16, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (46, 0, 16, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (47, 0, 17, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (48, 0, 17, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (49, 0, 17, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (50, 0, 18, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (51, 0, 18, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (52, 0, 18, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (53, 1, 19, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (54, 0, 19, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (55, 1, 19, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (56, 0, 20, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (57, 0, 20, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (58, 0, 20, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (59, 1, 21, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (60, 0, 21, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (61, 0, 21, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (62, 0, 22, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (63, 0, 22, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (64, 0, 22, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (65, 1, 23, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (66, 0, 23, 3);
INSERT INTO `aoa_notice_user_relation` VALUES (67, 0, 23, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (69, 0, 24, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (70, 1, 24, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (71, 1, 24, 8);
INSERT INTO `aoa_notice_user_relation` VALUES (72, 1, 25, 2);
INSERT INTO `aoa_notice_user_relation` VALUES (73, 0, 26, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (74, 0, 26, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (75, 0, 26, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (76, 0, 26, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (77, 0, 27, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (79, 0, 27, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (80, 0, 27, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (81, 0, 27, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (82, 0, 27, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (83, 0, 28, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (84, 0, 28, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (85, 0, 28, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (86, 0, 28, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (87, 0, 29, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (88, 0, 29, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (89, 0, 29, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (90, 0, 29, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (91, 0, 30, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (92, 0, 30, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (93, 0, 30, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (94, 0, 30, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (95, 0, 31, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (96, 0, 31, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (97, 0, 31, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (98, 0, 31, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (107, 0, 35, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (108, 1, 35, 5);
INSERT INTO `aoa_notice_user_relation` VALUES (109, 0, 35, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (110, 0, 35, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (111, 0, 35, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (112, 0, 35, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (113, 0, 36, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (115, 0, 36, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (116, 0, 36, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (117, 0, 36, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (118, 0, 36, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (119, 0, 37, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (121, 0, 37, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (122, 0, 37, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (123, 0, 37, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (124, 0, 37, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (125, 0, 37, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (126, 0, 37, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (127, 0, 37, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (128, 0, 37, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (129, 0, 36, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (130, 0, 36, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (131, 0, 36, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (132, 0, 36, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (133, 0, 35, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (134, 0, 35, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (135, 0, 35, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (136, 0, 35, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (137, 0, 38, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (138, 1, 38, 5);
INSERT INTO `aoa_notice_user_relation` VALUES (139, 0, 38, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (140, 0, 38, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (141, 0, 38, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (142, 0, 38, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (143, 0, 39, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (144, 1, 39, 5);
INSERT INTO `aoa_notice_user_relation` VALUES (145, 0, 39, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (146, 0, 39, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (147, 0, 39, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (148, 0, 39, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (149, 0, 39, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (150, 0, 39, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (151, 0, 39, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (152, 0, 39, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (153, 0, 38, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (154, 0, 38, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (155, 0, 38, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (156, 0, 38, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (157, 0, 40, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (159, 0, 40, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (160, 0, 40, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (161, 0, 40, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (162, 0, 40, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (163, 0, 41, 4);
INSERT INTO `aoa_notice_user_relation` VALUES (164, 0, 41, 5);
INSERT INTO `aoa_notice_user_relation` VALUES (165, 0, 41, 6);
INSERT INTO `aoa_notice_user_relation` VALUES (166, 0, 41, 7);
INSERT INTO `aoa_notice_user_relation` VALUES (167, 0, 41, 51);
INSERT INTO `aoa_notice_user_relation` VALUES (168, 0, 41, 53);
INSERT INTO `aoa_notice_user_relation` VALUES (169, 0, 40, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (170, 0, 40, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (171, 0, 40, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (172, 0, 40, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (173, 0, 42, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (174, 0, 42, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (175, 0, 42, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (176, 0, 42, 26);
INSERT INTO `aoa_notice_user_relation` VALUES (177, 0, 43, 14);
INSERT INTO `aoa_notice_user_relation` VALUES (178, 0, 43, 15);
INSERT INTO `aoa_notice_user_relation` VALUES (179, 0, 43, 16);
INSERT INTO `aoa_notice_user_relation` VALUES (180, 0, 43, 26);
COMMIT;

-- ----------------------------
-- Table structure for aoa_overtime
-- ----------------------------
DROP TABLE IF EXISTS `aoa_overtime`;
CREATE TABLE `aoa_overtime` (
  `overtime_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '加班表ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事意见',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '领导意见',
  PRIMARY KEY (`overtime_id`),
  KEY `FK5o36fvdsrrhvr9q4dvffxkuoc` (`pro_id`),
  CONSTRAINT `FK5o36fvdsrrhvr9q4dvffxkuoc` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_overtime
-- ----------------------------
BEGIN;
INSERT INTO `aoa_overtime` VALUES (16, 33, 117, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_plan_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_plan_list`;
CREATE TABLE `aoa_plan_list` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划表id',
  `create_time` datetime DEFAULT NULL COMMENT '计划创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '计划结束时间',
  `label` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '标签',
  `plan_comment` varchar(5000) CHARACTER SET utf8mb4  DEFAULT '' COMMENT '计划评论',
  `plan_content` varchar(10000) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '计划内容',
  `plan_summary` varchar(800) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '计划总结',
  `start_time` datetime NOT NULL COMMENT '计划开始时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '计划的状态id',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '计划标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '计划的类型id',
  `plan_user_id` bigint(20) DEFAULT NULL COMMENT '创建计划的用户ID',
  `attach_id` bigint(20) DEFAULT NULL COMMENT '计划的附件id',
  PRIMARY KEY (`plan_id`) USING BTREE,
  KEY `FKsqqfaj3e7rdl3jalr2sm0y4ln` (`plan_user_id`),
  CONSTRAINT `FKsqqfaj3e7rdl3jalr2sm0y4ln` FOREIGN KEY (`plan_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_plan_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_plan_list` VALUES (1, '2017-08-04 20:29:27', '2017-09-27 20:37:29', '无语', 'dsadsa', 'sadadfa1的说法3222222222222', '', '2017-09-22 20:37:29', 17, 'sadadfadsfds1', 13, 1, 9);
INSERT INTO `aoa_plan_list` VALUES (3, '2017-09-26 20:37:46', '2017-09-09 16:59:49', '', '发大水saddsf dsf dsfafdds ', 'sadadfad2', 'nice', '2017-09-23 16:59:49', 18, 'sadadfadsfds3', 13, 1, 47);
INSERT INTO `aoa_plan_list` VALUES (7, '2017-09-22 20:58:41', '2017-09-23 20:37:29', '', 'fdasdsfdfsd', 'sadadfad5', '', '2017-09-22 20:37:29', 18, 'sadadfadsfds7', 13, 2, NULL);
INSERT INTO `aoa_plan_list` VALUES (11, '2017-09-30 18:27:42', '2017-10-01 18:27:29', '', 'sa', 'dsafdfsafssdadsdsadfsadsaf', '', '2017-09-30 18:27:29', 17, 'adsfsaf的', 13, 3, NULL);
INSERT INTO `aoa_plan_list` VALUES (12, '2017-09-30 19:44:37', '2017-10-07 19:44:34', '', '', 'asddddddddffffffffffffffffffffffffffffffffffffffffffffffffff', '', '2017-09-30 19:44:34', 17, 'dasfasfdsa', 14, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (13, '2017-09-30 20:13:50', '2017-10-01 20:13:43', '', '', 'sadffdsadafsadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:13:43', 17, 'sadffdsadaf', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (14, '2017-09-30 20:14:00', '2017-10-01 20:13:53', '', '', 'sadffdsadafsadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:13:53', 17, 'sadffdsadaf', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (15, '2017-09-30 20:14:11', '2017-10-30 20:14:05', '', '', 'sadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:14:05', 17, 'sadffdsadaf', 15, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (16, '2017-09-30 20:14:19', '2017-10-01 20:14:14', '', '', 'sadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:14:14', 17, 'sadffdsadaf', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (17, '2017-09-30 20:14:27', '2017-10-01 20:14:22', '', '', 'sadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:14:22', 17, 'sadffdsadaf', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (18, '2017-09-30 20:14:36', '2017-10-01 20:14:30', '', '', 'sadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:14:30', 17, 'sadffdsadaf', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (19, '2017-09-30 20:14:44', '2017-10-01 20:14:39', '', '', 'sadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:14:39', 17, 'sadffdsadaf', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (20, '2017-09-30 20:14:51', '2017-10-01 20:14:47', '', 'hah ', 'sadffdsadafsadffdsadafsadffdsadaf', '', '2017-09-30 20:14:47', 17, 'sadffdsadaf', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (21, '2017-10-01 20:12:31', '2017-10-02 20:12:22', '', '', '2222222222222222222222222222222222222222', '', '2017-10-01 20:12:22', 17, '创造性', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (22, '2017-10-03 20:57:47', '2017-10-04 20:57:38', '', '', '55555555555555555555555', '', '2017-10-03 20:57:38', 17, '士大夫', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (23, '2017-10-07 16:03:58', '2017-10-08 16:03:33', '2313', '222二维222222222222222222222222222222222', '22222222222222222222222222222222222222222', '222二维222222222222222222222222222222222', '2017-10-07 16:03:33', 17, '发生的', 13, 1, 65);
INSERT INTO `aoa_plan_list` VALUES (24, '2017-10-09 14:17:25', '2017-10-10 14:17:13', 'dsf', 'sd', '33333333333333333333333333333333333333333333333', '33333333333333333333333333333333333333333333333', '2017-10-09 14:17:13', 17, 'sdf ', 13, 2, NULL);
INSERT INTO `aoa_plan_list` VALUES (25, '2017-10-09 14:53:50', '2017-10-10 14:53:33', 'dsfad', 'dsafdsffdsfds哈哈的说法但是哈哈', '3333333333333333333333333333324', 'ewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww', '2017-10-09 14:53:33', 18, 'dsfdf', 14, 2, NULL);
INSERT INTO `aoa_plan_list` VALUES (26, '2017-10-18 15:46:23', '2017-10-20 15:45:57', '', NULL, '3333333333333333333333333333333333333333333333333', '3333333333333333333333333333333333333333333333333', '2017-10-18 15:45:57', 17, 'ok', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (27, '2017-10-18 15:46:49', '2017-10-19 15:46:27', '', NULL, '321444444444444444444444444444444444444444444', '', '2017-10-18 15:46:27', 17, '地方', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (28, '2017-10-18 15:47:27', '2017-10-19 15:46:54', '纳尼', NULL, '超级不爽 真是无语 哈哈  。。，，，，，，，，，，，，，，，，，，，，，', '', '2017-10-18 15:46:54', 17, '无语 ', 13, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (29, '2017-10-18 16:13:02', '2017-10-19 16:12:22', '哈哈', NULL, '带你去看海带你去看海带你去看海带你去看海', '', '2017-10-18 16:12:22', 17, '带你去看海', 13, 1, 71);
INSERT INTO `aoa_plan_list` VALUES (30, '2017-10-18 16:13:35', '2017-10-19 16:13:18', '', NULL, '真无语啊真无语啊真无语啊真无语啊真无语啊真无语啊', '', '2017-10-18 16:13:18', 17, '真是无语', 14, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (31, '2017-10-18 16:15:00', '2017-11-18 16:14:37', '', NULL, '。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '', '2017-10-18 16:14:37', 17, '无语', 15, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (32, '2017-10-18 16:23:34', '2017-10-25 16:23:16', '', '感觉啥都没有干 库', '无语的n此房无语的n此房无语的n此房无语的n此房无语的n此房', '', '2017-10-18 16:23:16', 17, '无语的n此房', 14, 3, NULL);
INSERT INTO `aoa_plan_list` VALUES (33, '2017-10-18 16:23:58', '2017-11-18 16:23:43', '', NULL, '我也很无奈我也很无奈我也很无奈我也很无奈我也很无奈我也很无奈', '', '2017-10-18 16:23:43', 17, '我也很无奈', 15, 3, NULL);
INSERT INTO `aoa_plan_list` VALUES (34, '2017-10-18 16:31:41', '2017-10-19 16:31:25', '', '666', '也无语是吧也无语是吧也无语是吧也无语是吧也无语是吧也无语是吧', '', '2017-10-18 16:31:25', 17, '也无语是吧', 15, 3, NULL);
INSERT INTO `aoa_plan_list` VALUES (35, '2017-10-20 10:20:27', '2017-10-27 10:19:46', '这首歌', NULL, '仅仅代表着仅仅代表着仅仅代表着仅仅代表着仅仅代表着仅仅代表着', '', '2017-10-20 10:19:46', 18, '仅仅代表着', 14, 1, NULL);
INSERT INTO `aoa_plan_list` VALUES (38, '2017-10-20 10:23:49', '2017-11-20 10:23:18', '泪已拆两行', NULL, '雨打死了眼眶雨打死了眼眶雨打死了眼眶雨打死了眼眶雨打死了眼眶雨打死了眼眶', '', '2017-10-20 10:23:18', 18, '雨打死了眼眶', 15, 5, NULL);
INSERT INTO `aoa_plan_list` VALUES (39, '2017-10-20 10:24:39', '2017-10-27 10:23:54', '轻轻唱', NULL, '折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁折菊寄到你身旁', '', '2017-10-20 10:23:54', 18, '折菊寄到你身旁', 14, 5, NULL);
INSERT INTO `aoa_plan_list` VALUES (40, '2017-10-20 10:25:58', '2017-10-21 10:24:44', '谁一颦一笑摇曳了星云', NULL, '多年不减你深情多年不减你深情多年不减你深情多年不减你深情多年不减你深情', '', '2017-10-20 10:24:44', 17, '多年不减你深情', 13, 5, NULL);
INSERT INTO `aoa_plan_list` VALUES (41, '2017-10-20 10:29:20', '2017-10-27 10:26:14', '和落下的老爷爷一样', '小伙子可以啊', '又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上又是一个安静的晚上', '', '2017-10-20 10:26:14', 18, '又是一个安静的晚上', 14, 5, NULL);
INSERT INTO `aoa_plan_list` VALUES (42, '2017-10-20 10:30:13', '2017-11-20 10:29:29', '素面朝天要多纯洁有多纯洁', NULL, '我做我的改成又何必纠结我做我的改成又何必纠结我做我的改成又何必纠结我做我的改成又何必纠结我做我的改成又何必纠结', '', '2017-10-20 10:29:29', 17, '我做我的改成又何必纠结', 15, 5, NULL);
INSERT INTO `aoa_plan_list` VALUES (43, '2017-10-20 10:32:37', '2017-10-21 10:32:14', '', NULL, '曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间曾经对上的瞬间', '', '2017-10-20 10:32:14', 17, '曾经对上的瞬间', 13, 4, NULL);
INSERT INTO `aoa_plan_list` VALUES (44, '2017-10-20 10:34:10', '2017-10-27 10:32:45', '', NULL, '瘦马未得好歌瘦马未得好歌瘦马未得好歌瘦马未得好歌瘦马未得好歌瘦马未得好歌', '', '2017-10-20 10:32:45', 17, '瘦马未得好歌', 14, 4, NULL);
INSERT INTO `aoa_plan_list` VALUES (45, '2017-10-20 10:34:28', '2017-10-27 10:34:15', '', NULL, '千百度千百度千百度千百度千百度千百度千百度千百度千百度千百度千百度千百度', '', '2017-10-20 10:34:15', 18, '千百度', 14, 4, NULL);
INSERT INTO `aoa_plan_list` VALUES (46, '2017-10-20 10:35:00', '2017-11-20 10:34:36', '', NULL, '课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处课你却不在灯火阑珊处', '', '2017-10-20 10:34:36', 17, '课你却不在灯火阑珊处', 15, 4, 74);
INSERT INTO `aoa_plan_list` VALUES (47, '2017-10-20 10:36:07', '2017-10-21 10:35:23', '', NULL, '日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮日出到迟暮', '', '2017-10-20 10:35:23', 17, '日出到迟暮', 13, 4, 75);
INSERT INTO `aoa_plan_list` VALUES (48, '2017-10-20 10:36:33', '2017-10-21 10:36:18', '', 'df', '灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处灯火阑珊处', '', '2017-10-20 10:36:18', 17, '灯火阑珊处', 13, 4, NULL);
INSERT INTO `aoa_plan_list` VALUES (49, '2017-10-20 10:37:59', '2017-10-21 10:37:16', '', NULL, '为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河为你解冻冰河', '', '2017-10-20 10:37:16', 17, '如果有时不那么开心', 13, 7, NULL);
INSERT INTO `aoa_plan_list` VALUES (50, '2017-10-20 10:38:23', '2017-10-27 10:38:04', '', NULL, '为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧为你辗转反侧', '', '2017-10-20 10:38:04', 17, '为你辗转反侧', 14, 7, NULL);
INSERT INTO `aoa_plan_list` VALUES (51, '2017-10-20 10:38:52', '2017-10-21 10:38:27', '', NULL, '天空好像下雨天空好像下雨天空好像下雨天空好像下雨天空好像下雨天空好像下雨天空好像下雨', '', '2017-10-20 10:38:27', 17, '天空好像下雨', 13, 7, NULL);
INSERT INTO `aoa_plan_list` VALUES (52, '2017-10-20 10:39:16', '2017-10-27 10:38:58', '', NULL, '亲手买冰激凌亲手买冰激凌亲手买冰激凌亲手买冰激凌亲手买冰激凌亲手买冰激凌', '', '2017-10-20 10:38:58', 17, '亲手买冰激凌', 14, 7, NULL);
INSERT INTO `aoa_plan_list` VALUES (53, '2017-10-20 10:39:41', '2017-10-21 10:39:20', '', NULL, '为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾为你做一只铺货的飞蛾', '', '2017-10-20 10:39:20', 18, '为你做一只铺货的飞蛾', 13, 7, NULL);
INSERT INTO `aoa_plan_list` VALUES (54, '2017-10-20 10:40:03', '2017-10-27 10:39:48', '', NULL, '啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦', '', '2017-10-20 10:39:48', 19, '啦啦啦啦', 14, 7, 76);
INSERT INTO `aoa_plan_list` VALUES (55, '2017-10-22 10:32:33', '2017-10-23 10:29:49', '这次计划', '这个计划 nice', '1996年1月，Sun公司发布了Java的第一个开发工具包（JDK 1.0），这是Java发展历程中的重要里程碑，标志着Java成为一种独立的开发工具。9月，约8.3万个网页应用了Java技术来制作。10月，Sun公司发布了Java平台的第一个即时（JIT）编译器。\r\n1997年2月，JDK 1.1面世，在随后的3周时间里，达到了22万次的下载量。4月2日，Java One会议召开，参会者逾一万人，创当时全球同类会议规模之纪录。9月，Java Developer Connection社区成员超过10万。', 'Java One会议召开，参会者逾一万人，创当时全球同类会议规模之纪录。9月，Java Developer Connection社区成员超过10万。', '2017-10-22 10:29:49', 19, '周计划', 14, 7, NULL);
INSERT INTO `aoa_plan_list` VALUES (61, '2019-11-23 17:08:38', '2019-11-24 16:34:15', '盛柔思标签1', '盛如思的日计划评价了1盛如思的日计划评价了1', '盛柔思标题111111111111111111111111111111111111', '盛柔思标题1111111111111111111111111111111', '2019-11-23 16:34:15', 17, '盛柔思标题1-1', 13, 14, 202);
INSERT INTO `aoa_plan_list` VALUES (62, '2019-11-23 16:39:03', '2019-11-30 16:36:57', '周计划盛柔思标签2', '', '周计划盛柔思计划22222222222222222222222222', '周计划盛柔思总结22222222222222222222222222', '2019-11-23 16:36:57', 17, '周计划盛柔思标题2', 14, 14, 196);
INSERT INTO `aoa_plan_list` VALUES (63, '2019-11-23 16:40:23', '2019-12-23 16:39:19', '月计划盛柔思计划3', '', '月计划盛柔思计划333333333333333333333333333', '月计划盛柔思计划33333333333333333333333', '2019-11-23 16:39:19', 17, '月计划盛柔思计划3', 15, 14, 197);
INSERT INTO `aoa_plan_list` VALUES (64, '2019-11-23 17:09:58', '2019-11-24 16:34:15', '盛柔思标签1', '盛如思1-2评论了', '盛柔思标题111111111111111111111111111111111111', '盛柔思标题1111111111111111111111111111111', '2019-11-23 16:34:15', 17, '盛柔思标题1-2', 13, 14, 203);
INSERT INTO `aoa_plan_list` VALUES (65, '2019-11-23 16:55:35', '2019-12-23 16:39:19', '月计划盛柔思计划3', '', '月计划盛柔思计划333333333333333333333333333', '月计划盛柔思计划33333333333333333333333', '2019-11-23 16:39:19', 17, '月计划盛柔思计划3', 15, 14, 199);
INSERT INTO `aoa_plan_list` VALUES (66, '2019-11-23 17:00:15', '2019-11-30 16:36:57', '周计划盛柔思标签2', '', '周计划盛柔思计划22222222222222222222222222', '周计划盛柔思总结22222222222222222222222222', '2019-11-23 16:36:57', 17, '周计划盛柔思标题2', 14, 14, 200);
INSERT INTO `aoa_plan_list` VALUES (67, '2019-11-23 17:03:16', '2019-11-30 16:36:57', '周计划盛柔思标签2', '', '周计划盛柔思计划22222222222222222222222222', '周计划盛柔思总结22222222222222222222222222', '2019-11-23 16:36:57', 17, '周计划盛柔思标题2', 14, 14, 201);
INSERT INTO `aoa_plan_list` VALUES (68, '2019-11-27 10:06:38', '2019-11-24 22:01:27', '李楚唐标题签', '可以修改评价拉1', '李楚唐标题111111111111111111111111', '李楚唐标题1111111111111111', '2019-11-23 22:01:27', 17, '李楚唐标题1', 13, 5, 206);
COMMIT;

-- ----------------------------
-- Table structure for aoa_position
-- ----------------------------
DROP TABLE IF EXISTS `aoa_position`;
CREATE TABLE `aoa_position` (
  `position_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `level` int(11) DEFAULT NULL COMMENT '职位层级',
  `name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '职位名称',
  `describtion` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '职位描述',
  `deptid` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_position
-- ----------------------------
BEGIN;
INSERT INTO `aoa_position` VALUES (1, 1, '总经办', '管理系统最高权限', 1);
INSERT INTO `aoa_position` VALUES (2, 2, 'CEO', '好啦欧', 1);
INSERT INTO `aoa_position` VALUES (3, 3, '总经理', '你好', 1);
INSERT INTO `aoa_position` VALUES (4, 6, '调查专员', '调查', 2);
INSERT INTO `aoa_position` VALUES (5, 5, '财务部经理', NULL, 3);
INSERT INTO `aoa_position` VALUES (6, 6, '市场部经理', NULL, 4);
INSERT INTO `aoa_position` VALUES (7, 7, '人事部经理', NULL, 5);
INSERT INTO `aoa_position` VALUES (8, 8, '人事专员', NULL, 5);
INSERT INTO `aoa_position` VALUES (9, 9, '劳资专员', NULL, 5);
INSERT INTO `aoa_position` VALUES (10, 6, '程序员', '你好吗坎坎坷坷扩', 2);
INSERT INTO `aoa_position` VALUES (11, 11, '初级工程师', NULL, 2);
INSERT INTO `aoa_position` VALUES (12, 12, '中级工程师', NULL, 2);
INSERT INTO `aoa_position` VALUES (13, 13, '高级工程师', NULL, 2);
INSERT INTO `aoa_position` VALUES (14, 14, '系统架构师', NULL, 2);
INSERT INTO `aoa_position` VALUES (15, 15, '需求分析师', NULL, 2);
INSERT INTO `aoa_position` VALUES (16, 16, '调查专员', NULL, 4);
INSERT INTO `aoa_position` VALUES (17, 17, '企业推广员', NULL, 4);
INSERT INTO `aoa_position` VALUES (18, 18, '平面设计师', NULL, 4);
INSERT INTO `aoa_position` VALUES (19, 19, '培训专员', NULL, 4);
INSERT INTO `aoa_position` VALUES (20, 20, '市场督导员', NULL, 4);
INSERT INTO `aoa_position` VALUES (21, 21, '核算会计', '加油', 3);
INSERT INTO `aoa_position` VALUES (22, 22, '税务会计', NULL, 3);
INSERT INTO `aoa_position` VALUES (23, 23, '出纳员', NULL, 3);
INSERT INTO `aoa_position` VALUES (26, 1, '测试职位1', '啊实打实的', 19);
INSERT INTO `aoa_position` VALUES (30, 6, '文员', '大家好', 5);
INSERT INTO `aoa_position` VALUES (34, NULL, '经理', NULL, 8);
INSERT INTO `aoa_position` VALUES (35, NULL, '文员', NULL, 8);
INSERT INTO `aoa_position` VALUES (39, 6, '加油', '加油吧', 21);
COMMIT;

-- ----------------------------
-- Table structure for aoa_process_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_process_list`;
CREATE TABLE `aoa_process_list` (
  `process_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程主表ID',
  `apply_time` datetime DEFAULT NULL COMMENT '流程申请时间',
  `deeply_id` bigint(20) DEFAULT NULL COMMENT '紧急程度',
  `end_time` datetime DEFAULT NULL COMMENT '流程结束时间',
  `process_des` text CHARACTER SET utf8mb4  COMMENT '流程申请原因内容',
  `process_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '标题',
  `procsee_days` int(11) DEFAULT NULL COMMENT '流程总天数',
  `is_checked` int(10) DEFAULT NULL COMMENT '流程是否被驳回',
  `start_time` datetime DEFAULT NULL COMMENT '流程开始时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '流程申请状态ID',
  `type_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '流程申请类型',
  `pro_file_id` bigint(20) DEFAULT NULL COMMENT '流程附件ID',
  `process_user_id` bigint(20) DEFAULT NULL COMMENT '流程申请人ID',
  `shenuser` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '审核人的名字',
  PRIMARY KEY (`process_id`),
  KEY `FKiltoi9iw3vjixl6u4cd60fi1p` (`pro_file_id`),
  KEY `FKhtdg4du5ryotah5v1dgyjfh2t` (`process_user_id`),
  CONSTRAINT `FKhtdg4du5ryotah5v1dgyjfh2t` FOREIGN KEY (`process_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKiltoi9iw3vjixl6u4cd60fi1p` FOREIGN KEY (`pro_file_id`) REFERENCES `aoa_attachment_list` (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_process_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_process_list` VALUES (111, '2019-11-10 18:10:09', 23, NULL, '费用报销1来了', '费用报销测试1', NULL, 0, NULL, 24, '费用报销', 134, 5, '伊丽莎白;甄姬');
INSERT INTO `aoa_process_list` VALUES (112, '2019-11-10 18:13:17', 24, '2019-11-13 18:10:46', '工作', '出差申请报销单测试1', 3, 0, '2019-11-10 18:10:46', 25, '出差费用', 135, 5, '伊丽莎白;甄姬');
INSERT INTO `aoa_process_list` VALUES (113, '2019-11-10 18:14:14', 24, '2019-11-14 18:13:26', '上班啊', '出差申请单测试1', 4, 0, '2019-11-10 18:13:26', 25, '出差申请', 136, 5, '伊丽莎白;甄姬2');
INSERT INTO `aoa_process_list` VALUES (114, '2019-11-10 18:15:36', 23, '2019-11-11 18:14:43', '有事', '请假申请测试1', 1, 0, '2019-11-10 18:14:43', 23, '请假申请', 137, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (115, '2019-11-10 18:16:18', 22, NULL, '走啦', '离职申请测试1', NULL, 0, NULL, 23, '离职申请', NULL, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (117, '2019-11-10 18:22:42', 22, '2019-11-12 18:21:57', '加班2', '加班申请测试2', 2, 0, '2019-11-10 18:21:57', 23, '加班申请', NULL, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (118, '2019-11-11 21:47:07', 22, '2019-11-13 21:42:46', '上班啊', '出差申请99', 2, 0, '2019-11-11 21:42:46', 23, '出差申请', 138, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (119, '2019-11-12 11:31:28', 22, '2019-11-14 11:29:32', 'dfb', '上海666', 2, 0, '2019-11-12 11:29:32', 23, '出差申请', 139, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (120, '2019-11-12 11:36:44', 22, '2019-11-14 11:33:31', 'dfb', '上海666', 2, 0, '2019-11-12 11:33:31', 23, '出差申请', 140, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (121, '2019-11-12 11:36:44', 22, '2019-11-14 11:33:31', 'dfb', '上海666', 2, 0, '2019-11-12 11:33:31', 23, '出差申请', 141, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (122, '2019-11-12 11:47:08', 22, '2019-11-14 11:45:47', 'xdb', '上海666', 2, 0, '2019-11-12 11:45:47', 23, '出差申请', 142, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (123, '2019-11-12 11:50:24', 22, '2019-11-15 11:48:45', 'dbx', '上海666', 3, 0, '2019-11-12 11:48:45', 23, '出差申请', 143, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (124, '2019-11-12 12:32:07', 22, '2019-11-15 12:31:28', 'sdhv', '上海000', 3, 0, '2019-11-12 12:31:28', 23, '出差申请', 144, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (125, '2019-11-12 12:39:02', 22, '2019-11-12 12:37:37', 'jsz', '上海66600', 0, 0, '2019-11-12 12:37:37', 23, '出差申请', 145, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (126, '2019-11-12 13:02:58', 22, '2019-11-14 12:58:18', 'bhc', 'skbd', 0, 0, '2019-11-12 12:58:18', 23, '出差申请', 146, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (127, '2019-11-12 13:09:42', 22, '2019-11-12 13:03:47', 'kbjj', '上海', 0, 0, '2019-11-12 13:03:47', 23, '出差申请', 147, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (128, '2019-11-12 13:12:03', 22, '2019-11-14 13:10:16', '几乎是把', '上海00', 0, 0, '2019-11-12 13:10:16', 23, '出差申请', 148, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (129, '2019-11-12 14:11:31', 22, '2019-11-15 14:06:55', 'dzbv', '上海555', 3, 0, '2019-11-12 14:06:55', 23, '出差申请', 149, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (130, '2019-11-12 14:14:37', 22, '2019-11-21 14:12:18', 'nds', '上海988', 0, 0, '2019-11-12 14:12:18', 23, '出差申请', 150, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (131, '2019-11-12 14:20:22', 22, '2019-11-14 14:15:12', 'jhb', '上海66677', 2, 0, '2019-11-12 14:15:12', 23, '出差申请', 151, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (132, '2019-11-12 15:59:32', 22, '2019-11-20 15:56:53', NULL, '转正申请1', 8, 0, '2019-11-12 15:56:53', 25, '转正申请', NULL, 14, 'soli');
INSERT INTO `aoa_process_list` VALUES (133, '2019-11-12 22:28:03', 22, '2019-11-14 22:25:34', 'shfd', '上海6666644', 0, 0, '2019-11-12 22:25:34', 23, '出差申请', 152, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (134, '2019-11-12 22:34:06', 22, '2019-11-14 22:28:34', 'zjdbh', 'idshg', 2, 0, '2019-11-12 22:28:34', 23, '出差申请', 153, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (135, '2019-11-12 22:36:35', 22, '2019-11-18 22:34:30', 'hh', 'jwahfe', 0, 0, '2019-11-12 22:34:30', 23, '出差申请', 154, 5, '伊丽莎白');
INSERT INTO `aoa_process_list` VALUES (136, '2019-11-12 22:44:45', 22, '2019-11-20 22:37:01', 'sjhv', 'v', 0, 0, '2019-11-12 22:37:01', 23, '出差申请', 155, 5, '伊丽莎白');
COMMIT;

-- ----------------------------
-- Table structure for aoa_receiver_note
-- ----------------------------
DROP TABLE IF EXISTS `aoa_receiver_note`;
CREATE TABLE `aoa_receiver_note` (
  `note_id` bigint(20) NOT NULL COMMENT '笔记id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户笔记关联表id',
  PRIMARY KEY (`id`),
  KEY `FK904cmor3q468pj3ft6mdrnqwk` (`user_id`),
  KEY `FKcx7spjjefkofw62v8yxmgjxao` (`note_id`),
  CONSTRAINT `FK904cmor3q468pj3ft6mdrnqwk` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FK_NOTE_LIST` FOREIGN KEY (`note_id`) REFERENCES `aoa_note_list` (`note_id`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKcx7spjjefkofw62v8yxmgjxao` FOREIGN KEY (`note_id`) REFERENCES `aoa_note_list` (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_receiver_note
-- ----------------------------
BEGIN;
INSERT INTO `aoa_receiver_note` VALUES (128, 1, 19);
INSERT INTO `aoa_receiver_note` VALUES (122, 1, 22);
INSERT INTO `aoa_receiver_note` VALUES (127, 1, 24);
INSERT INTO `aoa_receiver_note` VALUES (120, 1, 25);
INSERT INTO `aoa_receiver_note` VALUES (137, 3, 42);
INSERT INTO `aoa_receiver_note` VALUES (126, 6, 43);
INSERT INTO `aoa_receiver_note` VALUES (126, 5, 44);
INSERT INTO `aoa_receiver_note` VALUES (111, 4, 45);
INSERT INTO `aoa_receiver_note` VALUES (138, 3, 46);
INSERT INTO `aoa_receiver_note` VALUES (139, 1, 47);
INSERT INTO `aoa_receiver_note` VALUES (140, 4, 48);
INSERT INTO `aoa_receiver_note` VALUES (1, 1, 57);
INSERT INTO `aoa_receiver_note` VALUES (143, 1, 59);
INSERT INTO `aoa_receiver_note` VALUES (145, 1, 61);
INSERT INTO `aoa_receiver_note` VALUES (146, 1, 63);
INSERT INTO `aoa_receiver_note` VALUES (149, 1, 66);
INSERT INTO `aoa_receiver_note` VALUES (150, 1, 67);
INSERT INTO `aoa_receiver_note` VALUES (151, 1, 68);
INSERT INTO `aoa_receiver_note` VALUES (152, 1, 69);
INSERT INTO `aoa_receiver_note` VALUES (153, 1, 70);
INSERT INTO `aoa_receiver_note` VALUES (154, 1, 71);
INSERT INTO `aoa_receiver_note` VALUES (155, 1, 72);
INSERT INTO `aoa_receiver_note` VALUES (156, 1, 73);
INSERT INTO `aoa_receiver_note` VALUES (157, 1, 74);
INSERT INTO `aoa_receiver_note` VALUES (158, 1, 75);
INSERT INTO `aoa_receiver_note` VALUES (159, 1, 76);
INSERT INTO `aoa_receiver_note` VALUES (160, 1, 77);
INSERT INTO `aoa_receiver_note` VALUES (161, 1, 78);
INSERT INTO `aoa_receiver_note` VALUES (162, 1, 79);
INSERT INTO `aoa_receiver_note` VALUES (163, 1, 80);
INSERT INTO `aoa_receiver_note` VALUES (164, 1, 81);
INSERT INTO `aoa_receiver_note` VALUES (165, 1, 82);
INSERT INTO `aoa_receiver_note` VALUES (166, 1, 83);
INSERT INTO `aoa_receiver_note` VALUES (167, 1, 84);
INSERT INTO `aoa_receiver_note` VALUES (168, 1, 85);
INSERT INTO `aoa_receiver_note` VALUES (169, 1, 87);
INSERT INTO `aoa_receiver_note` VALUES (170, 7, 117);
INSERT INTO `aoa_receiver_note` VALUES (171, 1, 118);
INSERT INTO `aoa_receiver_note` VALUES (172, 1, 119);
INSERT INTO `aoa_receiver_note` VALUES (173, 1, 120);
INSERT INTO `aoa_receiver_note` VALUES (174, 1, 121);
INSERT INTO `aoa_receiver_note` VALUES (174, 3, 122);
INSERT INTO `aoa_receiver_note` VALUES (175, 1, 123);
INSERT INTO `aoa_receiver_note` VALUES (175, 3, 124);
INSERT INTO `aoa_receiver_note` VALUES (176, 1, 125);
INSERT INTO `aoa_receiver_note` VALUES (177, 1, 126);
INSERT INTO `aoa_receiver_note` VALUES (177, 4, 127);
INSERT INTO `aoa_receiver_note` VALUES (177, 5, 128);
INSERT INTO `aoa_receiver_note` VALUES (178, 1, 129);
INSERT INTO `aoa_receiver_note` VALUES (179, 1, 130);
INSERT INTO `aoa_receiver_note` VALUES (180, 1, 131);
INSERT INTO `aoa_receiver_note` VALUES (181, 1, 132);
INSERT INTO `aoa_receiver_note` VALUES (182, 1, 133);
INSERT INTO `aoa_receiver_note` VALUES (183, 1, 134);
INSERT INTO `aoa_receiver_note` VALUES (184, 1, 135);
INSERT INTO `aoa_receiver_note` VALUES (187, 1, 142);
INSERT INTO `aoa_receiver_note` VALUES (189, 1, 144);
INSERT INTO `aoa_receiver_note` VALUES (190, 1, 145);
INSERT INTO `aoa_receiver_note` VALUES (191, 7, 146);
INSERT INTO `aoa_receiver_note` VALUES (192, 1, 147);
INSERT INTO `aoa_receiver_note` VALUES (194, 1, 151);
INSERT INTO `aoa_receiver_note` VALUES (195, 23, 152);
INSERT INTO `aoa_receiver_note` VALUES (188, 1, 155);
INSERT INTO `aoa_receiver_note` VALUES (201, 10, 162);
INSERT INTO `aoa_receiver_note` VALUES (205, 1, 174);
INSERT INTO `aoa_receiver_note` VALUES (196, 1, 175);
INSERT INTO `aoa_receiver_note` VALUES (203, 4, 193);
INSERT INTO `aoa_receiver_note` VALUES (203, 7, 194);
INSERT INTO `aoa_receiver_note` VALUES (203, 1, 195);
INSERT INTO `aoa_receiver_note` VALUES (199, 10, 199);
INSERT INTO `aoa_receiver_note` VALUES (199, 1, 200);
INSERT INTO `aoa_receiver_note` VALUES (199, 8, 201);
INSERT INTO `aoa_receiver_note` VALUES (198, 1, 202);
INSERT INTO `aoa_receiver_note` VALUES (193, 12, 218);
INSERT INTO `aoa_receiver_note` VALUES (193, 13, 219);
INSERT INTO `aoa_receiver_note` VALUES (193, 1, 220);
INSERT INTO `aoa_receiver_note` VALUES (202, 1, 221);
INSERT INTO `aoa_receiver_note` VALUES (202, 7, 222);
INSERT INTO `aoa_receiver_note` VALUES (202, 8, 223);
INSERT INTO `aoa_receiver_note` VALUES (211, 5, 225);
INSERT INTO `aoa_receiver_note` VALUES (218, 5, 233);
INSERT INTO `aoa_receiver_note` VALUES (218, 4, 234);
INSERT INTO `aoa_receiver_note` VALUES (218, 5, 236);
INSERT INTO `aoa_receiver_note` VALUES (218, 4, 237);
INSERT INTO `aoa_receiver_note` VALUES (218, 5, 239);
INSERT INTO `aoa_receiver_note` VALUES (218, 4, 240);
INSERT INTO `aoa_receiver_note` VALUES (219, 3, 241);
INSERT INTO `aoa_receiver_note` VALUES (224, 3, 246);
INSERT INTO `aoa_receiver_note` VALUES (219, 3, 247);
INSERT INTO `aoa_receiver_note` VALUES (225, 3, 248);
INSERT INTO `aoa_receiver_note` VALUES (226, 3, 249);
INSERT INTO `aoa_receiver_note` VALUES (227, 3, 250);
INSERT INTO `aoa_receiver_note` VALUES (228, 3, 251);
INSERT INTO `aoa_receiver_note` VALUES (229, 3, 252);
INSERT INTO `aoa_receiver_note` VALUES (229, 5, 253);
INSERT INTO `aoa_receiver_note` VALUES (229, 1, 254);
INSERT INTO `aoa_receiver_note` VALUES (229, 4, 255);
INSERT INTO `aoa_receiver_note` VALUES (229, 2, 256);
INSERT INTO `aoa_receiver_note` VALUES (174, 3, 257);
INSERT INTO `aoa_receiver_note` VALUES (174, 1, 258);
INSERT INTO `aoa_receiver_note` VALUES (174, 2, 259);
COMMIT;

-- ----------------------------
-- Table structure for aoa_regular
-- ----------------------------
DROP TABLE IF EXISTS `aoa_regular`;
CREATE TABLE `aoa_regular` (
  `regular_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '转正表ID',
  `advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '对公司产品的意见及建议',
  `deficiency` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '目前存在的不足',
  `dobetter` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '如何在本岗位作的更好',
  `experience` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '试用期、实习期的新的体会',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事建议',
  `pullulate` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '试用期及实习期在哪些方面有了成长',
  `understand` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '对本岗位的要求理解',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '经理意见',
  `days` int(11) DEFAULT NULL COMMENT '实习天数',
  PRIMARY KEY (`regular_id`),
  KEY `FK96uphskhww1otsi3fe916dfor` (`pro_id`),
  CONSTRAINT `FK96uphskhww1otsi3fe916dfor` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_regular
-- ----------------------------
BEGIN;
INSERT INTO `aoa_regular` VALUES (3, '没有', '学习能力', '驾培努力', '实习生', NULL, '实习三个月', '更深刻', 132, '通过', NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_reply_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_reply_list`;
CREATE TABLE `aoa_reply_list` (
  `reply_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回复表ID',
  `content` text COMMENT '回复内容',
  `replay_time` datetime DEFAULT NULL COMMENT '回复时间',
  `discuss_id` bigint(20) DEFAULT NULL COMMENT '讨论人ID',
  `reply_user_id` bigint(20) DEFAULT NULL COMMENT '回复人ID',
  PRIMARY KEY (`reply_id`),
  KEY `FK94s0c9f8hxomde6bede3d20y2` (`discuss_id`),
  KEY `FK2bn8fpyqw7mom14ks4kvrhtp9` (`reply_user_id`),
  CONSTRAINT `FK2bn8fpyqw7mom14ks4kvrhtp9` FOREIGN KEY (`reply_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FK94s0c9f8hxomde6bede3d20y2` FOREIGN KEY (`discuss_id`) REFERENCES `aoa_discuss_list` (`discuss_id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_reply_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_reply_list` VALUES (2, '富士达发的所所所所所\n范德萨发啊', '2017-10-01 22:05:46', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (3, '内容应该要清空了', '2017-10-01 22:06:05', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (4, '阿西吧，这么好', '2017-10-01 22:06:17', 13, 2);
INSERT INTO `aoa_reply_list` VALUES (5, 'what？\n', '2017-10-02 13:51:26', 13, 2);
INSERT INTO `aoa_reply_list` VALUES (6, '发生的多多多', '2017-10-02 13:52:28', 13, 2);
INSERT INTO `aoa_reply_list` VALUES (7, '发生的范德萨', '2017-10-02 13:54:23', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (8, '范德萨', '2017-10-02 13:55:04', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (9, 'yayaya,不错', '2017-10-02 16:52:35', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (14, 'fdsa fsdf afsdfasdf', '2017-10-03 00:35:42', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (15, 'fdsa fdsf', '2017-10-03 00:36:57', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (16, 'fsdfas fsd', '2017-10-03 00:37:03', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (17, '加一条讨论的记录', '2017-10-03 01:02:48', 14, 1);
INSERT INTO `aoa_reply_list` VALUES (18, '范德萨是', '2017-10-03 01:03:54', 14, 1);
INSERT INTO `aoa_reply_list` VALUES (33, 'fdsa', '2017-10-03 01:38:58', 15, 1);
INSERT INTO `aoa_reply_list` VALUES (36, 'fdsa', '2017-10-03 01:42:04', 15, 1);
INSERT INTO `aoa_reply_list` VALUES (37, 'fsdafds', '2017-10-03 01:42:19', 15, 1);
INSERT INTO `aoa_reply_list` VALUES (38, 'fsfsd', '2017-10-03 01:43:23', 15, 1);
INSERT INTO `aoa_reply_list` VALUES (39, 'fsdfasdfs', '2017-10-03 01:43:49', 15, 1);
INSERT INTO `aoa_reply_list` VALUES (47, 'ljljllj;', '2017-10-03 01:55:34', 1, 1);
INSERT INTO `aoa_reply_list` VALUES (49, 'ds', '2017-10-03 02:01:20', 23, 1);
INSERT INTO `aoa_reply_list` VALUES (50, '回复', '2017-10-03 11:21:38', 14, 1);
INSERT INTO `aoa_reply_list` VALUES (51, ' 回复你之后会怎么样？ 第13楼么？', '2017-10-03 11:26:50', 13, 1);
INSERT INTO `aoa_reply_list` VALUES (58, 'fsdfsdfjl', '2017-10-03 15:18:37', 7, 1);
INSERT INTO `aoa_reply_list` VALUES (59, 'fdsfasd ', '2017-10-03 15:19:06', 7, 1);
INSERT INTO `aoa_reply_list` VALUES (60, '发的发', '2017-10-03 23:25:25', 33, 2);
INSERT INTO `aoa_reply_list` VALUES (61, '发范德萨', '2017-10-04 01:33:05', 32, 2);
INSERT INTO `aoa_reply_list` VALUES (62, ' 回复可以么？', '2017-10-04 01:39:49', 32, 2);
INSERT INTO `aoa_reply_list` VALUES (63, '@朱丽叶 回复可以么？ 可以么？', '2017-10-04 01:40:58', 32, 2);
INSERT INTO `aoa_reply_list` VALUES (64, '回复试试', '2017-10-04 01:50:57', 32, 2);
INSERT INTO `aoa_reply_list` VALUES (65, '没意义问题的', '2017-10-04 01:52:20', 32, 2);
INSERT INTO `aoa_reply_list` VALUES (66, ' 接下来就不会报错了', '2017-10-04 01:52:46', 32, 2);
INSERT INTO `aoa_reply_list` VALUES (67, ' 加第七条', '2017-10-04 01:56:01', 32, 2);
INSERT INTO `aoa_reply_list` VALUES (68, '富士达', '2017-10-04 03:24:56', 33, 2);
INSERT INTO `aoa_reply_list` VALUES (69, '好吧，合情合理', '2017-10-04 03:25:15', 33, 2);
INSERT INTO `aoa_reply_list` VALUES (70, '范德萨', '2017-10-04 03:25:48', 33, 2);
INSERT INTO `aoa_reply_list` VALUES (71, '没有问题吧？', '2017-10-04 03:26:08', 33, 2);
INSERT INTO `aoa_reply_list` VALUES (72, '再加一个呢？', '2017-10-04 03:27:00', 33, 2);
INSERT INTO `aoa_reply_list` VALUES (73, '地方撒', '2017-10-05 23:00:14', 8, 2);
INSERT INTO `aoa_reply_list` VALUES (74, '让人头疼', '2017-10-05 23:05:59', 7, 2);
INSERT INTO `aoa_reply_list` VALUES (75, '大师傅', '2017-10-05 23:06:18', 7, 2);
INSERT INTO `aoa_reply_list` VALUES (76, '都是', '2017-10-05 23:06:26', 7, 2);
INSERT INTO `aoa_reply_list` VALUES (77, '大师傅发的', '2017-10-05 23:06:42', 7, 2);
INSERT INTO `aoa_reply_list` VALUES (78, '12312', '2017-10-06 10:22:11', 38, 1);
INSERT INTO `aoa_reply_list` VALUES (79, '范德萨发生', '2017-10-06 10:53:53', 42, 1);
INSERT INTO `aoa_reply_list` VALUES (80, 'fdsfadsaf', '2017-10-06 10:55:54', 42, 1);
INSERT INTO `aoa_reply_list` VALUES (81, 'fdfa fdsa ', '2017-10-06 10:58:10', 42, 1);
INSERT INTO `aoa_reply_list` VALUES (82, 'fdsaffdsaf', '2017-10-06 10:59:12', 42, 1);
INSERT INTO `aoa_reply_list` VALUES (83, 'fdsfafd', '2017-10-06 10:59:28', 42, 1);
INSERT INTO `aoa_reply_list` VALUES (84, '回复test', '2017-10-06 13:47:03', 37, 2);
INSERT INTO `aoa_reply_list` VALUES (85, ' 哟哟；interesting', '2017-10-06 13:47:18', 37, 2);
INSERT INTO `aoa_reply_list` VALUES (86, ' 好吧，有趣', '2017-10-06 13:47:29', 37, 2);
INSERT INTO `aoa_reply_list` VALUES (87, '你很有意思', '2017-10-06 14:22:59', 9, 2);
INSERT INTO `aoa_reply_list` VALUES (88, '你也不错', '2017-10-06 14:23:18', 6, 2);
INSERT INTO `aoa_reply_list` VALUES (89, 'www', '2019-12-15 16:25:06', 8, 3);
INSERT INTO `aoa_reply_list` VALUES (90, '333', '2019-12-15 16:25:28', 8, 3);
INSERT INTO `aoa_reply_list` VALUES (91, '第一次回复', '2019-12-17 23:08:57', 1, 3);
INSERT INTO `aoa_reply_list` VALUES (92, '毅力傻白回复啦01', '2019-12-19 10:00:17', 13, 3);
COMMIT;

-- ----------------------------
-- Table structure for aoa_resign
-- ----------------------------
DROP TABLE IF EXISTS `aoa_resign`;
CREATE TABLE `aoa_resign` (
  `resign_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '离职表ID',
  `financial_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '财务意见',
  `is_finish` bit(1) DEFAULT NULL COMMENT '是否有未报销没完成',
  `nofinish` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '未完成事宜',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事意见及说明',
  `suggest` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '申请人的意见或建议',
  `hand_user` bigint(20) DEFAULT NULL COMMENT '相关人ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '经理意见',
  PRIMARY KEY (`resign_id`),
  KEY `FK3t0d1mt9o7g5q59ha10e3mwpr` (`hand_user`),
  KEY `FKam7ii5j1kdforxq8s6q3mm13n` (`pro_id`),
  CONSTRAINT `FK3t0d1mt9o7g5q59ha10e3mwpr` FOREIGN KEY (`hand_user`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKam7ii5j1kdforxq8s6q3mm13n` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_resign
-- ----------------------------
BEGIN;
INSERT INTO `aoa_resign` VALUES (11, NULL, b'1', '没有啊', NULL, NULL, 2, 115, NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_reviewed
-- ----------------------------
DROP TABLE IF EXISTS `aoa_reviewed`;
CREATE TABLE `aoa_reviewed` (
  `reviewed_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '审核表ID',
  `advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '审核人意见',
  `reviewed_time` datetime DEFAULT NULL COMMENT '审核时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '审核状态ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '审核人ID',
  `del` int(11) DEFAULT NULL COMMENT '是否删除默认0，false',
  PRIMARY KEY (`reviewed_id`),
  KEY `FKevjvy6myxg1l0ibiuph3i7jw2` (`pro_id`),
  KEY `FK2iljei0wvy0cylwwyfh5dr9yk` (`user_id`),
  CONSTRAINT `FK2iljei0wvy0cylwwyfh5dr9yk` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKevjvy6myxg1l0ibiuph3i7jw2` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_reviewed
-- ----------------------------
BEGIN;
INSERT INTO `aoa_reviewed` VALUES (124, '批准了', '2019-11-11 11:36:04', 25, 111, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (125, 'bu xing', '2019-11-11 12:01:42', 25, 112, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (126, '可以可以', '2019-11-11 11:53:05', 25, 113, 3, 1);
INSERT INTO `aoa_reviewed` VALUES (127, NULL, '2019-11-10 18:15:36', 23, 114, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (128, NULL, '2019-11-10 18:16:18', 23, 115, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (130, NULL, '2019-11-10 18:22:42', 23, 117, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (132, NULL, NULL, 23, 112, 7, NULL);
INSERT INTO `aoa_reviewed` VALUES (133, NULL, NULL, 23, 113, 8, NULL);
INSERT INTO `aoa_reviewed` VALUES (134, NULL, '2019-11-11 21:47:07', 23, 118, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (135, NULL, '2019-11-12 11:31:28', 23, 119, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (136, NULL, '2019-11-12 11:36:44', 23, 120, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (137, NULL, '2019-11-12 11:36:44', 23, 121, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (138, NULL, '2019-11-12 11:47:08', 23, 122, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (139, NULL, '2019-11-12 11:50:24', 23, 123, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (140, NULL, '2019-11-12 12:32:07', 23, 124, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (141, NULL, '2019-11-12 12:39:02', 23, 125, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (142, NULL, '2019-11-12 13:02:58', 23, 126, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (143, NULL, '2019-11-12 13:09:42', 23, 127, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (144, NULL, '2019-11-12 13:12:03', 23, 128, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (145, NULL, '2019-11-12 14:11:31', 23, 129, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (146, NULL, '2019-11-12 14:14:37', 23, 130, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (147, NULL, '2019-11-12 14:20:22', 23, 131, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (148, '通过', '2019-11-12 16:47:37', 25, 132, 5, 0);
INSERT INTO `aoa_reviewed` VALUES (149, NULL, '2019-11-12 22:28:03', 23, 133, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (150, NULL, '2019-11-12 22:34:06', 23, 134, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (151, NULL, '2019-11-12 22:36:35', 23, 135, 3, 0);
INSERT INTO `aoa_reviewed` VALUES (152, NULL, '2019-11-12 22:44:45', 23, 136, 3, 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_role_
-- ----------------------------
DROP TABLE IF EXISTS `aoa_role_`;
CREATE TABLE `aoa_role_` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '角色名',
  `role_value` int(11) DEFAULT NULL COMMENT '角色权限值',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_role_
-- ----------------------------
BEGIN;
INSERT INTO `aoa_role_` VALUES (1, '超级管理员', 0);
INSERT INTO `aoa_role_` VALUES (2, 'CEO', 0);
INSERT INTO `aoa_role_` VALUES (3, '总经理', 0);
INSERT INTO `aoa_role_` VALUES (4, '部门经理', 0);
INSERT INTO `aoa_role_` VALUES (5, '职员', 0);
INSERT INTO `aoa_role_` VALUES (6, '实习生', 0);
INSERT INTO `aoa_role_` VALUES (7, '试用生', 0);
INSERT INTO `aoa_role_` VALUES (8, '实习生01', 0);
INSERT INTO `aoa_role_` VALUES (9, '实习生02', 0);
INSERT INTO `aoa_role_` VALUES (10, '实习生03', 0);
INSERT INTO `aoa_role_` VALUES (11, '实习生04', 0);
INSERT INTO `aoa_role_` VALUES (12, '实习生05', 0);
INSERT INTO `aoa_role_` VALUES (13, '实习生06', 0);
INSERT INTO `aoa_role_` VALUES (14, '实习生07', 0);
INSERT INTO `aoa_role_` VALUES (15, '实习生08', 0);
INSERT INTO `aoa_role_` VALUES (16, '实习生09', 0);
INSERT INTO `aoa_role_` VALUES (17, '实习生10', 0);
INSERT INTO `aoa_role_` VALUES (18, '实习生11', 0);
INSERT INTO `aoa_role_` VALUES (19, '实习生12', 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_role_power_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_role_power_list`;
CREATE TABLE `aoa_role_power_list` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `is_show` int(11) DEFAULT NULL COMMENT '是否显示 0-不显示1-显示',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`pk_id`),
  KEY `FK2f9f91f213gwtglofko5r429s` (`menu_id`),
  KEY `FK7b71lfkstl47tston4lrd8066` (`role_id`),
  CONSTRAINT `FK2f9f91f213gwtglofko5r429s` FOREIGN KEY (`menu_id`) REFERENCES `aoa_sys_menu` (`menu_id`),
  CONSTRAINT `FK7b71lfkstl47tston4lrd8066` FOREIGN KEY (`role_id`) REFERENCES `aoa_role_` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1405 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_role_power_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_role_power_list` VALUES (56, 1, 1, 1);
INSERT INTO `aoa_role_power_list` VALUES (57, 1, 2, 1);
INSERT INTO `aoa_role_power_list` VALUES (58, 1, 3, 1);
INSERT INTO `aoa_role_power_list` VALUES (59, 1, 4, 1);
INSERT INTO `aoa_role_power_list` VALUES (60, 1, 5, 1);
INSERT INTO `aoa_role_power_list` VALUES (61, 1, 6, 1);
INSERT INTO `aoa_role_power_list` VALUES (62, 1, 7, 1);
INSERT INTO `aoa_role_power_list` VALUES (63, 1, 8, 1);
INSERT INTO `aoa_role_power_list` VALUES (64, 1, 9, 1);
INSERT INTO `aoa_role_power_list` VALUES (65, 1, 10, 1);
INSERT INTO `aoa_role_power_list` VALUES (66, 1, 11, 1);
INSERT INTO `aoa_role_power_list` VALUES (67, 1, 12, 1);
INSERT INTO `aoa_role_power_list` VALUES (68, 1, 13, 1);
INSERT INTO `aoa_role_power_list` VALUES (69, 1, 14, 1);
INSERT INTO `aoa_role_power_list` VALUES (70, 1, 15, 1);
INSERT INTO `aoa_role_power_list` VALUES (71, 1, 16, 1);
INSERT INTO `aoa_role_power_list` VALUES (72, 1, 17, 1);
INSERT INTO `aoa_role_power_list` VALUES (73, 1, 18, 1);
INSERT INTO `aoa_role_power_list` VALUES (74, 1, 19, 1);
INSERT INTO `aoa_role_power_list` VALUES (75, 1, 20, 1);
INSERT INTO `aoa_role_power_list` VALUES (76, 1, 21, 1);
INSERT INTO `aoa_role_power_list` VALUES (77, 1, 22, 1);
INSERT INTO `aoa_role_power_list` VALUES (78, 1, 23, 1);
INSERT INTO `aoa_role_power_list` VALUES (79, 1, 24, 1);
INSERT INTO `aoa_role_power_list` VALUES (80, 1, 25, 1);
INSERT INTO `aoa_role_power_list` VALUES (81, 1, 26, 1);
INSERT INTO `aoa_role_power_list` VALUES (82, 1, 27, 1);
INSERT INTO `aoa_role_power_list` VALUES (83, 1, 28, 1);
INSERT INTO `aoa_role_power_list` VALUES (84, 1, 29, 1);
INSERT INTO `aoa_role_power_list` VALUES (85, 1, 30, 1);
INSERT INTO `aoa_role_power_list` VALUES (86, 1, 31, 1);
INSERT INTO `aoa_role_power_list` VALUES (87, 1, 32, 1);
INSERT INTO `aoa_role_power_list` VALUES (88, 1, 33, 1);
INSERT INTO `aoa_role_power_list` VALUES (89, 1, 34, 1);
INSERT INTO `aoa_role_power_list` VALUES (90, 1, 35, 1);
INSERT INTO `aoa_role_power_list` VALUES (91, 1, 36, 1);
INSERT INTO `aoa_role_power_list` VALUES (92, 1, 37, 1);
INSERT INTO `aoa_role_power_list` VALUES (93, 1, 38, 1);
INSERT INTO `aoa_role_power_list` VALUES (94, 1, 39, 1);
INSERT INTO `aoa_role_power_list` VALUES (95, 1, 40, 1);
INSERT INTO `aoa_role_power_list` VALUES (96, 1, 41, 1);
INSERT INTO `aoa_role_power_list` VALUES (97, 1, 42, 1);
INSERT INTO `aoa_role_power_list` VALUES (98, 1, 67, 1);
INSERT INTO `aoa_role_power_list` VALUES (99, 0, 76, 1);
INSERT INTO `aoa_role_power_list` VALUES (100, 0, 77, 1);
INSERT INTO `aoa_role_power_list` VALUES (101, 0, 78, 1);
INSERT INTO `aoa_role_power_list` VALUES (102, 0, 79, 1);
INSERT INTO `aoa_role_power_list` VALUES (103, 0, 80, 1);
INSERT INTO `aoa_role_power_list` VALUES (104, 0, 81, 1);
INSERT INTO `aoa_role_power_list` VALUES (105, 0, 82, 1);
INSERT INTO `aoa_role_power_list` VALUES (106, 0, 86, 1);
INSERT INTO `aoa_role_power_list` VALUES (107, 0, 87, 1);
INSERT INTO `aoa_role_power_list` VALUES (108, 0, 88, 1);
INSERT INTO `aoa_role_power_list` VALUES (109, 1, 89, 1);
INSERT INTO `aoa_role_power_list` VALUES (110, 1, 90, 1);
INSERT INTO `aoa_role_power_list` VALUES (111, 0, 1, 2);
INSERT INTO `aoa_role_power_list` VALUES (112, 1, 2, 2);
INSERT INTO `aoa_role_power_list` VALUES (113, 1, 3, 2);
INSERT INTO `aoa_role_power_list` VALUES (114, 1, 4, 2);
INSERT INTO `aoa_role_power_list` VALUES (115, 1, 5, 2);
INSERT INTO `aoa_role_power_list` VALUES (116, 1, 6, 2);
INSERT INTO `aoa_role_power_list` VALUES (117, 1, 7, 2);
INSERT INTO `aoa_role_power_list` VALUES (118, 1, 8, 2);
INSERT INTO `aoa_role_power_list` VALUES (119, 1, 9, 2);
INSERT INTO `aoa_role_power_list` VALUES (120, 1, 10, 2);
INSERT INTO `aoa_role_power_list` VALUES (121, 1, 11, 2);
INSERT INTO `aoa_role_power_list` VALUES (122, 1, 12, 2);
INSERT INTO `aoa_role_power_list` VALUES (123, 1, 13, 2);
INSERT INTO `aoa_role_power_list` VALUES (124, 0, 14, 2);
INSERT INTO `aoa_role_power_list` VALUES (125, 0, 15, 2);
INSERT INTO `aoa_role_power_list` VALUES (126, 0, 16, 2);
INSERT INTO `aoa_role_power_list` VALUES (127, 1, 17, 2);
INSERT INTO `aoa_role_power_list` VALUES (128, 1, 18, 2);
INSERT INTO `aoa_role_power_list` VALUES (129, 1, 19, 2);
INSERT INTO `aoa_role_power_list` VALUES (130, 0, 20, 2);
INSERT INTO `aoa_role_power_list` VALUES (131, 1, 21, 2);
INSERT INTO `aoa_role_power_list` VALUES (132, 1, 22, 2);
INSERT INTO `aoa_role_power_list` VALUES (133, 1, 23, 2);
INSERT INTO `aoa_role_power_list` VALUES (134, 1, 24, 2);
INSERT INTO `aoa_role_power_list` VALUES (135, 0, 25, 2);
INSERT INTO `aoa_role_power_list` VALUES (136, 1, 26, 2);
INSERT INTO `aoa_role_power_list` VALUES (137, 1, 27, 2);
INSERT INTO `aoa_role_power_list` VALUES (138, 1, 28, 2);
INSERT INTO `aoa_role_power_list` VALUES (139, 1, 29, 2);
INSERT INTO `aoa_role_power_list` VALUES (140, 1, 30, 2);
INSERT INTO `aoa_role_power_list` VALUES (141, 1, 31, 2);
INSERT INTO `aoa_role_power_list` VALUES (142, 1, 32, 2);
INSERT INTO `aoa_role_power_list` VALUES (143, 1, 33, 2);
INSERT INTO `aoa_role_power_list` VALUES (144, 1, 34, 2);
INSERT INTO `aoa_role_power_list` VALUES (145, 1, 35, 2);
INSERT INTO `aoa_role_power_list` VALUES (146, 1, 36, 2);
INSERT INTO `aoa_role_power_list` VALUES (147, 1, 37, 2);
INSERT INTO `aoa_role_power_list` VALUES (148, 1, 38, 2);
INSERT INTO `aoa_role_power_list` VALUES (149, 1, 39, 2);
INSERT INTO `aoa_role_power_list` VALUES (150, 1, 40, 2);
INSERT INTO `aoa_role_power_list` VALUES (151, 1, 41, 2);
INSERT INTO `aoa_role_power_list` VALUES (152, 1, 42, 2);
INSERT INTO `aoa_role_power_list` VALUES (153, 1, 67, 2);
INSERT INTO `aoa_role_power_list` VALUES (154, 0, 76, 2);
INSERT INTO `aoa_role_power_list` VALUES (155, 0, 77, 2);
INSERT INTO `aoa_role_power_list` VALUES (156, 0, 78, 2);
INSERT INTO `aoa_role_power_list` VALUES (157, 0, 79, 2);
INSERT INTO `aoa_role_power_list` VALUES (158, 0, 80, 2);
INSERT INTO `aoa_role_power_list` VALUES (159, 0, 81, 2);
INSERT INTO `aoa_role_power_list` VALUES (160, 0, 82, 2);
INSERT INTO `aoa_role_power_list` VALUES (161, 0, 86, 2);
INSERT INTO `aoa_role_power_list` VALUES (162, 0, 87, 2);
INSERT INTO `aoa_role_power_list` VALUES (163, 0, 88, 2);
INSERT INTO `aoa_role_power_list` VALUES (164, 1, 89, 2);
INSERT INTO `aoa_role_power_list` VALUES (165, 0, 90, 2);
INSERT INTO `aoa_role_power_list` VALUES (166, 1, 1, 3);
INSERT INTO `aoa_role_power_list` VALUES (167, 1, 2, 3);
INSERT INTO `aoa_role_power_list` VALUES (168, 1, 3, 3);
INSERT INTO `aoa_role_power_list` VALUES (169, 1, 4, 3);
INSERT INTO `aoa_role_power_list` VALUES (170, 1, 5, 3);
INSERT INTO `aoa_role_power_list` VALUES (171, 1, 6, 3);
INSERT INTO `aoa_role_power_list` VALUES (172, 1, 7, 3);
INSERT INTO `aoa_role_power_list` VALUES (173, 1, 8, 3);
INSERT INTO `aoa_role_power_list` VALUES (174, 1, 9, 3);
INSERT INTO `aoa_role_power_list` VALUES (175, 1, 10, 3);
INSERT INTO `aoa_role_power_list` VALUES (176, 1, 11, 3);
INSERT INTO `aoa_role_power_list` VALUES (177, 1, 12, 3);
INSERT INTO `aoa_role_power_list` VALUES (178, 1, 13, 3);
INSERT INTO `aoa_role_power_list` VALUES (179, 1, 14, 3);
INSERT INTO `aoa_role_power_list` VALUES (180, 1, 15, 3);
INSERT INTO `aoa_role_power_list` VALUES (181, 1, 16, 3);
INSERT INTO `aoa_role_power_list` VALUES (182, 1, 17, 3);
INSERT INTO `aoa_role_power_list` VALUES (183, 1, 18, 3);
INSERT INTO `aoa_role_power_list` VALUES (184, 1, 19, 3);
INSERT INTO `aoa_role_power_list` VALUES (185, 1, 20, 3);
INSERT INTO `aoa_role_power_list` VALUES (186, 1, 21, 3);
INSERT INTO `aoa_role_power_list` VALUES (187, 1, 22, 3);
INSERT INTO `aoa_role_power_list` VALUES (188, 1, 23, 3);
INSERT INTO `aoa_role_power_list` VALUES (189, 1, 24, 3);
INSERT INTO `aoa_role_power_list` VALUES (190, 1, 25, 3);
INSERT INTO `aoa_role_power_list` VALUES (191, 1, 26, 3);
INSERT INTO `aoa_role_power_list` VALUES (192, 1, 27, 3);
INSERT INTO `aoa_role_power_list` VALUES (193, 1, 28, 3);
INSERT INTO `aoa_role_power_list` VALUES (194, 1, 29, 3);
INSERT INTO `aoa_role_power_list` VALUES (195, 1, 30, 3);
INSERT INTO `aoa_role_power_list` VALUES (196, 1, 31, 3);
INSERT INTO `aoa_role_power_list` VALUES (197, 1, 32, 3);
INSERT INTO `aoa_role_power_list` VALUES (198, 1, 33, 3);
INSERT INTO `aoa_role_power_list` VALUES (199, 1, 34, 3);
INSERT INTO `aoa_role_power_list` VALUES (200, 1, 35, 3);
INSERT INTO `aoa_role_power_list` VALUES (201, 1, 36, 3);
INSERT INTO `aoa_role_power_list` VALUES (202, 1, 37, 3);
INSERT INTO `aoa_role_power_list` VALUES (203, 1, 38, 3);
INSERT INTO `aoa_role_power_list` VALUES (204, 1, 39, 3);
INSERT INTO `aoa_role_power_list` VALUES (205, 1, 40, 3);
INSERT INTO `aoa_role_power_list` VALUES (206, 1, 41, 3);
INSERT INTO `aoa_role_power_list` VALUES (207, 1, 42, 3);
INSERT INTO `aoa_role_power_list` VALUES (208, 1, 67, 3);
INSERT INTO `aoa_role_power_list` VALUES (209, 0, 76, 3);
INSERT INTO `aoa_role_power_list` VALUES (210, 0, 77, 3);
INSERT INTO `aoa_role_power_list` VALUES (211, 0, 78, 3);
INSERT INTO `aoa_role_power_list` VALUES (212, 0, 79, 3);
INSERT INTO `aoa_role_power_list` VALUES (213, 0, 80, 3);
INSERT INTO `aoa_role_power_list` VALUES (214, 0, 81, 3);
INSERT INTO `aoa_role_power_list` VALUES (215, 0, 82, 3);
INSERT INTO `aoa_role_power_list` VALUES (216, 0, 86, 3);
INSERT INTO `aoa_role_power_list` VALUES (217, 0, 87, 3);
INSERT INTO `aoa_role_power_list` VALUES (218, 0, 88, 3);
INSERT INTO `aoa_role_power_list` VALUES (219, 1, 89, 3);
INSERT INTO `aoa_role_power_list` VALUES (220, 1, 90, 3);
INSERT INTO `aoa_role_power_list` VALUES (221, 0, 1, 4);
INSERT INTO `aoa_role_power_list` VALUES (222, 1, 2, 4);
INSERT INTO `aoa_role_power_list` VALUES (223, 0, 3, 4);
INSERT INTO `aoa_role_power_list` VALUES (224, 1, 4, 4);
INSERT INTO `aoa_role_power_list` VALUES (225, 1, 5, 4);
INSERT INTO `aoa_role_power_list` VALUES (226, 1, 6, 4);
INSERT INTO `aoa_role_power_list` VALUES (227, 1, 7, 4);
INSERT INTO `aoa_role_power_list` VALUES (228, 1, 8, 4);
INSERT INTO `aoa_role_power_list` VALUES (229, 1, 9, 4);
INSERT INTO `aoa_role_power_list` VALUES (230, 1, 10, 4);
INSERT INTO `aoa_role_power_list` VALUES (231, 1, 11, 4);
INSERT INTO `aoa_role_power_list` VALUES (232, 1, 12, 4);
INSERT INTO `aoa_role_power_list` VALUES (233, 1, 13, 4);
INSERT INTO `aoa_role_power_list` VALUES (234, 0, 14, 4);
INSERT INTO `aoa_role_power_list` VALUES (235, 0, 15, 4);
INSERT INTO `aoa_role_power_list` VALUES (236, 0, 16, 4);
INSERT INTO `aoa_role_power_list` VALUES (237, 1, 17, 4);
INSERT INTO `aoa_role_power_list` VALUES (238, 1, 18, 4);
INSERT INTO `aoa_role_power_list` VALUES (239, 1, 19, 4);
INSERT INTO `aoa_role_power_list` VALUES (240, 1, 20, 4);
INSERT INTO `aoa_role_power_list` VALUES (241, 0, 21, 4);
INSERT INTO `aoa_role_power_list` VALUES (242, 1, 22, 4);
INSERT INTO `aoa_role_power_list` VALUES (243, 1, 23, 4);
INSERT INTO `aoa_role_power_list` VALUES (244, 1, 24, 4);
INSERT INTO `aoa_role_power_list` VALUES (245, 1, 25, 4);
INSERT INTO `aoa_role_power_list` VALUES (246, 1, 26, 4);
INSERT INTO `aoa_role_power_list` VALUES (247, 1, 27, 4);
INSERT INTO `aoa_role_power_list` VALUES (248, 1, 28, 4);
INSERT INTO `aoa_role_power_list` VALUES (249, 1, 29, 4);
INSERT INTO `aoa_role_power_list` VALUES (250, 1, 30, 4);
INSERT INTO `aoa_role_power_list` VALUES (251, 1, 31, 4);
INSERT INTO `aoa_role_power_list` VALUES (252, 1, 32, 4);
INSERT INTO `aoa_role_power_list` VALUES (253, 1, 33, 4);
INSERT INTO `aoa_role_power_list` VALUES (254, 1, 34, 4);
INSERT INTO `aoa_role_power_list` VALUES (255, 1, 35, 4);
INSERT INTO `aoa_role_power_list` VALUES (256, 1, 36, 4);
INSERT INTO `aoa_role_power_list` VALUES (257, 1, 37, 4);
INSERT INTO `aoa_role_power_list` VALUES (258, 1, 38, 4);
INSERT INTO `aoa_role_power_list` VALUES (259, 1, 39, 4);
INSERT INTO `aoa_role_power_list` VALUES (260, 1, 40, 4);
INSERT INTO `aoa_role_power_list` VALUES (261, 1, 41, 4);
INSERT INTO `aoa_role_power_list` VALUES (262, 1, 42, 4);
INSERT INTO `aoa_role_power_list` VALUES (263, 1, 67, 4);
INSERT INTO `aoa_role_power_list` VALUES (264, 0, 76, 4);
INSERT INTO `aoa_role_power_list` VALUES (265, 0, 77, 4);
INSERT INTO `aoa_role_power_list` VALUES (266, 0, 78, 4);
INSERT INTO `aoa_role_power_list` VALUES (267, 0, 79, 4);
INSERT INTO `aoa_role_power_list` VALUES (268, 0, 80, 4);
INSERT INTO `aoa_role_power_list` VALUES (269, 0, 81, 4);
INSERT INTO `aoa_role_power_list` VALUES (270, 0, 82, 4);
INSERT INTO `aoa_role_power_list` VALUES (271, 0, 86, 4);
INSERT INTO `aoa_role_power_list` VALUES (272, 0, 87, 4);
INSERT INTO `aoa_role_power_list` VALUES (273, 0, 88, 4);
INSERT INTO `aoa_role_power_list` VALUES (274, 0, 89, 4);
INSERT INTO `aoa_role_power_list` VALUES (275, 1, 90, 4);
INSERT INTO `aoa_role_power_list` VALUES (276, 0, 1, 5);
INSERT INTO `aoa_role_power_list` VALUES (277, 0, 2, 5);
INSERT INTO `aoa_role_power_list` VALUES (278, 0, 3, 5);
INSERT INTO `aoa_role_power_list` VALUES (279, 0, 4, 5);
INSERT INTO `aoa_role_power_list` VALUES (280, 1, 5, 5);
INSERT INTO `aoa_role_power_list` VALUES (281, 1, 6, 5);
INSERT INTO `aoa_role_power_list` VALUES (282, 1, 7, 5);
INSERT INTO `aoa_role_power_list` VALUES (283, 1, 8, 5);
INSERT INTO `aoa_role_power_list` VALUES (284, 1, 9, 5);
INSERT INTO `aoa_role_power_list` VALUES (285, 1, 10, 5);
INSERT INTO `aoa_role_power_list` VALUES (286, 1, 11, 5);
INSERT INTO `aoa_role_power_list` VALUES (287, 1, 12, 5);
INSERT INTO `aoa_role_power_list` VALUES (288, 1, 13, 5);
INSERT INTO `aoa_role_power_list` VALUES (289, 0, 14, 5);
INSERT INTO `aoa_role_power_list` VALUES (290, 0, 15, 5);
INSERT INTO `aoa_role_power_list` VALUES (291, 0, 16, 5);
INSERT INTO `aoa_role_power_list` VALUES (292, 0, 17, 5);
INSERT INTO `aoa_role_power_list` VALUES (293, 0, 18, 5);
INSERT INTO `aoa_role_power_list` VALUES (294, 0, 19, 5);
INSERT INTO `aoa_role_power_list` VALUES (295, 0, 20, 5);
INSERT INTO `aoa_role_power_list` VALUES (296, 0, 21, 5);
INSERT INTO `aoa_role_power_list` VALUES (297, 0, 22, 5);
INSERT INTO `aoa_role_power_list` VALUES (298, 0, 23, 5);
INSERT INTO `aoa_role_power_list` VALUES (299, 0, 24, 5);
INSERT INTO `aoa_role_power_list` VALUES (300, 1, 25, 5);
INSERT INTO `aoa_role_power_list` VALUES (301, 0, 26, 5);
INSERT INTO `aoa_role_power_list` VALUES (302, 0, 27, 5);
INSERT INTO `aoa_role_power_list` VALUES (303, 1, 28, 5);
INSERT INTO `aoa_role_power_list` VALUES (304, 1, 29, 5);
INSERT INTO `aoa_role_power_list` VALUES (305, 1, 30, 5);
INSERT INTO `aoa_role_power_list` VALUES (306, 0, 31, 5);
INSERT INTO `aoa_role_power_list` VALUES (307, 1, 32, 5);
INSERT INTO `aoa_role_power_list` VALUES (308, 0, 33, 5);
INSERT INTO `aoa_role_power_list` VALUES (309, 1, 34, 5);
INSERT INTO `aoa_role_power_list` VALUES (310, 1, 35, 5);
INSERT INTO `aoa_role_power_list` VALUES (311, 1, 36, 5);
INSERT INTO `aoa_role_power_list` VALUES (312, 1, 37, 5);
INSERT INTO `aoa_role_power_list` VALUES (313, 1, 38, 5);
INSERT INTO `aoa_role_power_list` VALUES (314, 1, 39, 5);
INSERT INTO `aoa_role_power_list` VALUES (315, 1, 40, 5);
INSERT INTO `aoa_role_power_list` VALUES (316, 1, 41, 5);
INSERT INTO `aoa_role_power_list` VALUES (317, 1, 42, 5);
INSERT INTO `aoa_role_power_list` VALUES (318, 0, 67, 5);
INSERT INTO `aoa_role_power_list` VALUES (319, 0, 76, 5);
INSERT INTO `aoa_role_power_list` VALUES (320, 0, 77, 5);
INSERT INTO `aoa_role_power_list` VALUES (321, 0, 78, 5);
INSERT INTO `aoa_role_power_list` VALUES (322, 0, 79, 5);
INSERT INTO `aoa_role_power_list` VALUES (323, 0, 80, 5);
INSERT INTO `aoa_role_power_list` VALUES (324, 0, 81, 5);
INSERT INTO `aoa_role_power_list` VALUES (325, 0, 82, 5);
INSERT INTO `aoa_role_power_list` VALUES (326, 0, 86, 5);
INSERT INTO `aoa_role_power_list` VALUES (327, 0, 87, 5);
INSERT INTO `aoa_role_power_list` VALUES (328, 0, 88, 5);
INSERT INTO `aoa_role_power_list` VALUES (329, 0, 89, 5);
INSERT INTO `aoa_role_power_list` VALUES (330, 1, 90, 5);
INSERT INTO `aoa_role_power_list` VALUES (331, 0, 1, 6);
INSERT INTO `aoa_role_power_list` VALUES (332, 0, 2, 6);
INSERT INTO `aoa_role_power_list` VALUES (333, 0, 3, 6);
INSERT INTO `aoa_role_power_list` VALUES (334, 0, 4, 6);
INSERT INTO `aoa_role_power_list` VALUES (335, 1, 5, 6);
INSERT INTO `aoa_role_power_list` VALUES (336, 0, 6, 6);
INSERT INTO `aoa_role_power_list` VALUES (337, 0, 7, 6);
INSERT INTO `aoa_role_power_list` VALUES (338, 0, 8, 6);
INSERT INTO `aoa_role_power_list` VALUES (339, 0, 9, 6);
INSERT INTO `aoa_role_power_list` VALUES (340, 0, 10, 6);
INSERT INTO `aoa_role_power_list` VALUES (341, 0, 11, 6);
INSERT INTO `aoa_role_power_list` VALUES (342, 0, 12, 6);
INSERT INTO `aoa_role_power_list` VALUES (343, 0, 13, 6);
INSERT INTO `aoa_role_power_list` VALUES (344, 0, 14, 6);
INSERT INTO `aoa_role_power_list` VALUES (345, 0, 15, 6);
INSERT INTO `aoa_role_power_list` VALUES (346, 0, 16, 6);
INSERT INTO `aoa_role_power_list` VALUES (347, 0, 17, 6);
INSERT INTO `aoa_role_power_list` VALUES (348, 0, 18, 6);
INSERT INTO `aoa_role_power_list` VALUES (349, 0, 19, 6);
INSERT INTO `aoa_role_power_list` VALUES (350, 0, 20, 6);
INSERT INTO `aoa_role_power_list` VALUES (351, 0, 21, 6);
INSERT INTO `aoa_role_power_list` VALUES (352, 0, 22, 6);
INSERT INTO `aoa_role_power_list` VALUES (353, 0, 23, 6);
INSERT INTO `aoa_role_power_list` VALUES (354, 0, 24, 6);
INSERT INTO `aoa_role_power_list` VALUES (355, 1, 25, 6);
INSERT INTO `aoa_role_power_list` VALUES (356, 0, 26, 6);
INSERT INTO `aoa_role_power_list` VALUES (357, 0, 27, 6);
INSERT INTO `aoa_role_power_list` VALUES (358, 0, 28, 6);
INSERT INTO `aoa_role_power_list` VALUES (359, 0, 29, 6);
INSERT INTO `aoa_role_power_list` VALUES (360, 0, 30, 6);
INSERT INTO `aoa_role_power_list` VALUES (361, 0, 31, 6);
INSERT INTO `aoa_role_power_list` VALUES (362, 0, 32, 6);
INSERT INTO `aoa_role_power_list` VALUES (363, 0, 33, 6);
INSERT INTO `aoa_role_power_list` VALUES (364, 0, 34, 6);
INSERT INTO `aoa_role_power_list` VALUES (365, 0, 35, 6);
INSERT INTO `aoa_role_power_list` VALUES (366, 0, 36, 6);
INSERT INTO `aoa_role_power_list` VALUES (367, 0, 37, 6);
INSERT INTO `aoa_role_power_list` VALUES (368, 0, 38, 6);
INSERT INTO `aoa_role_power_list` VALUES (369, 0, 39, 6);
INSERT INTO `aoa_role_power_list` VALUES (370, 0, 40, 6);
INSERT INTO `aoa_role_power_list` VALUES (371, 0, 41, 6);
INSERT INTO `aoa_role_power_list` VALUES (372, 0, 42, 6);
INSERT INTO `aoa_role_power_list` VALUES (373, 0, 67, 6);
INSERT INTO `aoa_role_power_list` VALUES (374, 0, 76, 6);
INSERT INTO `aoa_role_power_list` VALUES (375, 0, 77, 6);
INSERT INTO `aoa_role_power_list` VALUES (376, 0, 78, 6);
INSERT INTO `aoa_role_power_list` VALUES (377, 0, 79, 6);
INSERT INTO `aoa_role_power_list` VALUES (378, 0, 80, 6);
INSERT INTO `aoa_role_power_list` VALUES (379, 0, 81, 6);
INSERT INTO `aoa_role_power_list` VALUES (380, 0, 82, 6);
INSERT INTO `aoa_role_power_list` VALUES (381, 0, 86, 6);
INSERT INTO `aoa_role_power_list` VALUES (382, 0, 87, 6);
INSERT INTO `aoa_role_power_list` VALUES (383, 0, 88, 6);
INSERT INTO `aoa_role_power_list` VALUES (384, 0, 89, 6);
INSERT INTO `aoa_role_power_list` VALUES (385, 1, 90, 6);
INSERT INTO `aoa_role_power_list` VALUES (386, 0, 1, 7);
INSERT INTO `aoa_role_power_list` VALUES (387, 0, 2, 7);
INSERT INTO `aoa_role_power_list` VALUES (388, 0, 3, 7);
INSERT INTO `aoa_role_power_list` VALUES (389, 0, 4, 7);
INSERT INTO `aoa_role_power_list` VALUES (390, 1, 5, 7);
INSERT INTO `aoa_role_power_list` VALUES (391, 1, 6, 7);
INSERT INTO `aoa_role_power_list` VALUES (392, 0, 7, 7);
INSERT INTO `aoa_role_power_list` VALUES (393, 0, 8, 7);
INSERT INTO `aoa_role_power_list` VALUES (394, 0, 9, 7);
INSERT INTO `aoa_role_power_list` VALUES (395, 1, 10, 7);
INSERT INTO `aoa_role_power_list` VALUES (396, 0, 11, 7);
INSERT INTO `aoa_role_power_list` VALUES (397, 0, 12, 7);
INSERT INTO `aoa_role_power_list` VALUES (398, 0, 13, 7);
INSERT INTO `aoa_role_power_list` VALUES (399, 0, 14, 7);
INSERT INTO `aoa_role_power_list` VALUES (400, 0, 15, 7);
INSERT INTO `aoa_role_power_list` VALUES (401, 0, 16, 7);
INSERT INTO `aoa_role_power_list` VALUES (402, 0, 17, 7);
INSERT INTO `aoa_role_power_list` VALUES (403, 0, 18, 7);
INSERT INTO `aoa_role_power_list` VALUES (404, 0, 19, 7);
INSERT INTO `aoa_role_power_list` VALUES (405, 0, 20, 7);
INSERT INTO `aoa_role_power_list` VALUES (406, 0, 21, 7);
INSERT INTO `aoa_role_power_list` VALUES (407, 0, 22, 7);
INSERT INTO `aoa_role_power_list` VALUES (408, 0, 23, 7);
INSERT INTO `aoa_role_power_list` VALUES (409, 0, 24, 7);
INSERT INTO `aoa_role_power_list` VALUES (410, 1, 25, 7);
INSERT INTO `aoa_role_power_list` VALUES (411, 0, 26, 7);
INSERT INTO `aoa_role_power_list` VALUES (412, 0, 27, 7);
INSERT INTO `aoa_role_power_list` VALUES (413, 0, 28, 7);
INSERT INTO `aoa_role_power_list` VALUES (414, 0, 29, 7);
INSERT INTO `aoa_role_power_list` VALUES (415, 0, 30, 7);
INSERT INTO `aoa_role_power_list` VALUES (416, 0, 31, 7);
INSERT INTO `aoa_role_power_list` VALUES (417, 0, 32, 7);
INSERT INTO `aoa_role_power_list` VALUES (418, 1, 33, 7);
INSERT INTO `aoa_role_power_list` VALUES (419, 1, 34, 7);
INSERT INTO `aoa_role_power_list` VALUES (420, 1, 35, 7);
INSERT INTO `aoa_role_power_list` VALUES (421, 0, 36, 7);
INSERT INTO `aoa_role_power_list` VALUES (422, 0, 37, 7);
INSERT INTO `aoa_role_power_list` VALUES (423, 0, 38, 7);
INSERT INTO `aoa_role_power_list` VALUES (424, 0, 39, 7);
INSERT INTO `aoa_role_power_list` VALUES (425, 0, 40, 7);
INSERT INTO `aoa_role_power_list` VALUES (426, 0, 41, 7);
INSERT INTO `aoa_role_power_list` VALUES (427, 0, 42, 7);
INSERT INTO `aoa_role_power_list` VALUES (428, 0, 67, 7);
INSERT INTO `aoa_role_power_list` VALUES (429, 0, 76, 7);
INSERT INTO `aoa_role_power_list` VALUES (430, 0, 77, 7);
INSERT INTO `aoa_role_power_list` VALUES (431, 0, 78, 7);
INSERT INTO `aoa_role_power_list` VALUES (432, 0, 79, 7);
INSERT INTO `aoa_role_power_list` VALUES (433, 0, 80, 7);
INSERT INTO `aoa_role_power_list` VALUES (434, 0, 81, 7);
INSERT INTO `aoa_role_power_list` VALUES (435, 0, 82, 7);
INSERT INTO `aoa_role_power_list` VALUES (436, 0, 86, 7);
INSERT INTO `aoa_role_power_list` VALUES (437, 0, 87, 7);
INSERT INTO `aoa_role_power_list` VALUES (438, 0, 88, 7);
INSERT INTO `aoa_role_power_list` VALUES (439, 0, 89, 7);
INSERT INTO `aoa_role_power_list` VALUES (440, 1, 90, 7);
INSERT INTO `aoa_role_power_list` VALUES (441, 0, 1, 8);
INSERT INTO `aoa_role_power_list` VALUES (442, 0, 2, 8);
INSERT INTO `aoa_role_power_list` VALUES (443, 0, 3, 8);
INSERT INTO `aoa_role_power_list` VALUES (444, 0, 4, 8);
INSERT INTO `aoa_role_power_list` VALUES (445, 0, 5, 8);
INSERT INTO `aoa_role_power_list` VALUES (446, 0, 6, 8);
INSERT INTO `aoa_role_power_list` VALUES (447, 0, 7, 8);
INSERT INTO `aoa_role_power_list` VALUES (448, 0, 8, 8);
INSERT INTO `aoa_role_power_list` VALUES (449, 0, 9, 8);
INSERT INTO `aoa_role_power_list` VALUES (450, 0, 10, 8);
INSERT INTO `aoa_role_power_list` VALUES (451, 0, 11, 8);
INSERT INTO `aoa_role_power_list` VALUES (452, 0, 12, 8);
INSERT INTO `aoa_role_power_list` VALUES (453, 0, 13, 8);
INSERT INTO `aoa_role_power_list` VALUES (454, 0, 14, 8);
INSERT INTO `aoa_role_power_list` VALUES (455, 0, 15, 8);
INSERT INTO `aoa_role_power_list` VALUES (456, 0, 16, 8);
INSERT INTO `aoa_role_power_list` VALUES (457, 0, 17, 8);
INSERT INTO `aoa_role_power_list` VALUES (458, 0, 18, 8);
INSERT INTO `aoa_role_power_list` VALUES (459, 0, 19, 8);
INSERT INTO `aoa_role_power_list` VALUES (460, 0, 20, 8);
INSERT INTO `aoa_role_power_list` VALUES (461, 0, 21, 8);
INSERT INTO `aoa_role_power_list` VALUES (462, 0, 22, 8);
INSERT INTO `aoa_role_power_list` VALUES (463, 0, 23, 8);
INSERT INTO `aoa_role_power_list` VALUES (464, 0, 24, 8);
INSERT INTO `aoa_role_power_list` VALUES (465, 0, 25, 8);
INSERT INTO `aoa_role_power_list` VALUES (466, 0, 26, 8);
INSERT INTO `aoa_role_power_list` VALUES (467, 0, 27, 8);
INSERT INTO `aoa_role_power_list` VALUES (468, 0, 28, 8);
INSERT INTO `aoa_role_power_list` VALUES (469, 0, 29, 8);
INSERT INTO `aoa_role_power_list` VALUES (470, 0, 30, 8);
INSERT INTO `aoa_role_power_list` VALUES (471, 0, 31, 8);
INSERT INTO `aoa_role_power_list` VALUES (472, 0, 32, 8);
INSERT INTO `aoa_role_power_list` VALUES (473, 0, 33, 8);
INSERT INTO `aoa_role_power_list` VALUES (474, 0, 34, 8);
INSERT INTO `aoa_role_power_list` VALUES (475, 0, 35, 8);
INSERT INTO `aoa_role_power_list` VALUES (476, 0, 36, 8);
INSERT INTO `aoa_role_power_list` VALUES (477, 0, 37, 8);
INSERT INTO `aoa_role_power_list` VALUES (478, 0, 38, 8);
INSERT INTO `aoa_role_power_list` VALUES (479, 0, 39, 8);
INSERT INTO `aoa_role_power_list` VALUES (480, 0, 40, 8);
INSERT INTO `aoa_role_power_list` VALUES (481, 0, 41, 8);
INSERT INTO `aoa_role_power_list` VALUES (482, 0, 42, 8);
INSERT INTO `aoa_role_power_list` VALUES (483, 0, 67, 8);
INSERT INTO `aoa_role_power_list` VALUES (484, 0, 76, 8);
INSERT INTO `aoa_role_power_list` VALUES (485, 0, 77, 8);
INSERT INTO `aoa_role_power_list` VALUES (486, 0, 78, 8);
INSERT INTO `aoa_role_power_list` VALUES (487, 0, 79, 8);
INSERT INTO `aoa_role_power_list` VALUES (488, 0, 80, 8);
INSERT INTO `aoa_role_power_list` VALUES (489, 0, 81, 8);
INSERT INTO `aoa_role_power_list` VALUES (490, 0, 82, 8);
INSERT INTO `aoa_role_power_list` VALUES (491, 0, 86, 8);
INSERT INTO `aoa_role_power_list` VALUES (492, 0, 87, 8);
INSERT INTO `aoa_role_power_list` VALUES (493, 0, 88, 8);
INSERT INTO `aoa_role_power_list` VALUES (494, 0, 89, 8);
INSERT INTO `aoa_role_power_list` VALUES (495, 0, 90, 8);
INSERT INTO `aoa_role_power_list` VALUES (496, 0, 1, 9);
INSERT INTO `aoa_role_power_list` VALUES (497, 0, 2, 9);
INSERT INTO `aoa_role_power_list` VALUES (498, 0, 3, 9);
INSERT INTO `aoa_role_power_list` VALUES (499, 0, 4, 9);
INSERT INTO `aoa_role_power_list` VALUES (500, 1, 5, 9);
INSERT INTO `aoa_role_power_list` VALUES (501, 0, 6, 9);
INSERT INTO `aoa_role_power_list` VALUES (502, 0, 7, 9);
INSERT INTO `aoa_role_power_list` VALUES (503, 0, 8, 9);
INSERT INTO `aoa_role_power_list` VALUES (504, 0, 9, 9);
INSERT INTO `aoa_role_power_list` VALUES (505, 0, 10, 9);
INSERT INTO `aoa_role_power_list` VALUES (506, 0, 11, 9);
INSERT INTO `aoa_role_power_list` VALUES (507, 0, 12, 9);
INSERT INTO `aoa_role_power_list` VALUES (508, 0, 13, 9);
INSERT INTO `aoa_role_power_list` VALUES (509, 0, 14, 9);
INSERT INTO `aoa_role_power_list` VALUES (510, 0, 15, 9);
INSERT INTO `aoa_role_power_list` VALUES (511, 0, 16, 9);
INSERT INTO `aoa_role_power_list` VALUES (512, 0, 17, 9);
INSERT INTO `aoa_role_power_list` VALUES (513, 0, 18, 9);
INSERT INTO `aoa_role_power_list` VALUES (514, 1, 19, 9);
INSERT INTO `aoa_role_power_list` VALUES (515, 0, 20, 9);
INSERT INTO `aoa_role_power_list` VALUES (516, 0, 21, 9);
INSERT INTO `aoa_role_power_list` VALUES (517, 0, 22, 9);
INSERT INTO `aoa_role_power_list` VALUES (518, 0, 23, 9);
INSERT INTO `aoa_role_power_list` VALUES (519, 0, 24, 9);
INSERT INTO `aoa_role_power_list` VALUES (520, 1, 25, 9);
INSERT INTO `aoa_role_power_list` VALUES (521, 1, 26, 9);
INSERT INTO `aoa_role_power_list` VALUES (522, 0, 27, 9);
INSERT INTO `aoa_role_power_list` VALUES (523, 0, 28, 9);
INSERT INTO `aoa_role_power_list` VALUES (524, 0, 29, 9);
INSERT INTO `aoa_role_power_list` VALUES (525, 0, 30, 9);
INSERT INTO `aoa_role_power_list` VALUES (526, 0, 31, 9);
INSERT INTO `aoa_role_power_list` VALUES (527, 0, 32, 9);
INSERT INTO `aoa_role_power_list` VALUES (528, 0, 33, 9);
INSERT INTO `aoa_role_power_list` VALUES (529, 0, 34, 9);
INSERT INTO `aoa_role_power_list` VALUES (530, 0, 35, 9);
INSERT INTO `aoa_role_power_list` VALUES (531, 0, 36, 9);
INSERT INTO `aoa_role_power_list` VALUES (532, 0, 37, 9);
INSERT INTO `aoa_role_power_list` VALUES (533, 0, 38, 9);
INSERT INTO `aoa_role_power_list` VALUES (534, 0, 39, 9);
INSERT INTO `aoa_role_power_list` VALUES (535, 0, 40, 9);
INSERT INTO `aoa_role_power_list` VALUES (536, 0, 41, 9);
INSERT INTO `aoa_role_power_list` VALUES (537, 0, 42, 9);
INSERT INTO `aoa_role_power_list` VALUES (538, 0, 67, 9);
INSERT INTO `aoa_role_power_list` VALUES (539, 0, 76, 9);
INSERT INTO `aoa_role_power_list` VALUES (540, 0, 77, 9);
INSERT INTO `aoa_role_power_list` VALUES (541, 0, 78, 9);
INSERT INTO `aoa_role_power_list` VALUES (542, 0, 79, 9);
INSERT INTO `aoa_role_power_list` VALUES (543, 0, 80, 9);
INSERT INTO `aoa_role_power_list` VALUES (544, 0, 81, 9);
INSERT INTO `aoa_role_power_list` VALUES (545, 0, 82, 9);
INSERT INTO `aoa_role_power_list` VALUES (546, 0, 86, 9);
INSERT INTO `aoa_role_power_list` VALUES (547, 0, 87, 9);
INSERT INTO `aoa_role_power_list` VALUES (548, 0, 88, 9);
INSERT INTO `aoa_role_power_list` VALUES (549, 0, 89, 9);
INSERT INTO `aoa_role_power_list` VALUES (550, 1, 90, 9);
INSERT INTO `aoa_role_power_list` VALUES (551, 0, 1, 10);
INSERT INTO `aoa_role_power_list` VALUES (552, 0, 2, 10);
INSERT INTO `aoa_role_power_list` VALUES (553, 0, 3, 10);
INSERT INTO `aoa_role_power_list` VALUES (554, 0, 4, 10);
INSERT INTO `aoa_role_power_list` VALUES (555, 0, 5, 10);
INSERT INTO `aoa_role_power_list` VALUES (556, 0, 6, 10);
INSERT INTO `aoa_role_power_list` VALUES (557, 0, 7, 10);
INSERT INTO `aoa_role_power_list` VALUES (558, 0, 8, 10);
INSERT INTO `aoa_role_power_list` VALUES (559, 0, 9, 10);
INSERT INTO `aoa_role_power_list` VALUES (560, 0, 10, 10);
INSERT INTO `aoa_role_power_list` VALUES (561, 0, 11, 10);
INSERT INTO `aoa_role_power_list` VALUES (562, 0, 12, 10);
INSERT INTO `aoa_role_power_list` VALUES (563, 0, 13, 10);
INSERT INTO `aoa_role_power_list` VALUES (564, 0, 14, 10);
INSERT INTO `aoa_role_power_list` VALUES (565, 0, 15, 10);
INSERT INTO `aoa_role_power_list` VALUES (566, 0, 16, 10);
INSERT INTO `aoa_role_power_list` VALUES (567, 0, 17, 10);
INSERT INTO `aoa_role_power_list` VALUES (568, 0, 18, 10);
INSERT INTO `aoa_role_power_list` VALUES (569, 0, 19, 10);
INSERT INTO `aoa_role_power_list` VALUES (570, 0, 20, 10);
INSERT INTO `aoa_role_power_list` VALUES (571, 0, 21, 10);
INSERT INTO `aoa_role_power_list` VALUES (572, 0, 22, 10);
INSERT INTO `aoa_role_power_list` VALUES (573, 0, 23, 10);
INSERT INTO `aoa_role_power_list` VALUES (574, 0, 24, 10);
INSERT INTO `aoa_role_power_list` VALUES (575, 0, 25, 10);
INSERT INTO `aoa_role_power_list` VALUES (576, 0, 26, 10);
INSERT INTO `aoa_role_power_list` VALUES (577, 0, 27, 10);
INSERT INTO `aoa_role_power_list` VALUES (578, 0, 28, 10);
INSERT INTO `aoa_role_power_list` VALUES (579, 0, 29, 10);
INSERT INTO `aoa_role_power_list` VALUES (580, 0, 30, 10);
INSERT INTO `aoa_role_power_list` VALUES (581, 0, 31, 10);
INSERT INTO `aoa_role_power_list` VALUES (582, 0, 32, 10);
INSERT INTO `aoa_role_power_list` VALUES (583, 0, 33, 10);
INSERT INTO `aoa_role_power_list` VALUES (584, 0, 34, 10);
INSERT INTO `aoa_role_power_list` VALUES (585, 0, 35, 10);
INSERT INTO `aoa_role_power_list` VALUES (586, 0, 36, 10);
INSERT INTO `aoa_role_power_list` VALUES (587, 0, 37, 10);
INSERT INTO `aoa_role_power_list` VALUES (588, 0, 38, 10);
INSERT INTO `aoa_role_power_list` VALUES (589, 0, 39, 10);
INSERT INTO `aoa_role_power_list` VALUES (590, 0, 40, 10);
INSERT INTO `aoa_role_power_list` VALUES (591, 0, 41, 10);
INSERT INTO `aoa_role_power_list` VALUES (592, 0, 42, 10);
INSERT INTO `aoa_role_power_list` VALUES (593, 0, 67, 10);
INSERT INTO `aoa_role_power_list` VALUES (594, 0, 76, 10);
INSERT INTO `aoa_role_power_list` VALUES (595, 0, 77, 10);
INSERT INTO `aoa_role_power_list` VALUES (596, 0, 78, 10);
INSERT INTO `aoa_role_power_list` VALUES (597, 0, 79, 10);
INSERT INTO `aoa_role_power_list` VALUES (598, 0, 80, 10);
INSERT INTO `aoa_role_power_list` VALUES (599, 0, 81, 10);
INSERT INTO `aoa_role_power_list` VALUES (600, 0, 82, 10);
INSERT INTO `aoa_role_power_list` VALUES (601, 0, 86, 10);
INSERT INTO `aoa_role_power_list` VALUES (602, 0, 87, 10);
INSERT INTO `aoa_role_power_list` VALUES (603, 0, 88, 10);
INSERT INTO `aoa_role_power_list` VALUES (604, 0, 89, 10);
INSERT INTO `aoa_role_power_list` VALUES (605, 0, 90, 10);
INSERT INTO `aoa_role_power_list` VALUES (606, 0, 1, 11);
INSERT INTO `aoa_role_power_list` VALUES (607, 0, 2, 11);
INSERT INTO `aoa_role_power_list` VALUES (608, 0, 3, 11);
INSERT INTO `aoa_role_power_list` VALUES (609, 0, 4, 11);
INSERT INTO `aoa_role_power_list` VALUES (610, 0, 5, 11);
INSERT INTO `aoa_role_power_list` VALUES (611, 0, 6, 11);
INSERT INTO `aoa_role_power_list` VALUES (612, 0, 7, 11);
INSERT INTO `aoa_role_power_list` VALUES (613, 0, 8, 11);
INSERT INTO `aoa_role_power_list` VALUES (614, 0, 9, 11);
INSERT INTO `aoa_role_power_list` VALUES (615, 0, 10, 11);
INSERT INTO `aoa_role_power_list` VALUES (616, 0, 11, 11);
INSERT INTO `aoa_role_power_list` VALUES (617, 0, 12, 11);
INSERT INTO `aoa_role_power_list` VALUES (618, 0, 13, 11);
INSERT INTO `aoa_role_power_list` VALUES (619, 0, 14, 11);
INSERT INTO `aoa_role_power_list` VALUES (620, 0, 15, 11);
INSERT INTO `aoa_role_power_list` VALUES (621, 0, 16, 11);
INSERT INTO `aoa_role_power_list` VALUES (622, 0, 17, 11);
INSERT INTO `aoa_role_power_list` VALUES (623, 0, 18, 11);
INSERT INTO `aoa_role_power_list` VALUES (624, 0, 19, 11);
INSERT INTO `aoa_role_power_list` VALUES (625, 0, 20, 11);
INSERT INTO `aoa_role_power_list` VALUES (626, 0, 21, 11);
INSERT INTO `aoa_role_power_list` VALUES (627, 0, 22, 11);
INSERT INTO `aoa_role_power_list` VALUES (628, 0, 23, 11);
INSERT INTO `aoa_role_power_list` VALUES (629, 0, 24, 11);
INSERT INTO `aoa_role_power_list` VALUES (630, 0, 25, 11);
INSERT INTO `aoa_role_power_list` VALUES (631, 0, 26, 11);
INSERT INTO `aoa_role_power_list` VALUES (632, 0, 27, 11);
INSERT INTO `aoa_role_power_list` VALUES (633, 0, 28, 11);
INSERT INTO `aoa_role_power_list` VALUES (634, 0, 29, 11);
INSERT INTO `aoa_role_power_list` VALUES (635, 0, 30, 11);
INSERT INTO `aoa_role_power_list` VALUES (636, 0, 31, 11);
INSERT INTO `aoa_role_power_list` VALUES (637, 0, 32, 11);
INSERT INTO `aoa_role_power_list` VALUES (638, 0, 33, 11);
INSERT INTO `aoa_role_power_list` VALUES (639, 0, 34, 11);
INSERT INTO `aoa_role_power_list` VALUES (640, 0, 35, 11);
INSERT INTO `aoa_role_power_list` VALUES (641, 0, 36, 11);
INSERT INTO `aoa_role_power_list` VALUES (642, 0, 37, 11);
INSERT INTO `aoa_role_power_list` VALUES (643, 0, 38, 11);
INSERT INTO `aoa_role_power_list` VALUES (644, 0, 39, 11);
INSERT INTO `aoa_role_power_list` VALUES (645, 0, 40, 11);
INSERT INTO `aoa_role_power_list` VALUES (646, 0, 41, 11);
INSERT INTO `aoa_role_power_list` VALUES (647, 0, 42, 11);
INSERT INTO `aoa_role_power_list` VALUES (648, 0, 67, 11);
INSERT INTO `aoa_role_power_list` VALUES (649, 0, 76, 11);
INSERT INTO `aoa_role_power_list` VALUES (650, 0, 77, 11);
INSERT INTO `aoa_role_power_list` VALUES (651, 0, 78, 11);
INSERT INTO `aoa_role_power_list` VALUES (652, 0, 79, 11);
INSERT INTO `aoa_role_power_list` VALUES (653, 0, 80, 11);
INSERT INTO `aoa_role_power_list` VALUES (654, 0, 81, 11);
INSERT INTO `aoa_role_power_list` VALUES (655, 0, 82, 11);
INSERT INTO `aoa_role_power_list` VALUES (656, 0, 86, 11);
INSERT INTO `aoa_role_power_list` VALUES (657, 0, 87, 11);
INSERT INTO `aoa_role_power_list` VALUES (658, 0, 88, 11);
INSERT INTO `aoa_role_power_list` VALUES (659, 0, 89, 11);
INSERT INTO `aoa_role_power_list` VALUES (660, 0, 90, 11);
INSERT INTO `aoa_role_power_list` VALUES (661, 0, 1, 12);
INSERT INTO `aoa_role_power_list` VALUES (662, 0, 2, 12);
INSERT INTO `aoa_role_power_list` VALUES (663, 0, 3, 12);
INSERT INTO `aoa_role_power_list` VALUES (664, 0, 4, 12);
INSERT INTO `aoa_role_power_list` VALUES (665, 0, 5, 12);
INSERT INTO `aoa_role_power_list` VALUES (666, 0, 6, 12);
INSERT INTO `aoa_role_power_list` VALUES (667, 0, 7, 12);
INSERT INTO `aoa_role_power_list` VALUES (668, 0, 8, 12);
INSERT INTO `aoa_role_power_list` VALUES (669, 0, 9, 12);
INSERT INTO `aoa_role_power_list` VALUES (670, 0, 10, 12);
INSERT INTO `aoa_role_power_list` VALUES (671, 0, 11, 12);
INSERT INTO `aoa_role_power_list` VALUES (672, 0, 12, 12);
INSERT INTO `aoa_role_power_list` VALUES (673, 0, 13, 12);
INSERT INTO `aoa_role_power_list` VALUES (674, 0, 14, 12);
INSERT INTO `aoa_role_power_list` VALUES (675, 0, 15, 12);
INSERT INTO `aoa_role_power_list` VALUES (676, 0, 16, 12);
INSERT INTO `aoa_role_power_list` VALUES (677, 0, 17, 12);
INSERT INTO `aoa_role_power_list` VALUES (678, 0, 18, 12);
INSERT INTO `aoa_role_power_list` VALUES (679, 0, 19, 12);
INSERT INTO `aoa_role_power_list` VALUES (680, 0, 20, 12);
INSERT INTO `aoa_role_power_list` VALUES (681, 0, 21, 12);
INSERT INTO `aoa_role_power_list` VALUES (682, 0, 22, 12);
INSERT INTO `aoa_role_power_list` VALUES (683, 0, 23, 12);
INSERT INTO `aoa_role_power_list` VALUES (684, 0, 24, 12);
INSERT INTO `aoa_role_power_list` VALUES (685, 0, 25, 12);
INSERT INTO `aoa_role_power_list` VALUES (686, 0, 26, 12);
INSERT INTO `aoa_role_power_list` VALUES (687, 0, 27, 12);
INSERT INTO `aoa_role_power_list` VALUES (688, 0, 28, 12);
INSERT INTO `aoa_role_power_list` VALUES (689, 0, 29, 12);
INSERT INTO `aoa_role_power_list` VALUES (690, 0, 30, 12);
INSERT INTO `aoa_role_power_list` VALUES (691, 0, 31, 12);
INSERT INTO `aoa_role_power_list` VALUES (692, 0, 32, 12);
INSERT INTO `aoa_role_power_list` VALUES (693, 0, 33, 12);
INSERT INTO `aoa_role_power_list` VALUES (694, 0, 34, 12);
INSERT INTO `aoa_role_power_list` VALUES (695, 0, 35, 12);
INSERT INTO `aoa_role_power_list` VALUES (696, 0, 36, 12);
INSERT INTO `aoa_role_power_list` VALUES (697, 0, 37, 12);
INSERT INTO `aoa_role_power_list` VALUES (698, 0, 38, 12);
INSERT INTO `aoa_role_power_list` VALUES (699, 0, 39, 12);
INSERT INTO `aoa_role_power_list` VALUES (700, 0, 40, 12);
INSERT INTO `aoa_role_power_list` VALUES (701, 0, 41, 12);
INSERT INTO `aoa_role_power_list` VALUES (702, 0, 42, 12);
INSERT INTO `aoa_role_power_list` VALUES (703, 0, 67, 12);
INSERT INTO `aoa_role_power_list` VALUES (704, 0, 76, 12);
INSERT INTO `aoa_role_power_list` VALUES (705, 0, 77, 12);
INSERT INTO `aoa_role_power_list` VALUES (706, 0, 78, 12);
INSERT INTO `aoa_role_power_list` VALUES (707, 0, 79, 12);
INSERT INTO `aoa_role_power_list` VALUES (708, 0, 80, 12);
INSERT INTO `aoa_role_power_list` VALUES (709, 0, 81, 12);
INSERT INTO `aoa_role_power_list` VALUES (710, 0, 82, 12);
INSERT INTO `aoa_role_power_list` VALUES (711, 0, 86, 12);
INSERT INTO `aoa_role_power_list` VALUES (712, 0, 87, 12);
INSERT INTO `aoa_role_power_list` VALUES (713, 0, 88, 12);
INSERT INTO `aoa_role_power_list` VALUES (714, 0, 89, 12);
INSERT INTO `aoa_role_power_list` VALUES (715, 0, 90, 12);
INSERT INTO `aoa_role_power_list` VALUES (716, 0, 1, 13);
INSERT INTO `aoa_role_power_list` VALUES (717, 0, 2, 13);
INSERT INTO `aoa_role_power_list` VALUES (718, 0, 3, 13);
INSERT INTO `aoa_role_power_list` VALUES (719, 0, 4, 13);
INSERT INTO `aoa_role_power_list` VALUES (720, 0, 5, 13);
INSERT INTO `aoa_role_power_list` VALUES (721, 0, 6, 13);
INSERT INTO `aoa_role_power_list` VALUES (722, 0, 7, 13);
INSERT INTO `aoa_role_power_list` VALUES (723, 0, 8, 13);
INSERT INTO `aoa_role_power_list` VALUES (724, 0, 9, 13);
INSERT INTO `aoa_role_power_list` VALUES (725, 0, 10, 13);
INSERT INTO `aoa_role_power_list` VALUES (726, 0, 11, 13);
INSERT INTO `aoa_role_power_list` VALUES (727, 0, 12, 13);
INSERT INTO `aoa_role_power_list` VALUES (728, 0, 13, 13);
INSERT INTO `aoa_role_power_list` VALUES (729, 0, 14, 13);
INSERT INTO `aoa_role_power_list` VALUES (730, 0, 15, 13);
INSERT INTO `aoa_role_power_list` VALUES (731, 0, 16, 13);
INSERT INTO `aoa_role_power_list` VALUES (732, 0, 17, 13);
INSERT INTO `aoa_role_power_list` VALUES (733, 0, 18, 13);
INSERT INTO `aoa_role_power_list` VALUES (734, 0, 19, 13);
INSERT INTO `aoa_role_power_list` VALUES (735, 0, 20, 13);
INSERT INTO `aoa_role_power_list` VALUES (736, 0, 21, 13);
INSERT INTO `aoa_role_power_list` VALUES (737, 0, 22, 13);
INSERT INTO `aoa_role_power_list` VALUES (738, 0, 23, 13);
INSERT INTO `aoa_role_power_list` VALUES (739, 0, 24, 13);
INSERT INTO `aoa_role_power_list` VALUES (740, 0, 25, 13);
INSERT INTO `aoa_role_power_list` VALUES (741, 0, 26, 13);
INSERT INTO `aoa_role_power_list` VALUES (742, 0, 27, 13);
INSERT INTO `aoa_role_power_list` VALUES (743, 0, 28, 13);
INSERT INTO `aoa_role_power_list` VALUES (744, 0, 29, 13);
INSERT INTO `aoa_role_power_list` VALUES (745, 0, 30, 13);
INSERT INTO `aoa_role_power_list` VALUES (746, 0, 31, 13);
INSERT INTO `aoa_role_power_list` VALUES (747, 0, 32, 13);
INSERT INTO `aoa_role_power_list` VALUES (748, 0, 33, 13);
INSERT INTO `aoa_role_power_list` VALUES (749, 0, 34, 13);
INSERT INTO `aoa_role_power_list` VALUES (750, 0, 35, 13);
INSERT INTO `aoa_role_power_list` VALUES (751, 0, 36, 13);
INSERT INTO `aoa_role_power_list` VALUES (752, 0, 37, 13);
INSERT INTO `aoa_role_power_list` VALUES (753, 0, 38, 13);
INSERT INTO `aoa_role_power_list` VALUES (754, 0, 39, 13);
INSERT INTO `aoa_role_power_list` VALUES (755, 0, 40, 13);
INSERT INTO `aoa_role_power_list` VALUES (756, 0, 41, 13);
INSERT INTO `aoa_role_power_list` VALUES (757, 0, 42, 13);
INSERT INTO `aoa_role_power_list` VALUES (758, 0, 67, 13);
INSERT INTO `aoa_role_power_list` VALUES (759, 0, 76, 13);
INSERT INTO `aoa_role_power_list` VALUES (760, 0, 77, 13);
INSERT INTO `aoa_role_power_list` VALUES (761, 0, 78, 13);
INSERT INTO `aoa_role_power_list` VALUES (762, 0, 79, 13);
INSERT INTO `aoa_role_power_list` VALUES (763, 0, 80, 13);
INSERT INTO `aoa_role_power_list` VALUES (764, 0, 81, 13);
INSERT INTO `aoa_role_power_list` VALUES (765, 0, 82, 13);
INSERT INTO `aoa_role_power_list` VALUES (766, 0, 86, 13);
INSERT INTO `aoa_role_power_list` VALUES (767, 0, 87, 13);
INSERT INTO `aoa_role_power_list` VALUES (768, 0, 88, 13);
INSERT INTO `aoa_role_power_list` VALUES (769, 0, 89, 13);
INSERT INTO `aoa_role_power_list` VALUES (770, 0, 90, 13);
INSERT INTO `aoa_role_power_list` VALUES (771, 0, 1, 14);
INSERT INTO `aoa_role_power_list` VALUES (772, 0, 2, 14);
INSERT INTO `aoa_role_power_list` VALUES (773, 0, 3, 14);
INSERT INTO `aoa_role_power_list` VALUES (774, 0, 4, 14);
INSERT INTO `aoa_role_power_list` VALUES (775, 0, 5, 14);
INSERT INTO `aoa_role_power_list` VALUES (776, 0, 6, 14);
INSERT INTO `aoa_role_power_list` VALUES (777, 0, 7, 14);
INSERT INTO `aoa_role_power_list` VALUES (778, 0, 8, 14);
INSERT INTO `aoa_role_power_list` VALUES (779, 0, 9, 14);
INSERT INTO `aoa_role_power_list` VALUES (780, 0, 10, 14);
INSERT INTO `aoa_role_power_list` VALUES (781, 0, 11, 14);
INSERT INTO `aoa_role_power_list` VALUES (782, 0, 12, 14);
INSERT INTO `aoa_role_power_list` VALUES (783, 0, 13, 14);
INSERT INTO `aoa_role_power_list` VALUES (784, 0, 14, 14);
INSERT INTO `aoa_role_power_list` VALUES (785, 0, 15, 14);
INSERT INTO `aoa_role_power_list` VALUES (786, 0, 16, 14);
INSERT INTO `aoa_role_power_list` VALUES (787, 0, 17, 14);
INSERT INTO `aoa_role_power_list` VALUES (788, 0, 18, 14);
INSERT INTO `aoa_role_power_list` VALUES (789, 0, 19, 14);
INSERT INTO `aoa_role_power_list` VALUES (790, 0, 20, 14);
INSERT INTO `aoa_role_power_list` VALUES (791, 0, 21, 14);
INSERT INTO `aoa_role_power_list` VALUES (792, 0, 22, 14);
INSERT INTO `aoa_role_power_list` VALUES (793, 0, 23, 14);
INSERT INTO `aoa_role_power_list` VALUES (794, 0, 24, 14);
INSERT INTO `aoa_role_power_list` VALUES (795, 0, 25, 14);
INSERT INTO `aoa_role_power_list` VALUES (796, 0, 26, 14);
INSERT INTO `aoa_role_power_list` VALUES (797, 0, 27, 14);
INSERT INTO `aoa_role_power_list` VALUES (798, 0, 28, 14);
INSERT INTO `aoa_role_power_list` VALUES (799, 0, 29, 14);
INSERT INTO `aoa_role_power_list` VALUES (800, 0, 30, 14);
INSERT INTO `aoa_role_power_list` VALUES (801, 0, 31, 14);
INSERT INTO `aoa_role_power_list` VALUES (802, 0, 32, 14);
INSERT INTO `aoa_role_power_list` VALUES (803, 0, 33, 14);
INSERT INTO `aoa_role_power_list` VALUES (804, 0, 34, 14);
INSERT INTO `aoa_role_power_list` VALUES (805, 0, 35, 14);
INSERT INTO `aoa_role_power_list` VALUES (806, 0, 36, 14);
INSERT INTO `aoa_role_power_list` VALUES (807, 0, 37, 14);
INSERT INTO `aoa_role_power_list` VALUES (808, 0, 38, 14);
INSERT INTO `aoa_role_power_list` VALUES (809, 0, 39, 14);
INSERT INTO `aoa_role_power_list` VALUES (810, 0, 40, 14);
INSERT INTO `aoa_role_power_list` VALUES (811, 0, 41, 14);
INSERT INTO `aoa_role_power_list` VALUES (812, 0, 42, 14);
INSERT INTO `aoa_role_power_list` VALUES (813, 0, 67, 14);
INSERT INTO `aoa_role_power_list` VALUES (814, 0, 76, 14);
INSERT INTO `aoa_role_power_list` VALUES (815, 0, 77, 14);
INSERT INTO `aoa_role_power_list` VALUES (816, 0, 78, 14);
INSERT INTO `aoa_role_power_list` VALUES (817, 0, 79, 14);
INSERT INTO `aoa_role_power_list` VALUES (818, 0, 80, 14);
INSERT INTO `aoa_role_power_list` VALUES (819, 0, 81, 14);
INSERT INTO `aoa_role_power_list` VALUES (820, 0, 82, 14);
INSERT INTO `aoa_role_power_list` VALUES (821, 0, 86, 14);
INSERT INTO `aoa_role_power_list` VALUES (822, 0, 87, 14);
INSERT INTO `aoa_role_power_list` VALUES (823, 0, 88, 14);
INSERT INTO `aoa_role_power_list` VALUES (824, 0, 89, 14);
INSERT INTO `aoa_role_power_list` VALUES (825, 0, 90, 14);
INSERT INTO `aoa_role_power_list` VALUES (826, 0, 1, 15);
INSERT INTO `aoa_role_power_list` VALUES (827, 0, 2, 15);
INSERT INTO `aoa_role_power_list` VALUES (828, 0, 3, 15);
INSERT INTO `aoa_role_power_list` VALUES (829, 0, 4, 15);
INSERT INTO `aoa_role_power_list` VALUES (830, 0, 5, 15);
INSERT INTO `aoa_role_power_list` VALUES (831, 0, 6, 15);
INSERT INTO `aoa_role_power_list` VALUES (832, 0, 7, 15);
INSERT INTO `aoa_role_power_list` VALUES (833, 0, 8, 15);
INSERT INTO `aoa_role_power_list` VALUES (834, 0, 9, 15);
INSERT INTO `aoa_role_power_list` VALUES (835, 0, 10, 15);
INSERT INTO `aoa_role_power_list` VALUES (836, 0, 11, 15);
INSERT INTO `aoa_role_power_list` VALUES (837, 0, 12, 15);
INSERT INTO `aoa_role_power_list` VALUES (838, 0, 13, 15);
INSERT INTO `aoa_role_power_list` VALUES (839, 0, 14, 15);
INSERT INTO `aoa_role_power_list` VALUES (840, 0, 15, 15);
INSERT INTO `aoa_role_power_list` VALUES (841, 0, 16, 15);
INSERT INTO `aoa_role_power_list` VALUES (842, 0, 17, 15);
INSERT INTO `aoa_role_power_list` VALUES (843, 0, 18, 15);
INSERT INTO `aoa_role_power_list` VALUES (844, 0, 19, 15);
INSERT INTO `aoa_role_power_list` VALUES (845, 0, 20, 15);
INSERT INTO `aoa_role_power_list` VALUES (846, 0, 21, 15);
INSERT INTO `aoa_role_power_list` VALUES (847, 0, 22, 15);
INSERT INTO `aoa_role_power_list` VALUES (848, 0, 23, 15);
INSERT INTO `aoa_role_power_list` VALUES (849, 0, 24, 15);
INSERT INTO `aoa_role_power_list` VALUES (850, 0, 25, 15);
INSERT INTO `aoa_role_power_list` VALUES (851, 0, 26, 15);
INSERT INTO `aoa_role_power_list` VALUES (852, 0, 27, 15);
INSERT INTO `aoa_role_power_list` VALUES (853, 0, 28, 15);
INSERT INTO `aoa_role_power_list` VALUES (854, 0, 29, 15);
INSERT INTO `aoa_role_power_list` VALUES (855, 0, 30, 15);
INSERT INTO `aoa_role_power_list` VALUES (856, 0, 31, 15);
INSERT INTO `aoa_role_power_list` VALUES (857, 0, 32, 15);
INSERT INTO `aoa_role_power_list` VALUES (858, 0, 33, 15);
INSERT INTO `aoa_role_power_list` VALUES (859, 0, 34, 15);
INSERT INTO `aoa_role_power_list` VALUES (860, 0, 35, 15);
INSERT INTO `aoa_role_power_list` VALUES (861, 0, 36, 15);
INSERT INTO `aoa_role_power_list` VALUES (862, 0, 37, 15);
INSERT INTO `aoa_role_power_list` VALUES (863, 0, 38, 15);
INSERT INTO `aoa_role_power_list` VALUES (864, 0, 39, 15);
INSERT INTO `aoa_role_power_list` VALUES (865, 0, 40, 15);
INSERT INTO `aoa_role_power_list` VALUES (866, 0, 41, 15);
INSERT INTO `aoa_role_power_list` VALUES (867, 0, 42, 15);
INSERT INTO `aoa_role_power_list` VALUES (868, 0, 67, 15);
INSERT INTO `aoa_role_power_list` VALUES (869, 0, 76, 15);
INSERT INTO `aoa_role_power_list` VALUES (870, 0, 77, 15);
INSERT INTO `aoa_role_power_list` VALUES (871, 0, 78, 15);
INSERT INTO `aoa_role_power_list` VALUES (872, 0, 79, 15);
INSERT INTO `aoa_role_power_list` VALUES (873, 0, 80, 15);
INSERT INTO `aoa_role_power_list` VALUES (874, 0, 81, 15);
INSERT INTO `aoa_role_power_list` VALUES (875, 0, 82, 15);
INSERT INTO `aoa_role_power_list` VALUES (876, 0, 86, 15);
INSERT INTO `aoa_role_power_list` VALUES (877, 0, 87, 15);
INSERT INTO `aoa_role_power_list` VALUES (878, 0, 88, 15);
INSERT INTO `aoa_role_power_list` VALUES (879, 0, 89, 15);
INSERT INTO `aoa_role_power_list` VALUES (880, 0, 90, 15);
INSERT INTO `aoa_role_power_list` VALUES (881, 0, 1, 16);
INSERT INTO `aoa_role_power_list` VALUES (882, 0, 2, 16);
INSERT INTO `aoa_role_power_list` VALUES (883, 0, 3, 16);
INSERT INTO `aoa_role_power_list` VALUES (884, 0, 4, 16);
INSERT INTO `aoa_role_power_list` VALUES (885, 0, 5, 16);
INSERT INTO `aoa_role_power_list` VALUES (886, 0, 6, 16);
INSERT INTO `aoa_role_power_list` VALUES (887, 0, 7, 16);
INSERT INTO `aoa_role_power_list` VALUES (888, 0, 8, 16);
INSERT INTO `aoa_role_power_list` VALUES (889, 0, 9, 16);
INSERT INTO `aoa_role_power_list` VALUES (890, 0, 10, 16);
INSERT INTO `aoa_role_power_list` VALUES (891, 0, 11, 16);
INSERT INTO `aoa_role_power_list` VALUES (892, 0, 12, 16);
INSERT INTO `aoa_role_power_list` VALUES (893, 0, 13, 16);
INSERT INTO `aoa_role_power_list` VALUES (894, 0, 14, 16);
INSERT INTO `aoa_role_power_list` VALUES (895, 0, 15, 16);
INSERT INTO `aoa_role_power_list` VALUES (896, 0, 16, 16);
INSERT INTO `aoa_role_power_list` VALUES (897, 0, 17, 16);
INSERT INTO `aoa_role_power_list` VALUES (898, 0, 18, 16);
INSERT INTO `aoa_role_power_list` VALUES (899, 0, 19, 16);
INSERT INTO `aoa_role_power_list` VALUES (900, 0, 20, 16);
INSERT INTO `aoa_role_power_list` VALUES (901, 0, 21, 16);
INSERT INTO `aoa_role_power_list` VALUES (902, 0, 22, 16);
INSERT INTO `aoa_role_power_list` VALUES (903, 0, 23, 16);
INSERT INTO `aoa_role_power_list` VALUES (904, 0, 24, 16);
INSERT INTO `aoa_role_power_list` VALUES (905, 0, 25, 16);
INSERT INTO `aoa_role_power_list` VALUES (906, 0, 26, 16);
INSERT INTO `aoa_role_power_list` VALUES (907, 0, 27, 16);
INSERT INTO `aoa_role_power_list` VALUES (908, 0, 28, 16);
INSERT INTO `aoa_role_power_list` VALUES (909, 0, 29, 16);
INSERT INTO `aoa_role_power_list` VALUES (910, 0, 30, 16);
INSERT INTO `aoa_role_power_list` VALUES (911, 0, 31, 16);
INSERT INTO `aoa_role_power_list` VALUES (912, 0, 32, 16);
INSERT INTO `aoa_role_power_list` VALUES (913, 0, 33, 16);
INSERT INTO `aoa_role_power_list` VALUES (914, 0, 34, 16);
INSERT INTO `aoa_role_power_list` VALUES (915, 0, 35, 16);
INSERT INTO `aoa_role_power_list` VALUES (916, 0, 36, 16);
INSERT INTO `aoa_role_power_list` VALUES (917, 0, 37, 16);
INSERT INTO `aoa_role_power_list` VALUES (918, 0, 38, 16);
INSERT INTO `aoa_role_power_list` VALUES (919, 0, 39, 16);
INSERT INTO `aoa_role_power_list` VALUES (920, 0, 40, 16);
INSERT INTO `aoa_role_power_list` VALUES (921, 0, 41, 16);
INSERT INTO `aoa_role_power_list` VALUES (922, 0, 42, 16);
INSERT INTO `aoa_role_power_list` VALUES (923, 0, 67, 16);
INSERT INTO `aoa_role_power_list` VALUES (924, 0, 76, 16);
INSERT INTO `aoa_role_power_list` VALUES (925, 0, 77, 16);
INSERT INTO `aoa_role_power_list` VALUES (926, 0, 78, 16);
INSERT INTO `aoa_role_power_list` VALUES (927, 0, 79, 16);
INSERT INTO `aoa_role_power_list` VALUES (928, 0, 80, 16);
INSERT INTO `aoa_role_power_list` VALUES (929, 0, 81, 16);
INSERT INTO `aoa_role_power_list` VALUES (930, 0, 82, 16);
INSERT INTO `aoa_role_power_list` VALUES (931, 0, 86, 16);
INSERT INTO `aoa_role_power_list` VALUES (932, 0, 87, 16);
INSERT INTO `aoa_role_power_list` VALUES (933, 0, 88, 16);
INSERT INTO `aoa_role_power_list` VALUES (934, 0, 89, 16);
INSERT INTO `aoa_role_power_list` VALUES (935, 0, 90, 16);
INSERT INTO `aoa_role_power_list` VALUES (936, 0, 1, 17);
INSERT INTO `aoa_role_power_list` VALUES (937, 0, 2, 17);
INSERT INTO `aoa_role_power_list` VALUES (938, 0, 3, 17);
INSERT INTO `aoa_role_power_list` VALUES (939, 0, 4, 17);
INSERT INTO `aoa_role_power_list` VALUES (940, 0, 5, 17);
INSERT INTO `aoa_role_power_list` VALUES (941, 0, 6, 17);
INSERT INTO `aoa_role_power_list` VALUES (942, 0, 7, 17);
INSERT INTO `aoa_role_power_list` VALUES (943, 0, 8, 17);
INSERT INTO `aoa_role_power_list` VALUES (944, 0, 9, 17);
INSERT INTO `aoa_role_power_list` VALUES (945, 0, 10, 17);
INSERT INTO `aoa_role_power_list` VALUES (946, 0, 11, 17);
INSERT INTO `aoa_role_power_list` VALUES (947, 0, 12, 17);
INSERT INTO `aoa_role_power_list` VALUES (948, 0, 13, 17);
INSERT INTO `aoa_role_power_list` VALUES (949, 0, 14, 17);
INSERT INTO `aoa_role_power_list` VALUES (950, 0, 15, 17);
INSERT INTO `aoa_role_power_list` VALUES (951, 0, 16, 17);
INSERT INTO `aoa_role_power_list` VALUES (952, 0, 17, 17);
INSERT INTO `aoa_role_power_list` VALUES (953, 0, 18, 17);
INSERT INTO `aoa_role_power_list` VALUES (954, 0, 19, 17);
INSERT INTO `aoa_role_power_list` VALUES (955, 0, 20, 17);
INSERT INTO `aoa_role_power_list` VALUES (956, 0, 21, 17);
INSERT INTO `aoa_role_power_list` VALUES (957, 0, 22, 17);
INSERT INTO `aoa_role_power_list` VALUES (958, 0, 23, 17);
INSERT INTO `aoa_role_power_list` VALUES (959, 0, 24, 17);
INSERT INTO `aoa_role_power_list` VALUES (960, 0, 25, 17);
INSERT INTO `aoa_role_power_list` VALUES (961, 0, 26, 17);
INSERT INTO `aoa_role_power_list` VALUES (962, 0, 27, 17);
INSERT INTO `aoa_role_power_list` VALUES (963, 0, 28, 17);
INSERT INTO `aoa_role_power_list` VALUES (964, 0, 29, 17);
INSERT INTO `aoa_role_power_list` VALUES (965, 0, 30, 17);
INSERT INTO `aoa_role_power_list` VALUES (966, 0, 31, 17);
INSERT INTO `aoa_role_power_list` VALUES (967, 0, 32, 17);
INSERT INTO `aoa_role_power_list` VALUES (968, 0, 33, 17);
INSERT INTO `aoa_role_power_list` VALUES (969, 0, 34, 17);
INSERT INTO `aoa_role_power_list` VALUES (970, 0, 35, 17);
INSERT INTO `aoa_role_power_list` VALUES (971, 0, 36, 17);
INSERT INTO `aoa_role_power_list` VALUES (972, 0, 37, 17);
INSERT INTO `aoa_role_power_list` VALUES (973, 0, 38, 17);
INSERT INTO `aoa_role_power_list` VALUES (974, 0, 39, 17);
INSERT INTO `aoa_role_power_list` VALUES (975, 0, 40, 17);
INSERT INTO `aoa_role_power_list` VALUES (976, 0, 41, 17);
INSERT INTO `aoa_role_power_list` VALUES (977, 0, 42, 17);
INSERT INTO `aoa_role_power_list` VALUES (978, 0, 67, 17);
INSERT INTO `aoa_role_power_list` VALUES (979, 0, 76, 17);
INSERT INTO `aoa_role_power_list` VALUES (980, 0, 77, 17);
INSERT INTO `aoa_role_power_list` VALUES (981, 0, 78, 17);
INSERT INTO `aoa_role_power_list` VALUES (982, 0, 79, 17);
INSERT INTO `aoa_role_power_list` VALUES (983, 0, 80, 17);
INSERT INTO `aoa_role_power_list` VALUES (984, 0, 81, 17);
INSERT INTO `aoa_role_power_list` VALUES (985, 0, 82, 17);
INSERT INTO `aoa_role_power_list` VALUES (986, 0, 86, 17);
INSERT INTO `aoa_role_power_list` VALUES (987, 0, 87, 17);
INSERT INTO `aoa_role_power_list` VALUES (988, 0, 88, 17);
INSERT INTO `aoa_role_power_list` VALUES (989, 0, 89, 17);
INSERT INTO `aoa_role_power_list` VALUES (990, 0, 90, 17);
INSERT INTO `aoa_role_power_list` VALUES (991, 0, 1, 18);
INSERT INTO `aoa_role_power_list` VALUES (992, 0, 2, 18);
INSERT INTO `aoa_role_power_list` VALUES (993, 0, 3, 18);
INSERT INTO `aoa_role_power_list` VALUES (994, 0, 4, 18);
INSERT INTO `aoa_role_power_list` VALUES (995, 0, 5, 18);
INSERT INTO `aoa_role_power_list` VALUES (996, 0, 6, 18);
INSERT INTO `aoa_role_power_list` VALUES (997, 0, 7, 18);
INSERT INTO `aoa_role_power_list` VALUES (998, 0, 8, 18);
INSERT INTO `aoa_role_power_list` VALUES (999, 0, 9, 18);
INSERT INTO `aoa_role_power_list` VALUES (1000, 0, 10, 18);
INSERT INTO `aoa_role_power_list` VALUES (1001, 0, 11, 18);
INSERT INTO `aoa_role_power_list` VALUES (1002, 0, 12, 18);
INSERT INTO `aoa_role_power_list` VALUES (1003, 0, 13, 18);
INSERT INTO `aoa_role_power_list` VALUES (1004, 0, 14, 18);
INSERT INTO `aoa_role_power_list` VALUES (1005, 0, 15, 18);
INSERT INTO `aoa_role_power_list` VALUES (1006, 0, 16, 18);
INSERT INTO `aoa_role_power_list` VALUES (1007, 0, 17, 18);
INSERT INTO `aoa_role_power_list` VALUES (1008, 0, 18, 18);
INSERT INTO `aoa_role_power_list` VALUES (1009, 0, 19, 18);
INSERT INTO `aoa_role_power_list` VALUES (1010, 0, 20, 18);
INSERT INTO `aoa_role_power_list` VALUES (1011, 0, 21, 18);
INSERT INTO `aoa_role_power_list` VALUES (1012, 0, 22, 18);
INSERT INTO `aoa_role_power_list` VALUES (1013, 0, 23, 18);
INSERT INTO `aoa_role_power_list` VALUES (1014, 0, 24, 18);
INSERT INTO `aoa_role_power_list` VALUES (1015, 0, 25, 18);
INSERT INTO `aoa_role_power_list` VALUES (1016, 0, 26, 18);
INSERT INTO `aoa_role_power_list` VALUES (1017, 0, 27, 18);
INSERT INTO `aoa_role_power_list` VALUES (1018, 0, 28, 18);
INSERT INTO `aoa_role_power_list` VALUES (1019, 0, 29, 18);
INSERT INTO `aoa_role_power_list` VALUES (1020, 0, 30, 18);
INSERT INTO `aoa_role_power_list` VALUES (1021, 0, 31, 18);
INSERT INTO `aoa_role_power_list` VALUES (1022, 0, 32, 18);
INSERT INTO `aoa_role_power_list` VALUES (1023, 0, 33, 18);
INSERT INTO `aoa_role_power_list` VALUES (1024, 0, 34, 18);
INSERT INTO `aoa_role_power_list` VALUES (1025, 0, 35, 18);
INSERT INTO `aoa_role_power_list` VALUES (1026, 0, 36, 18);
INSERT INTO `aoa_role_power_list` VALUES (1027, 0, 37, 18);
INSERT INTO `aoa_role_power_list` VALUES (1028, 0, 38, 18);
INSERT INTO `aoa_role_power_list` VALUES (1029, 0, 39, 18);
INSERT INTO `aoa_role_power_list` VALUES (1030, 0, 40, 18);
INSERT INTO `aoa_role_power_list` VALUES (1031, 0, 41, 18);
INSERT INTO `aoa_role_power_list` VALUES (1032, 0, 42, 18);
INSERT INTO `aoa_role_power_list` VALUES (1033, 0, 67, 18);
INSERT INTO `aoa_role_power_list` VALUES (1034, 0, 76, 18);
INSERT INTO `aoa_role_power_list` VALUES (1035, 0, 77, 18);
INSERT INTO `aoa_role_power_list` VALUES (1036, 0, 78, 18);
INSERT INTO `aoa_role_power_list` VALUES (1037, 0, 79, 18);
INSERT INTO `aoa_role_power_list` VALUES (1038, 0, 80, 18);
INSERT INTO `aoa_role_power_list` VALUES (1039, 0, 81, 18);
INSERT INTO `aoa_role_power_list` VALUES (1040, 0, 82, 18);
INSERT INTO `aoa_role_power_list` VALUES (1041, 0, 86, 18);
INSERT INTO `aoa_role_power_list` VALUES (1042, 0, 87, 18);
INSERT INTO `aoa_role_power_list` VALUES (1043, 0, 88, 18);
INSERT INTO `aoa_role_power_list` VALUES (1044, 0, 89, 18);
INSERT INTO `aoa_role_power_list` VALUES (1045, 0, 90, 18);
INSERT INTO `aoa_role_power_list` VALUES (1046, 0, 1, 19);
INSERT INTO `aoa_role_power_list` VALUES (1047, 0, 2, 19);
INSERT INTO `aoa_role_power_list` VALUES (1048, 0, 3, 19);
INSERT INTO `aoa_role_power_list` VALUES (1049, 0, 4, 19);
INSERT INTO `aoa_role_power_list` VALUES (1050, 0, 5, 19);
INSERT INTO `aoa_role_power_list` VALUES (1051, 0, 6, 19);
INSERT INTO `aoa_role_power_list` VALUES (1052, 0, 7, 19);
INSERT INTO `aoa_role_power_list` VALUES (1053, 0, 8, 19);
INSERT INTO `aoa_role_power_list` VALUES (1054, 0, 9, 19);
INSERT INTO `aoa_role_power_list` VALUES (1055, 0, 10, 19);
INSERT INTO `aoa_role_power_list` VALUES (1056, 0, 11, 19);
INSERT INTO `aoa_role_power_list` VALUES (1057, 0, 12, 19);
INSERT INTO `aoa_role_power_list` VALUES (1058, 0, 13, 19);
INSERT INTO `aoa_role_power_list` VALUES (1059, 0, 14, 19);
INSERT INTO `aoa_role_power_list` VALUES (1060, 0, 15, 19);
INSERT INTO `aoa_role_power_list` VALUES (1061, 0, 16, 19);
INSERT INTO `aoa_role_power_list` VALUES (1062, 0, 17, 19);
INSERT INTO `aoa_role_power_list` VALUES (1063, 0, 18, 19);
INSERT INTO `aoa_role_power_list` VALUES (1064, 0, 19, 19);
INSERT INTO `aoa_role_power_list` VALUES (1065, 0, 20, 19);
INSERT INTO `aoa_role_power_list` VALUES (1066, 0, 21, 19);
INSERT INTO `aoa_role_power_list` VALUES (1067, 0, 22, 19);
INSERT INTO `aoa_role_power_list` VALUES (1068, 0, 23, 19);
INSERT INTO `aoa_role_power_list` VALUES (1069, 0, 24, 19);
INSERT INTO `aoa_role_power_list` VALUES (1070, 0, 25, 19);
INSERT INTO `aoa_role_power_list` VALUES (1071, 0, 26, 19);
INSERT INTO `aoa_role_power_list` VALUES (1072, 0, 27, 19);
INSERT INTO `aoa_role_power_list` VALUES (1073, 0, 28, 19);
INSERT INTO `aoa_role_power_list` VALUES (1074, 0, 29, 19);
INSERT INTO `aoa_role_power_list` VALUES (1075, 0, 30, 19);
INSERT INTO `aoa_role_power_list` VALUES (1076, 0, 31, 19);
INSERT INTO `aoa_role_power_list` VALUES (1077, 0, 32, 19);
INSERT INTO `aoa_role_power_list` VALUES (1078, 0, 33, 19);
INSERT INTO `aoa_role_power_list` VALUES (1079, 0, 34, 19);
INSERT INTO `aoa_role_power_list` VALUES (1080, 0, 35, 19);
INSERT INTO `aoa_role_power_list` VALUES (1081, 0, 36, 19);
INSERT INTO `aoa_role_power_list` VALUES (1082, 0, 37, 19);
INSERT INTO `aoa_role_power_list` VALUES (1083, 0, 38, 19);
INSERT INTO `aoa_role_power_list` VALUES (1084, 0, 39, 19);
INSERT INTO `aoa_role_power_list` VALUES (1085, 0, 40, 19);
INSERT INTO `aoa_role_power_list` VALUES (1086, 0, 41, 19);
INSERT INTO `aoa_role_power_list` VALUES (1087, 0, 42, 19);
INSERT INTO `aoa_role_power_list` VALUES (1088, 0, 67, 19);
INSERT INTO `aoa_role_power_list` VALUES (1089, 0, 76, 19);
INSERT INTO `aoa_role_power_list` VALUES (1090, 0, 77, 19);
INSERT INTO `aoa_role_power_list` VALUES (1091, 0, 78, 19);
INSERT INTO `aoa_role_power_list` VALUES (1092, 0, 79, 19);
INSERT INTO `aoa_role_power_list` VALUES (1093, 0, 80, 19);
INSERT INTO `aoa_role_power_list` VALUES (1094, 0, 81, 19);
INSERT INTO `aoa_role_power_list` VALUES (1095, 0, 82, 19);
INSERT INTO `aoa_role_power_list` VALUES (1096, 0, 86, 19);
INSERT INTO `aoa_role_power_list` VALUES (1097, 0, 87, 19);
INSERT INTO `aoa_role_power_list` VALUES (1098, 0, 88, 19);
INSERT INTO `aoa_role_power_list` VALUES (1099, 0, 89, 19);
INSERT INTO `aoa_role_power_list` VALUES (1100, 0, 90, 19);
INSERT INTO `aoa_role_power_list` VALUES (1101, 1, 91, 1);
INSERT INTO `aoa_role_power_list` VALUES (1102, 0, 91, 2);
INSERT INTO `aoa_role_power_list` VALUES (1103, 0, 91, 3);
INSERT INTO `aoa_role_power_list` VALUES (1104, 0, 91, 4);
INSERT INTO `aoa_role_power_list` VALUES (1105, 0, 91, 5);
INSERT INTO `aoa_role_power_list` VALUES (1106, 0, 91, 6);
INSERT INTO `aoa_role_power_list` VALUES (1107, 0, 91, 7);
INSERT INTO `aoa_role_power_list` VALUES (1108, 0, 91, 8);
INSERT INTO `aoa_role_power_list` VALUES (1109, 0, 91, 9);
INSERT INTO `aoa_role_power_list` VALUES (1110, 0, 91, 10);
INSERT INTO `aoa_role_power_list` VALUES (1111, 0, 91, 11);
INSERT INTO `aoa_role_power_list` VALUES (1112, 0, 91, 12);
INSERT INTO `aoa_role_power_list` VALUES (1113, 0, 91, 13);
INSERT INTO `aoa_role_power_list` VALUES (1114, 0, 91, 14);
INSERT INTO `aoa_role_power_list` VALUES (1115, 0, 91, 15);
INSERT INTO `aoa_role_power_list` VALUES (1116, 0, 91, 16);
INSERT INTO `aoa_role_power_list` VALUES (1117, 0, 91, 17);
INSERT INTO `aoa_role_power_list` VALUES (1118, 0, 91, 18);
INSERT INTO `aoa_role_power_list` VALUES (1119, 0, 91, 19);
INSERT INTO `aoa_role_power_list` VALUES (1120, 1, 92, 1);
INSERT INTO `aoa_role_power_list` VALUES (1121, 0, 92, 2);
INSERT INTO `aoa_role_power_list` VALUES (1122, 0, 92, 3);
INSERT INTO `aoa_role_power_list` VALUES (1123, 0, 92, 4);
INSERT INTO `aoa_role_power_list` VALUES (1124, 0, 92, 5);
INSERT INTO `aoa_role_power_list` VALUES (1125, 0, 92, 6);
INSERT INTO `aoa_role_power_list` VALUES (1126, 0, 92, 7);
INSERT INTO `aoa_role_power_list` VALUES (1127, 0, 92, 8);
INSERT INTO `aoa_role_power_list` VALUES (1128, 0, 92, 9);
INSERT INTO `aoa_role_power_list` VALUES (1129, 0, 92, 10);
INSERT INTO `aoa_role_power_list` VALUES (1130, 0, 92, 11);
INSERT INTO `aoa_role_power_list` VALUES (1131, 0, 92, 12);
INSERT INTO `aoa_role_power_list` VALUES (1132, 0, 92, 13);
INSERT INTO `aoa_role_power_list` VALUES (1133, 0, 92, 14);
INSERT INTO `aoa_role_power_list` VALUES (1134, 0, 92, 15);
INSERT INTO `aoa_role_power_list` VALUES (1135, 0, 92, 16);
INSERT INTO `aoa_role_power_list` VALUES (1136, 0, 92, 17);
INSERT INTO `aoa_role_power_list` VALUES (1137, 0, 92, 18);
INSERT INTO `aoa_role_power_list` VALUES (1138, 0, 92, 19);
COMMIT;

-- ----------------------------
-- Table structure for aoa_schedule_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_schedule_list`;
CREATE TABLE `aoa_schedule_list` (
  `rc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程ID',
  `create_time` datetime DEFAULT NULL COMMENT '发布时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `filedescribe` varchar(255) DEFAULT NULL,
  `is_remind` int(11) DEFAULT NULL COMMENT '是否提醒',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态ID',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '日程标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '日程所属人',
  `miaoshu` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '日程描述',
  `isreminded` int(11) DEFAULT NULL,
  PRIMARY KEY (`rc_id`),
  KEY `FKgcip21xf5ihmgm2bnh5o4jv15` (`user_id`),
  CONSTRAINT `FKgcip21xf5ihmgm2bnh5o4jv15` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_schedule_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_schedule_list` VALUES (1, '2017-10-18 17:35:16', '2017-10-19 11:09:11', '问请问', 0, '2017-10-04 11:09:06', 27, 'qwew', 44, 1, '请问请问', 0);
INSERT INTO `aoa_schedule_list` VALUES (2, '2017-10-17 11:09:15', '2017-11-18 11:09:11', '方法都是', 1, '2017-10-05 11:09:06', 28, '问问去', 44, 1, '大撒大撒', 0);
INSERT INTO `aoa_schedule_list` VALUES (3, '2017-10-17 11:09:15', '2017-10-29 11:09:11', '撒打算', 1, '2017-10-11 11:09:06', 29, '请问请问', 45, 1, '阿斯顿', 0);
INSERT INTO `aoa_schedule_list` VALUES (5, '2017-10-18 16:50:28', '2017-10-20 00:00:00', NULL, 0, '2017-10-18 00:00:00', 27, 'Z现在', 44, 1, '啊实打实的', 0);
INSERT INTO `aoa_schedule_list` VALUES (6, '2017-10-18 16:53:33', '2017-10-25 00:00:00', NULL, 1, '2017-10-18 00:00:00', 29, '测试', 45, 1, '啊实打实的撒', 0);
INSERT INTO `aoa_schedule_list` VALUES (7, '2017-10-18 16:55:23', '2017-10-26 00:00:00', NULL, 0, '2017-10-18 00:00:00', 27, '啊实打实的撒', 44, 1, '啊实打实大苏打撒', 0);
INSERT INTO `aoa_schedule_list` VALUES (8, '2017-10-18 16:58:05', '2017-10-20 00:00:00', NULL, 0, '2017-10-18 00:00:00', 27, 'sa撒打算', 44, 1, '撒大苏打撒', 0);
INSERT INTO `aoa_schedule_list` VALUES (13, '2019-11-21 16:35:02', '2019-11-22 16:34:11', '描述：日程1', 1, '2019-11-21 16:34:11', 27, '标题：日程1', 44, 5, '描述：日程1', 0);
INSERT INTO `aoa_schedule_list` VALUES (14, '2019-11-21 16:42:30', '2019-11-23 16:41:55', '描述：日程2', 1, '2019-11-21 16:41:55', 28, '标题：日程2', 44, 5, '描述：日程2', 0);
INSERT INTO `aoa_schedule_list` VALUES (15, '2019-11-21 20:57:15', '2019-11-23 16:47:43', '描述：日程3', 1, '2019-11-21 16:47:43', 27, '标题：日程3', 45, 5, '描述：日程3', 0);
INSERT INTO `aoa_schedule_list` VALUES (16, '2019-11-21 17:08:51', '2019-11-22 17:08:05', '描述：日程4', 1, '2019-11-21 17:08:05', 27, '标题：日程4', 44, 5, '描述：日程4', 0);
INSERT INTO `aoa_schedule_list` VALUES (17, '2019-11-21 17:28:22', '2019-11-25 17:27:44', '描述：日程5', 1, '2019-11-21 17:27:44', 27, '标题：日程5', 44, 5, '描述：日程5', 0);
INSERT INTO `aoa_schedule_list` VALUES (18, '2019-11-21 17:59:34', '2019-11-25 17:27:44', '描述：日程5-1', 1, '2019-11-21 17:27:44', 27, '标题：日程5-1', 44, 5, '描述：日程5-1', 0);
INSERT INTO `aoa_schedule_list` VALUES (19, '2019-11-21 17:47:22', '2019-11-27 17:27:44', '描述：日程5-3', 0, '2019-11-21 17:27:44', 28, '标题：日程5-3', 45, 5, '描述：日程5-3', 0);
INSERT INTO `aoa_schedule_list` VALUES (20, '2019-11-21 18:14:29', '2019-11-29 18:12:57', '描述：我的日程1', 1, '2019-11-21 18:12:57', 28, '标题：我的日程1', 44, 5, '描述：我的日程1', 0);
INSERT INTO `aoa_schedule_list` VALUES (21, '2019-11-21 21:52:18', '2019-11-23 21:51:01', '描述：假日休息1', 1, '2019-11-21 21:51:01', 28, '标题：假日休息1', 45, 5, '描述：假日休息1', 0);
INSERT INTO `aoa_schedule_list` VALUES (22, '2019-11-21 21:58:43', '2019-11-29 21:57:53', '描述：假日1', 1, '2019-11-21 21:57:53', 28, '标题： 假日1', 45, 5, '描述：假日1', 0);
INSERT INTO `aoa_schedule_list` VALUES (23, '2019-11-21 22:02:36', '2019-11-27 22:02:05', '描述：日程11', 1, '2019-11-21 22:02:05', 27, '标题：日程11', 44, 5, '描述：日程11', 0);
INSERT INTO `aoa_schedule_list` VALUES (24, '2019-11-21 22:11:50', '2019-11-25 22:10:33', '描述：假日1', 1, '2019-11-21 22:10:33', 28, '标题：假日1', 45, 5, '描述：假日1', 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_schedule_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_schedule_user`;
CREATE TABLE `aoa_schedule_user` (
  `rc_id` bigint(20) NOT NULL COMMENT '日程管理表ID',
  `user_id` bigint(20) NOT NULL COMMENT '关联用户id',
  `sche_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程用户管理表id',
  PRIMARY KEY (`sche_user_id`),
  KEY `FKh6hw8vp7p2lgfovi0o7bhhlyp` (`user_id`),
  KEY `FKcmd578ftbv7i53l6mxbbva137` (`rc_id`),
  CONSTRAINT `FKcmd578ftbv7i53l6mxbbva137` FOREIGN KEY (`rc_id`) REFERENCES `aoa_schedule_list` (`rc_id`),
  CONSTRAINT `FKh6hw8vp7p2lgfovi0o7bhhlyp` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_schedule_user
-- ----------------------------
BEGIN;
INSERT INTO `aoa_schedule_user` VALUES (16, 3, 2);
INSERT INTO `aoa_schedule_user` VALUES (16, 4, 3);
INSERT INTO `aoa_schedule_user` VALUES (17, 3, 4);
INSERT INTO `aoa_schedule_user` VALUES (17, 4, 5);
INSERT INTO `aoa_schedule_user` VALUES (19, 1, 8);
INSERT INTO `aoa_schedule_user` VALUES (19, 2, 9);
INSERT INTO `aoa_schedule_user` VALUES (18, 3, 10);
INSERT INTO `aoa_schedule_user` VALUES (18, 4, 11);
INSERT INTO `aoa_schedule_user` VALUES (15, 3, 12);
INSERT INTO `aoa_schedule_user` VALUES (15, 4, 13);
INSERT INTO `aoa_schedule_user` VALUES (24, 3, 14);
INSERT INTO `aoa_schedule_user` VALUES (24, 4, 15);
COMMIT;

-- ----------------------------
-- Table structure for aoa_status_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_status_list`;
CREATE TABLE `aoa_status_list` (
  `status_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '状态表ID',
  `status_color` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态颜色(前端 class属性名）',
  `status_model` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态模型',
  `status_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态名',
  `sort_value` int(11) DEFAULT NULL COMMENT '状态排序值',
  `sort_precent` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态百分比',
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_status_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_status_list` VALUES (1, 'label-success', 'aoa_mailnumber', '有效', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (2, 'label-default', 'aoa_mailnumber', '无效', 1, NULL);
INSERT INTO `aoa_status_list` VALUES (3, 'label-warning', 'aoa_task_list', '新任务', 0, '20%');
INSERT INTO `aoa_status_list` VALUES (4, 'label-info', 'aoa_task_list', '已接收', 1, '40%');
INSERT INTO `aoa_status_list` VALUES (5, 'label-primary', 'aoa_task_list', '进行中', 2, '60%');
INSERT INTO `aoa_status_list` VALUES (6, 'label-danger', 'aoa_task_list', '已提交', 3, '80%');
INSERT INTO `aoa_status_list` VALUES (7, 'label-success', 'aoa_task_list', '已完成', 4, '100%');
INSERT INTO `aoa_status_list` VALUES (8, 'label-info', 'aoa_note_list', '一般', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (9, 'label-danger', 'aoa_note_list', '重要', 1, NULL);
INSERT INTO `aoa_status_list` VALUES (10, 'label-info', 'aoa_attends_list', '正常', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (11, 'label-warning', 'aoa_attends_list', '迟到', 1, NULL);
INSERT INTO `aoa_status_list` VALUES (12, 'label-danger', 'aoa_attends_list', '早退', 2, NULL);
INSERT INTO `aoa_status_list` VALUES (13, 'label-danger', 'a', '旷工', 3, NULL);
INSERT INTO `aoa_status_list` VALUES (14, 'label-primary', 'inform', '一般', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (15, 'label-warning', 'inform', '重要', 1, '');
INSERT INTO `aoa_status_list` VALUES (16, 'label-danger', 'inform', '紧急', 2, NULL);
INSERT INTO `aoa_status_list` VALUES (17, 'label-warning', 'aoa_plan_list', '未完成', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (18, 'label-success', 'aoa_plan_list', '已完成', 1, NULL);
INSERT INTO `aoa_status_list` VALUES (19, 'label-info', 'aoa_plan_list', '已取消', 2, NULL);
INSERT INTO `aoa_status_list` VALUES (20, 'label-primary', 'aoa_in_mail_list', ' 一般', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (21, 'label-warning', 'aoa_in_mail_list', '重要', 1, NULL);
INSERT INTO `aoa_status_list` VALUES (22, 'label-danger', 'aoa_in_mail_list', '紧急', 2, NULL);
INSERT INTO `aoa_status_list` VALUES (23, 'label-info', 'aoa_process_list', '未处理', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (24, 'label-primary', 'aoa_process_list', '处理中', 1, NULL);
INSERT INTO `aoa_status_list` VALUES (25, 'label-success', 'aoa_process_list', '已批准', 2, NULL);
INSERT INTO `aoa_status_list` VALUES (26, 'label-danger', 'aoa_process_list', '未通过', 3, NULL);
INSERT INTO `aoa_status_list` VALUES (27, 'label-primary', 'aoa_schedule_list', '一般', 0, NULL);
INSERT INTO `aoa_status_list` VALUES (28, 'label-warning', 'aoa_schedule_list', '重要', 1, NULL);
INSERT INTO `aoa_status_list` VALUES (29, 'label-danger', 'aoa_schedule_list', '紧急', 2, NULL);
INSERT INTO `aoa_status_list` VALUES (30, 'red1', 'qqqqq', '好的拉', 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for aoa_stay
-- ----------------------------
DROP TABLE IF EXISTS `aoa_stay`;
CREATE TABLE `aoa_stay` (
  `stay_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '住宿申请表ID',
  `day` int(11) DEFAULT NULL COMMENT '入驻天数',
  `hotel_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '入驻酒店',
  `leave_time` datetime DEFAULT NULL COMMENT '离开酒店时间',
  `stay_city` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '入驻城市',
  `stay_money` double DEFAULT NULL COMMENT '住宿标准',
  `stay_time` datetime DEFAULT NULL COMMENT '住宿开始时间',
  `evemoney_id` bigint(20) DEFAULT NULL COMMENT '出差费用表ID',
  `user_name` bigint(20) DEFAULT NULL COMMENT '住宿人员ID',
  PRIMARY KEY (`stay_id`),
  KEY `FK50vbdodv3kd8dixbmyf9ixyc` (`evemoney_id`),
  KEY `FKho0k9o03kbn6dd96l57xvcx3y` (`user_name`),
  CONSTRAINT `FK50vbdodv3kd8dixbmyf9ixyc` FOREIGN KEY (`evemoney_id`) REFERENCES `aoa_evectionmoney` (`evectionmoney_id`),
  CONSTRAINT `FKho0k9o03kbn6dd96l57xvcx3y` FOREIGN KEY (`user_name`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_stay
-- ----------------------------
BEGIN;
INSERT INTO `aoa_stay` VALUES (14, 4, '小橘子', '2019-11-14 18:10:46', '西安', 200, '2019-11-10 18:10:46', 11, 1);
INSERT INTO `aoa_stay` VALUES (15, 3, '天天', '2019-11-14 18:12:26', '上海', 300, '2019-11-11 18:12:26', 11, 2);
COMMIT;

-- ----------------------------
-- Table structure for aoa_subject
-- ----------------------------
DROP TABLE IF EXISTS `aoa_subject`;
CREATE TABLE `aoa_subject` (
  `subject_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_subject
-- ----------------------------
BEGIN;
INSERT INTO `aoa_subject` VALUES (1, '报销科目', 0);
INSERT INTO `aoa_subject` VALUES (2, '办公室费用', 1);
INSERT INTO `aoa_subject` VALUES (3, '第三方采购费', 1);
INSERT INTO `aoa_subject` VALUES (4, '管理费用', 1);
INSERT INTO `aoa_subject` VALUES (5, '投标保证金', 1);
INSERT INTO `aoa_subject` VALUES (6, '销售费用', 1);
INSERT INTO `aoa_subject` VALUES (7, '预付款', 1);
INSERT INTO `aoa_subject` VALUES (9, '差旅费', 2);
INSERT INTO `aoa_subject` VALUES (10, '采购费', 3);
INSERT INTO `aoa_subject` VALUES (11, '外包费用', 3);
INSERT INTO `aoa_subject` VALUES (12, '外包服务费', 3);
INSERT INTO `aoa_subject` VALUES (13, '房租', 4);
INSERT INTO `aoa_subject` VALUES (14, '工资', 4);
INSERT INTO `aoa_subject` VALUES (15, '公积金', 4);
INSERT INTO `aoa_subject` VALUES (16, '固定电话费', 4);
INSERT INTO `aoa_subject` VALUES (17, '社保金', 4);
INSERT INTO `aoa_subject` VALUES (18, '水费', 4);
INSERT INTO `aoa_subject` VALUES (19, '印刷费', 4);
INSERT INTO `aoa_subject` VALUES (20, '电费', 4);
INSERT INTO `aoa_subject` VALUES (21, '投标保证金', 5);
INSERT INTO `aoa_subject` VALUES (22, '车辆油费', 6);
INSERT INTO `aoa_subject` VALUES (23, '市场推广费', 6);
INSERT INTO `aoa_subject` VALUES (24, '市内交通费', 6);
INSERT INTO `aoa_subject` VALUES (25, '招待费', 6);
INSERT INTO `aoa_subject` VALUES (26, '预付款', 7);
COMMIT;

-- ----------------------------
-- Table structure for aoa_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `aoa_sys_menu`;
CREATE TABLE `aoa_sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `is_show` int(11) DEFAULT NULL COMMENT '菜单是否显示',
  `menu_grade` int(11) DEFAULT NULL COMMENT '权限值分数',
  `menu_icon` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '菜单图标',
  `menu_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '菜单名',
  `menu_url` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '菜单链接',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `sort_id` int(11) DEFAULT NULL COMMENT '菜单排序ID',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `aoa_sys_menu` VALUES (1, 1, NULL, 'glyphicon-cog', '系统管理', '##', 0, 1);
INSERT INTO `aoa_sys_menu` VALUES (2, 1, NULL, 'glyphicon-education', '用户管理', '#', 0, 2);
INSERT INTO `aoa_sys_menu` VALUES (3, 1, NULL, 'glyphicon-user', '角色列表', '#', 0, 3);
INSERT INTO `aoa_sys_menu` VALUES (4, 1, NULL, 'glyphicon-time', '考勤管理', '#', 0, 4);
INSERT INTO `aoa_sys_menu` VALUES (5, 1, NULL, 'glyphicon-hourglass', '流程管理', '#', 0, 5);
INSERT INTO `aoa_sys_menu` VALUES (6, 1, NULL, 'glyphicon-bell', '公告管理', '#', 0, 6);
INSERT INTO `aoa_sys_menu` VALUES (7, 1, NULL, 'glyphicon-envelope', '邮件管理', '#', 0, 7);
INSERT INTO `aoa_sys_menu` VALUES (8, 1, NULL, 'glyphicon-flag', '任务管理', '#', 0, 8);
INSERT INTO `aoa_sys_menu` VALUES (9, 1, NULL, 'glyphicon-calendar', '日程管理', '#', 0, 9);
INSERT INTO `aoa_sys_menu` VALUES (10, 1, NULL, 'glyphicon-plane', '工作计划', '#', 0, 10);
INSERT INTO `aoa_sys_menu` VALUES (11, 1, NULL, 'glyphicon-folder-open', '文件管理', '#', 0, 11);
INSERT INTO `aoa_sys_menu` VALUES (12, 1, NULL, 'glyphicon-edit', '笔记管理', '#', 0, 12);
INSERT INTO `aoa_sys_menu` VALUES (13, 1, NULL, 'glyphicon-comment', '讨论区', '#', 0, 14);
INSERT INTO `aoa_sys_menu` VALUES (14, 1, NULL, 'glyphicon-record', '菜单管理', '/testsysmenu', 1, 1);
INSERT INTO `aoa_sys_menu` VALUES (15, 1, NULL, 'glyphicon-record', '类型管理', '/testsystype', 1, 2);
INSERT INTO `aoa_sys_menu` VALUES (16, 1, NULL, 'glyphicon-record', '状态管理', '/testsysstatus', 1, 3);
INSERT INTO `aoa_sys_menu` VALUES (17, 1, NULL, 'glyphicon-record', '部门管理', '/deptmanage', 2, 1);
INSERT INTO `aoa_sys_menu` VALUES (18, 1, NULL, 'glyphicon-record', '职位管理', '/positionmanage', 2, 3);
INSERT INTO `aoa_sys_menu` VALUES (19, 1, NULL, 'glyphicon-record', '用户管理', '/usermanage', 2, 4);
INSERT INTO `aoa_sys_menu` VALUES (20, 1, NULL, 'glyphicon-record', '在线用户', '/morelogrecord', 2, 2);
INSERT INTO `aoa_sys_menu` VALUES (21, 1, NULL, 'glyphicon-record', '角色列表', '/rolemanage', 3, 1);
INSERT INTO `aoa_sys_menu` VALUES (22, 1, NULL, 'glyphicon-record', '考勤管理', '/attendceatt', 4, 1);
INSERT INTO `aoa_sys_menu` VALUES (23, 1, NULL, 'glyphicon-record', '考勤周报表', '/attendceweek', 4, 2);
INSERT INTO `aoa_sys_menu` VALUES (24, 1, NULL, 'glyphicon-record', '考勤月报表', '/attendcemonth', 4, 3);
INSERT INTO `aoa_sys_menu` VALUES (25, 1, NULL, 'glyphicon-record', '我的申请', '/flowmanage', 5, 1);
INSERT INTO `aoa_sys_menu` VALUES (26, 1, NULL, 'glyphicon-record', '流程审核', '/audit', 5, 2);
INSERT INTO `aoa_sys_menu` VALUES (27, 1, NULL, 'glyphicon-record', '通知管理', '/infrommanage', 6, 1);
INSERT INTO `aoa_sys_menu` VALUES (28, 1, NULL, 'glyphicon-record', '通知列表', '/infromlist', 6, 2);
INSERT INTO `aoa_sys_menu` VALUES (29, 1, NULL, 'glyphicon-record', '账号管理', '/accountmanage', 7, 1);
INSERT INTO `aoa_sys_menu` VALUES (30, 1, NULL, 'glyphicon-record', '邮件管理', '/mail', 7, 2);
INSERT INTO `aoa_sys_menu` VALUES (31, 1, NULL, 'glyphicon-record', '任务管理', '/taskmanage', 8, 1);
INSERT INTO `aoa_sys_menu` VALUES (32, 1, NULL, 'glyphicon-record', '我的任务', '/mytask', 8, 2);
INSERT INTO `aoa_sys_menu` VALUES (33, 1, NULL, 'glyphicon-record', '日程管理', '/daymanage', 9, 1);
INSERT INTO `aoa_sys_menu` VALUES (34, 1, NULL, 'glyphicon-record', '我的日历', '/daycalendar', 9, 2);
INSERT INTO `aoa_sys_menu` VALUES (35, 1, NULL, 'glyphicon-record', '计划管理', '/planview', 10, 1);
INSERT INTO `aoa_sys_menu` VALUES (36, 1, NULL, 'glyphicon-record', '计划报表', '/myplan', 10, 2);
INSERT INTO `aoa_sys_menu` VALUES (37, 1, NULL, 'glyphicon-record', '文件管理', '/filemanage', 11, 1);
INSERT INTO `aoa_sys_menu` VALUES (38, 1, NULL, 'glyphicon-record', '笔记管理', '/noteview', 12, 0);
INSERT INTO `aoa_sys_menu` VALUES (39, 1, NULL, 'glyphicon-earphone', '通讯录', '#', 0, 13);
INSERT INTO `aoa_sys_menu` VALUES (40, 1, NULL, 'glyphicon-record', '通讯录', '/addrmanage', 39, 1);
INSERT INTO `aoa_sys_menu` VALUES (41, 1, NULL, 'glyphicon-record', '我的管理', '/chatmanage', 13, 1);
INSERT INTO `aoa_sys_menu` VALUES (42, 1, NULL, 'glyphicon-record', '讨论区列表', '/chatlist', 13, 2);
INSERT INTO `aoa_sys_menu` VALUES (67, 1, NULL, 'glyphicon-record', '考勤列表', '/attendcelist', 4, 4);
INSERT INTO `aoa_sys_menu` VALUES (76, NULL, NULL, '21', '12', '21', NULL, NULL);
INSERT INTO `aoa_sys_menu` VALUES (77, 0, NULL, '额', '额', 'e', NULL, NULL);
INSERT INTO `aoa_sys_menu` VALUES (78, 0, NULL, '312', '31', '312', NULL, NULL);
INSERT INTO `aoa_sys_menu` VALUES (79, 0, NULL, '放大', '范德萨', '富士达', NULL, NULL);
INSERT INTO `aoa_sys_menu` VALUES (80, NULL, NULL, '富士达', '任务', '富士达', NULL, NULL);
INSERT INTO `aoa_sys_menu` VALUES (81, 1, NULL, '富士达', '任务', '富士达', NULL, NULL);
INSERT INTO `aoa_sys_menu` VALUES (82, 1, NULL, '21', '12', '21', NULL, NULL);
INSERT INTO `aoa_sys_menu` VALUES (86, 1, NULL, 'glyphicon-record', 'fds', 'fdsa', 999, 0);
INSERT INTO `aoa_sys_menu` VALUES (87, 1, NULL, 'glyphicon-record', '1', '1', 999, 0);
INSERT INTO `aoa_sys_menu` VALUES (88, 0, NULL, 'glyphicon-record', '1', '1', 999, 0);
INSERT INTO `aoa_sys_menu` VALUES (89, 1, NULL, 'glyphicon-record', '超级管理员', '/adminmanage', 13, 0);
INSERT INTO `aoa_sys_menu` VALUES (90, 1, NULL, 'glyphicon-record', '新建流程', '/xinxeng', 5, 0);
INSERT INTO `aoa_sys_menu` VALUES (91, 1, NULL, 'glyphicon-record', '职位管理', 'abcd', 999, 0);
INSERT INTO `aoa_sys_menu` VALUES (92, 1, NULL, 'glyphicon glyphicon-heart', '公共管理', 'abcd', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_task_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_task_list`;
CREATE TABLE `aoa_task_list` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务表ID',
  `comment` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务评价',
  `end_time` datetime DEFAULT NULL COMMENT '任务结束时间',
  `is_cancel` int(11) DEFAULT '0' COMMENT '是否取消任务',
  `is_top` int(11) DEFAULT '0' COMMENT '任务是否置顶',
  `modify_time` datetime DEFAULT NULL COMMENT '任务修改时间',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `star_time` datetime DEFAULT NULL COMMENT '任务开始时间',
  `status_id` int(11) DEFAULT NULL COMMENT '任务状态ID',
  `task_describe` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '任务描述',
  `ticking` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务结束后反馈',
  `title` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '任务主题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '任务类型ID',
  `task_push_user_id` bigint(20) DEFAULT NULL COMMENT '发布人ID',
  `reciverlist` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '接收人名',
  PRIMARY KEY (`task_id`),
  KEY `FK7qch0fh6s2y73dvngy1m87aw7` (`task_push_user_id`),
  CONSTRAINT `FK7qch0fh6s2y73dvngy1m87aw7` FOREIGN KEY (`task_push_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_task_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_task_list` VALUES (1, '无法把淘宝', '2017-09-10 00:00:00', 0, 0, NULL, '2017-09-18 18:39:01', '2017-09-09 00:00:00', 5, '入股', NULL, '24日', 3, 1, '罗密欧');
INSERT INTO `aoa_task_list` VALUES (13, '噁7ikea', '2017-09-26 00:00:00', 1, 1, NULL, '2017-09-18 18:41:48', '2017-09-13 00:00:00', 3, '6uj', NULL, '熱土啊u就', 3, 1, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (14, '', '2017-09-21 18:44:14', 0, 1, '2017-09-20 18:44:20', '2017-09-20 18:44:20', '2017-09-20 18:44:14', 7, '給我如果 ', NULL, '的v我如果1111', 3, 1, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (19, 'tttbthhry', '2017-09-21 13:49:33', 1, 0, '2017-09-20 13:49:37', '2017-09-20 13:49:37', '2017-09-20 13:49:33', 7, 'ergget', NULL, '啦啦啦啦绿绿绿绿绿', 3, 1, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (20, '1', '2017-09-30 00:00:00', 1, 1, NULL, '2017-09-16 15:54:10', '2017-09-16 00:00:00', 3, '1', NULL, '1', 3, 1, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (21, '31', '2017-09-14 00:00:00', 1, 1, '2017-10-16 09:22:58', '2017-10-16 09:22:58', '2017-09-13 00:00:00', 7, '312', NULL, '噼噼啪啪铺铺铺铺', 3, 1, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (26, '犯得上', '2017-09-12 00:00:00', 0, 1, NULL, '2017-09-18 18:42:59', '2017-09-07 00:00:00', 5, '富士達', NULL, '飛灑', 3, 1, '伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (27, '', '2017-09-21 13:33:36', 0, 0, '2017-09-20 13:33:47', '2017-09-20 13:33:47', '2017-09-20 13:33:36', 3, 'FDSA ', NULL, '的方法', 4, 1, '朱丽叶');
INSERT INTO `aoa_task_list` VALUES (30, '', '2017-09-21 13:27:51', 0, 1, '2017-09-20 13:27:56', '2017-09-20 13:27:56', '2017-09-20 13:27:51', 3, '多对多', NULL, '的', 4, 1, '朱丽叶');
INSERT INTO `aoa_task_list` VALUES (31, '', '2017-09-20 20:58:22', 0, 0, '2017-09-19 21:01:16', '2017-09-19 21:01:16', '2017-09-19 20:58:22', 3, '点点滴滴', NULL, '凄凄切切', 3, 1, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (32, '', '2017-09-24 12:48:55', 0, 1, '2017-09-23 12:49:28', '2017-09-23 12:49:28', '2017-09-23 12:48:55', 3, '少时诵诗书', NULL, '凄凄切切', 3, 4, 'soli;红之花');
INSERT INTO `aoa_task_list` VALUES (33, '', '2017-09-24 12:49:44', 0, 0, '2017-09-23 12:49:56', '2017-09-23 12:49:56', '2017-09-23 12:49:44', 3, '密密麻麻', NULL, '哈哈哈', 3, 4, '红之花');
INSERT INTO `aoa_task_list` VALUES (34, ' 烦死哒', '2017-09-26 12:13:03', 0, 1, '2017-10-16 09:34:02', '2017-10-16 09:34:02', '2017-09-25 12:13:03', 7, '烦死哒大多数', NULL, '范德萨类型', 3, 1, '朱丽叶');
INSERT INTO `aoa_task_list` VALUES (35, '', '2017-09-26 16:39:29', 0, 0, '2017-09-25 16:39:45', '2017-09-25 16:39:45', '2017-09-25 16:39:29', 3, '反反复复付', NULL, '男男女女女', 3, 1, '朱丽叶;伊丽莎白;小李父斯基');
INSERT INTO `aoa_task_list` VALUES (36, '', '2017-09-26 16:39:51', 0, 1, '2017-09-25 16:40:04', '2017-09-25 16:40:04', '2017-09-25 16:39:51', 3, '啦啦啦啦绿绿绿', NULL, '斤斤计较军军', 3, 1, '朱丽叶;伊丽莎白;小李父斯基');
INSERT INTO `aoa_task_list` VALUES (37, '', '2017-09-26 16:40:16', 0, 1, '2017-10-16 09:33:12', '2017-10-16 09:33:12', '2017-09-25 16:40:16', 7, '巴巴爸爸', NULL, '啦啦啦啦木木木木', 3, 1, '朱丽叶;伊丽莎白;小李父斯基');
INSERT INTO `aoa_task_list` VALUES (38, '123', '2017-10-04 19:14:10', 0, 1, '2017-10-16 09:33:52', '2017-10-16 09:33:52', '2017-10-03 19:14:10', 7, '231', NULL, '221', 3, 1, '伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (39, '', '2017-10-16 14:05:02', 0, 1, '2017-10-15 14:05:39', '2017-10-15 14:05:39', '2017-10-15 14:05:02', 3, 'he疼合同号', NULL, '的vzfbhtrhet', 3, 4, '甄嬛;无双');
INSERT INTO `aoa_task_list` VALUES (40, '地方撒', '2017-10-17 09:29:41', 0, 1, '2017-10-16 09:32:41', '2017-10-16 09:32:41', '2017-10-16 09:29:41', 5, '的说法', NULL, '发给', 3, 1, '朱丽叶');
INSERT INTO `aoa_task_list` VALUES (41, 'nicw', '2017-10-17 09:30:13', 0, 1, '2017-10-16 09:33:41', '2017-10-16 09:33:41', '2017-10-16 09:30:13', 7, '完成了', NULL, '哈哈', 3, 1, '朱丽叶');
INSERT INTO `aoa_task_list` VALUES (42, '', '2017-10-17 09:30:44', 0, 1, '2017-10-16 09:32:52', '2017-10-16 09:32:52', '2017-10-16 09:30:44', 5, '已经完成', NULL, '以完成', 3, 1, '朱丽叶');
INSERT INTO `aoa_task_list` VALUES (46, '', '2017-10-21 09:52:49', 0, 0, '2017-10-20 09:53:02', '2017-10-20 09:53:02', '2017-10-20 09:52:49', 7, 'ok', NULL, 'ok', 3, 6, '薛邵琴;光宇');
INSERT INTO `aoa_task_list` VALUES (47, '', '2017-10-21 09:53:11', 0, 0, '2017-10-20 09:53:51', '2017-10-20 09:53:51', '2017-10-20 09:53:11', 7, '月也彷徨', NULL, '如今灯下闲读', 3, 6, '光宇;朱茵');
INSERT INTO `aoa_task_list` VALUES (48, '', '2017-10-21 09:54:59', 0, 0, '2017-10-20 09:55:42', '2017-10-20 09:55:42', '2017-10-20 09:54:59', 7, '家乡月光', NULL, '难诉衷肠', 3, 4, '甄姬2;甄嬛');
INSERT INTO `aoa_task_list` VALUES (50, '有事吗', '2019-11-20 11:23:57', 0, 1, '2019-11-19 11:24:55', '2019-11-19 11:24:55', '2019-11-19 11:23:57', 3, '有事找你', NULL, '有事找你', 3, 5, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (51, '大煎饼', '2019-11-20 11:27:15', 1, 1, '2019-11-20 17:58:09', '2019-11-20 17:58:09', '2019-11-19 11:27:15', 3, '看AHS', NULL, '有事找你2', 4, 5, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (52, '号码5', '2019-11-20 11:31:34', 0, 1, '2019-11-19 16:27:33', '2019-11-19 16:27:33', '2019-11-19 11:31:34', 3, '有私事找你5', NULL, '有事找你5', 4, 5, '红之花;甄姬');
INSERT INTO `aoa_task_list` VALUES (53, '好的', '2019-11-21 17:28:10', 0, 1, '2019-11-19 17:29:03', '2019-11-19 17:29:03', '2019-11-19 17:28:10', 3, '有事找你6描述', NULL, '有事找你6', 3, 5, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (54, '啊啊啊', '2019-11-22 17:31:18', 0, 1, '2019-11-19 17:32:07', '2019-11-19 17:32:07', '2019-11-19 17:31:18', 5, '这次应该正确了吧', NULL, '有事找你7', 3, 5, '伊丽莎白;小李父斯基');
INSERT INTO `aoa_task_list` VALUES (55, '有时找你啊', '2019-11-22 20:32:48', 0, 1, '2019-11-19 20:33:35', '2019-11-19 20:33:35', '2019-11-19 20:32:48', 5, '有私事找你', NULL, '有事找你8', 4, 5, '朱丽叶;伊丽莎白');
INSERT INTO `aoa_task_list` VALUES (59, '有事找你完成', '2019-11-21 16:27:54', 0, 1, '2019-11-20 16:28:50', '2019-11-20 16:28:50', '2019-11-20 16:27:54', 7, '有事找你完成', NULL, '有事找你完成', 3, 3, '小李父斯基;soli');
INSERT INTO `aoa_task_list` VALUES (60, '有事找你完成2', '2019-11-21 16:29:38', 0, 1, '2019-11-20 16:30:10', '2019-11-20 16:30:10', '2019-11-20 16:29:38', 5, '有事找你完成2', NULL, '有事找你完成2', 3, 3, '小李父斯基;soli');
INSERT INTO `aoa_task_list` VALUES (62, '评价我有私事找你', '2019-11-21 17:48:30', 0, 1, '2019-11-20 17:49:18', '2019-11-20 17:49:18', '2019-11-20 17:48:30', 3, '描述我有私事找你', NULL, '我有私事找你', 3, 3, '小李父斯基;soli');
INSERT INTO `aoa_task_list` VALUES (63, '评价标题测试2', '2019-11-21 17:52:29', 0, 1, '2019-11-20 17:53:08', '2019-11-20 17:53:08', '2019-11-20 17:52:29', 4, '描述标题测试2', NULL, '标题测试2', 3, 5, '伊丽莎白;小李父斯基');
INSERT INTO `aoa_task_list` VALUES (64, '评价测试2', '2019-11-21 21:29:23', 0, 1, '2019-11-20 21:30:01', '2019-11-20 21:30:01', '2019-11-20 21:29:23', 3, '描述：测试2', NULL, '测试2', 3, 3, '小李父斯基;soli');
INSERT INTO `aoa_task_list` VALUES (65, '评价2', '2019-11-21 21:31:25', 0, 1, '2019-11-20 21:31:58', '2019-11-20 21:31:58', '2019-11-20 21:31:25', 3, '描述2', NULL, '测试2', 3, 3, '伊丽莎白;小李父斯基');
COMMIT;

-- ----------------------------
-- Table structure for aoa_task_logger
-- ----------------------------
DROP TABLE IF EXISTS `aoa_task_logger`;
CREATE TABLE `aoa_task_logger` (
  `logger_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id主键',
  `create_time` datetime DEFAULT NULL COMMENT '任务日志创建时间',
  `logger_ticking` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务日志反馈内容',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务id外键',
  `username` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务日志生成人',
  `logger_statusid` int(11) DEFAULT NULL COMMENT '状态id',
  PRIMARY KEY (`logger_id`),
  KEY `FK5gu0thq54i7ujc6cict009h4y` (`task_id`),
  CONSTRAINT `FK5gu0thq54i7ujc6cict009h4y` FOREIGN KEY (`task_id`) REFERENCES `aoa_task_list` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_task_logger
-- ----------------------------
BEGIN;
INSERT INTO `aoa_task_logger` VALUES (1, '2017-09-15 19:54:58', '土豪阅海万家无可', 19, '罗密欧', NULL);
INSERT INTO `aoa_task_logger` VALUES (3, '2017-09-15 21:17:31', 'heenrnm', 19, '罗密欧', 7);
INSERT INTO `aoa_task_logger` VALUES (4, '2017-09-15 21:19:13', 'ujw5ukj5wuk', 19, '罗密欧', 7);
INSERT INTO `aoa_task_logger` VALUES (5, '2017-09-15 21:22:34', 'yukd68kd6', 19, '罗密欧', 7);
INSERT INTO `aoa_task_logger` VALUES (6, '2017-09-15 21:23:19', 'fwrgqetbh', 19, '罗密欧', 7);
INSERT INTO `aoa_task_logger` VALUES (17, '2017-09-19 21:08:06', '点点滴滴', 14, '罗密欧', 5);
INSERT INTO `aoa_task_logger` VALUES (29, '2017-09-22 13:42:21', '立刻开口', 1, '罗密欧', 5);
INSERT INTO `aoa_task_logger` VALUES (30, '2017-10-15 14:04:36', '', 35, '小李父斯基', 4);
INSERT INTO `aoa_task_logger` VALUES (31, '2017-10-15 14:09:01', '', 39, '甄嬛', 4);
INSERT INTO `aoa_task_logger` VALUES (32, '2018-02-09 00:51:03', '', 34, '罗密欧', 7);
INSERT INTO `aoa_task_logger` VALUES (33, '2019-11-19 17:29:03', NULL, 53, 'soli', NULL);
INSERT INTO `aoa_task_logger` VALUES (34, '2019-11-19 17:32:07', NULL, 54, 'soli', 3);
INSERT INTO `aoa_task_logger` VALUES (35, '2019-11-19 18:40:55', '保证完成', 54, 'soli', 5);
INSERT INTO `aoa_task_logger` VALUES (36, '2019-11-19 19:39:14', '有意见2', 54, 'soli', NULL);
INSERT INTO `aoa_task_logger` VALUES (37, '2019-11-19 20:11:37', '有意见4', 54, 'soli', NULL);
INSERT INTO `aoa_task_logger` VALUES (38, '2019-11-19 20:16:41', '有意见5', 54, 'soli', 3);
INSERT INTO `aoa_task_logger` VALUES (39, '2019-11-19 20:18:00', '正在进行中', 54, 'soli', 5);
INSERT INTO `aoa_task_logger` VALUES (40, '2019-11-19 20:31:58', '有意见5', 54, 'soli', 5);
INSERT INTO `aoa_task_logger` VALUES (41, '2019-11-19 20:33:35', NULL, 55, 'soli', 5);
INSERT INTO `aoa_task_logger` VALUES (42, '2019-11-19 20:33:51', '可好吗', 55, 'soli', 5);
INSERT INTO `aoa_task_logger` VALUES (44, '2019-11-19 22:08:12', '正在完成', 26, '伊丽莎白', 5);
INSERT INTO `aoa_task_logger` VALUES (45, '2019-11-19 22:08:39', '完成了', 31, '伊丽莎白', 6);
INSERT INTO `aoa_task_logger` VALUES (46, '2019-11-20 11:05:25', '', 38, '伊丽莎白', 7);
INSERT INTO `aoa_task_logger` VALUES (47, '2019-11-20 16:28:50', NULL, 59, '伊丽莎白', 3);
INSERT INTO `aoa_task_logger` VALUES (48, '2019-11-20 16:29:34', '', 59, '伊丽莎白', 3);
INSERT INTO `aoa_task_logger` VALUES (49, '2019-11-20 16:30:10', NULL, 60, '伊丽莎白', 3);
INSERT INTO `aoa_task_logger` VALUES (50, '2019-11-20 16:35:10', '我接收任务了1', 59, 'soli', 4);
INSERT INTO `aoa_task_logger` VALUES (51, '2019-11-20 16:36:38', '要努力啦', 59, '伊丽莎白', 5);
INSERT INTO `aoa_task_logger` VALUES (52, '2019-11-20 16:38:52', '老大：完成了1', 59, 'soli', 6);
INSERT INTO `aoa_task_logger` VALUES (53, '2019-11-20 16:40:21', '恭喜你', 59, '伊丽莎白', 7);
INSERT INTO `aoa_task_logger` VALUES (58, '2019-11-20 17:49:18', NULL, 62, '伊丽莎白', 3);
INSERT INTO `aoa_task_logger` VALUES (59, '2019-11-20 17:49:54', '我收到啦，开干', 60, '伊丽莎白', 5);
INSERT INTO `aoa_task_logger` VALUES (61, '2019-11-20 17:53:08', NULL, 63, 'soli', 3);
INSERT INTO `aoa_task_logger` VALUES (62, '2019-11-20 17:56:25', '我接收啦', 63, '伊丽莎白', 4);
INSERT INTO `aoa_task_logger` VALUES (63, '2019-11-20 21:30:01', NULL, 64, '伊丽莎白', 3);
INSERT INTO `aoa_task_logger` VALUES (64, '2019-11-20 21:31:58', NULL, 65, '伊丽莎白', 3);
COMMIT;

-- ----------------------------
-- Table structure for aoa_task_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_task_user`;
CREATE TABLE `aoa_task_user` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `task_recive_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  KEY `FK2714kl5ywm5chya4dxte8c788` (`task_id`),
  KEY `FK654dfo0oouy3fk07fs7rqo4ld` (`task_recive_user_id`),
  CONSTRAINT `FK2714kl5ywm5chya4dxte8c788` FOREIGN KEY (`task_id`) REFERENCES `aoa_task_list` (`task_id`),
  CONSTRAINT `FK654dfo0oouy3fk07fs7rqo4ld` FOREIGN KEY (`task_recive_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_task_user
-- ----------------------------
BEGIN;
INSERT INTO `aoa_task_user` VALUES (1, 5, 1, 1);
INSERT INTO `aoa_task_user` VALUES (6, 7, 19, 2);
INSERT INTO `aoa_task_user` VALUES (8, 3, 20, 2);
INSERT INTO `aoa_task_user` VALUES (10, 7, 21, 2);
INSERT INTO `aoa_task_user` VALUES (24, 3, 13, 2);
INSERT INTO `aoa_task_user` VALUES (26, 7, 14, 2);
INSERT INTO `aoa_task_user` VALUES (29, 3, 27, 2);
INSERT INTO `aoa_task_user` VALUES (32, 3, 30, 2);
INSERT INTO `aoa_task_user` VALUES (33, 3, 31, 2);
INSERT INTO `aoa_task_user` VALUES (36, 3, 32, 5);
INSERT INTO `aoa_task_user` VALUES (37, 3, 32, 6);
INSERT INTO `aoa_task_user` VALUES (38, 3, 33, 6);
INSERT INTO `aoa_task_user` VALUES (39, 7, 34, 2);
INSERT INTO `aoa_task_user` VALUES (40, 3, 35, 2);
INSERT INTO `aoa_task_user` VALUES (41, 3, 35, 3);
INSERT INTO `aoa_task_user` VALUES (43, 3, 36, 2);
INSERT INTO `aoa_task_user` VALUES (46, 7, 37, 2);
INSERT INTO `aoa_task_user` VALUES (48, 7, 37, 4);
INSERT INTO `aoa_task_user` VALUES (50, 4, 39, 9);
INSERT INTO `aoa_task_user` VALUES (51, 3, 39, 10);
INSERT INTO `aoa_task_user` VALUES (52, 5, 40, 2);
INSERT INTO `aoa_task_user` VALUES (53, 7, 41, 2);
INSERT INTO `aoa_task_user` VALUES (54, 5, 42, 2);
INSERT INTO `aoa_task_user` VALUES (62, 7, 46, 17);
INSERT INTO `aoa_task_user` VALUES (63, 7, 46, 18);
INSERT INTO `aoa_task_user` VALUES (64, 7, 47, 18);
INSERT INTO `aoa_task_user` VALUES (65, 7, 47, 19);
INSERT INTO `aoa_task_user` VALUES (66, 7, 48, 8);
INSERT INTO `aoa_task_user` VALUES (67, 7, 48, 9);
INSERT INTO `aoa_task_user` VALUES (71, 3, 52, 6);
INSERT INTO `aoa_task_user` VALUES (72, 3, 52, 7);
INSERT INTO `aoa_task_user` VALUES (73, 3, 53, 2);
INSERT INTO `aoa_task_user` VALUES (74, 3, 53, 3);
INSERT INTO `aoa_task_user` VALUES (75, 5, 54, 3);
INSERT INTO `aoa_task_user` VALUES (76, 5, 54, 4);
INSERT INTO `aoa_task_user` VALUES (77, 5, 55, 2);
INSERT INTO `aoa_task_user` VALUES (85, 7, 59, 4);
INSERT INTO `aoa_task_user` VALUES (86, 7, 59, 5);
INSERT INTO `aoa_task_user` VALUES (87, 5, 60, 4);
INSERT INTO `aoa_task_user` VALUES (88, 5, 60, 5);
INSERT INTO `aoa_task_user` VALUES (91, 3, 62, 4);
INSERT INTO `aoa_task_user` VALUES (92, 3, 62, 5);
INSERT INTO `aoa_task_user` VALUES (93, 4, 63, 3);
INSERT INTO `aoa_task_user` VALUES (94, 4, 63, 4);
INSERT INTO `aoa_task_user` VALUES (95, 3, 51, 2);
INSERT INTO `aoa_task_user` VALUES (97, 3, 64, 4);
INSERT INTO `aoa_task_user` VALUES (98, 3, 64, 5);
INSERT INTO `aoa_task_user` VALUES (99, 3, 65, 3);
INSERT INTO `aoa_task_user` VALUES (100, 3, 65, 4);
COMMIT;

-- ----------------------------
-- Table structure for aoa_traffic
-- ----------------------------
DROP TABLE IF EXISTS `aoa_traffic`;
CREATE TABLE `aoa_traffic` (
  `traffic_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '交通费用明细表ID',
  `depart_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '出发城市',
  `depart_time` datetime DEFAULT NULL COMMENT '出发时间',
  `reach_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '到达城市',
  `seat_type` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '座位类型',
  `traffic_money` double DEFAULT NULL COMMENT '交通标准',
  `traffic_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '交通工具',
  `evemoney_id` bigint(20) DEFAULT NULL COMMENT '出差费用申请单ID',
  `user_name` bigint(20) DEFAULT NULL COMMENT '出差人员ID',
  PRIMARY KEY (`traffic_id`) USING BTREE,
  KEY `FKt5gk2fg5t802gnq8y03p9e7di` (`evemoney_id`),
  KEY `FKejkemcx58mfj2lgi2jo2rlih3` (`user_name`),
  CONSTRAINT `FKejkemcx58mfj2lgi2jo2rlih3` FOREIGN KEY (`user_name`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKt5gk2fg5t802gnq8y03p9e7di` FOREIGN KEY (`evemoney_id`) REFERENCES `aoa_evectionmoney` (`evectionmoney_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_traffic
-- ----------------------------
BEGIN;
INSERT INTO `aoa_traffic` VALUES (15, '北京', '2019-11-10 18:10:46', '西安', '卧铺', 500, '火车', 11, 2);
INSERT INTO `aoa_traffic` VALUES (16, '西安', '2019-11-11 18:11:56', '上海', '硬座', 1000, '飞机', 11, 1);
COMMIT;

-- ----------------------------
-- Table structure for aoa_type_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_type_list`;
CREATE TABLE `aoa_type_list` (
  `type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类型表ID',
  `type_color` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '类型进度颜色',
  `type_model` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '类型模块',
  `type_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '类型名',
  `sort_value` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_type_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_type_list` VALUES (1, 'red', 'aoa_mailnumber', '系统邮件', 0);
INSERT INTO `aoa_type_list` VALUES (2, 'red', 'aoa_mailnumber', '公司邮件', 1);
INSERT INTO `aoa_type_list` VALUES (3, 'red', 'aoa_task_list', '公事', 0);
INSERT INTO `aoa_type_list` VALUES (4, 'red', 'aoa_task_list', '私事', 1);
INSERT INTO `aoa_type_list` VALUES (5, 'red', 'aoa_note_list', '我的笔记', 0);
INSERT INTO `aoa_type_list` VALUES (6, 'red', 'aoa_note_list', '公司笔记', 1);
INSERT INTO `aoa_type_list` VALUES (7, 'red', 'aoa_note_list', '共享笔记', 2);
INSERT INTO `aoa_type_list` VALUES (8, 'red', 'aoa_attends_list', '上班', 1);
INSERT INTO `aoa_type_list` VALUES (9, 'red', 'aoa_attends_list', '下班', 2);
INSERT INTO `aoa_type_list` VALUES (10, 'red', 'inform', '公告', 0);
INSERT INTO `aoa_type_list` VALUES (11, 'red', 'inform', '通知', 1);
INSERT INTO `aoa_type_list` VALUES (12, 'red', 'inform', '投票', 2);
INSERT INTO `aoa_type_list` VALUES (13, 'red', 'aoa_plan_list', '日计划', 0);
INSERT INTO `aoa_type_list` VALUES (14, 'red', 'aoa_plan_list', '周计划', 1);
INSERT INTO `aoa_type_list` VALUES (15, 'red', 'aoa_plan_list', '月计划', 2);
INSERT INTO `aoa_type_list` VALUES (16, 'red', 'aoa_in_mail_list', '邮件', 0);
INSERT INTO `aoa_type_list` VALUES (17, 'red', 'aoa_in_mail_list', '通知', 1);
INSERT INTO `aoa_type_list` VALUES (18, 'red', 'aoa_in_mail_list', '公告', 2);
INSERT INTO `aoa_type_list` VALUES (19, 'label-danger', 'chat', '公告', 0);
INSERT INTO `aoa_type_list` VALUES (20, 'label-success', 'chat', '讨论', 1);
INSERT INTO `aoa_type_list` VALUES (21, 'label-warning', 'chat', '投票', 2);
INSERT INTO `aoa_type_list` VALUES (22, 'red', 'aoa_process_list', '正常', 0);
INSERT INTO `aoa_type_list` VALUES (23, 'red', 'aoa_process_list', '重要', 1);
INSERT INTO `aoa_type_list` VALUES (24, 'red', 'aoa_process_list', '紧急', 2);
INSERT INTO `aoa_type_list` VALUES (25, 'red', 'aoa_bursement', '银行卡', 0);
INSERT INTO `aoa_type_list` VALUES (26, 'red', 'aoa_bursement', '现金', 1);
INSERT INTO `aoa_type_list` VALUES (27, 'red', 'aoa_bursement', '其他', 2);
INSERT INTO `aoa_type_list` VALUES (28, 'red', 'aoa_evection', '销售拜访', 0);
INSERT INTO `aoa_type_list` VALUES (29, 'red', 'aoa_evection', '售前支持', 1);
INSERT INTO `aoa_type_list` VALUES (30, 'red', 'aoa_evection', '项目支持', 2);
INSERT INTO `aoa_type_list` VALUES (31, 'red', 'aoa_evection', '客服外出', 3);
INSERT INTO `aoa_type_list` VALUES (32, 'red', 'aoa_evection', '其他', 4);
INSERT INTO `aoa_type_list` VALUES (33, 'red', 'aoa_overtime', '工作日', 0);
INSERT INTO `aoa_type_list` VALUES (34, 'red', 'aoa_overtime', '休息日', 1);
INSERT INTO `aoa_type_list` VALUES (35, 'red', 'aoa_overtime', '节假日', 2);
INSERT INTO `aoa_type_list` VALUES (36, 'red', 'aoa_overtime', '其他', 3);
INSERT INTO `aoa_type_list` VALUES (37, '1、年假：工作满一年以上每年可享受带薪年假，当年的年假使用期至次年3月1日止；未经用人单位批准，员工不得自行休假。', 'aoa_holiday', '年假', 7);
INSERT INTO `aoa_type_list` VALUES (38, '2、事假：按照平均工作日扣发薪资（包含工资及各类补贴福利）；单次事假原则上不应超过3天，当年累计事假超过15天的视为主动放弃继续履行岗位职责的权利，特殊情况除外。  ', 'aoa_holiday', '事假', 4);
INSERT INTO `aoa_type_list` VALUES (39, '3、病假：两天及以上病假必须持工作地二级甲等以上医院相关病假证明单或就医记录证明，否则无法享受病假工资；单次病假超过5天，应当持有工作所在地三级甲等医院提供的病假证明单。原则上当年累计病假超过15天应视为不具备继续履行岗位职责身体条件，特殊情况除外。  ', 'aoa_holiday', '病假', 5);
INSERT INTO `aoa_type_list` VALUES (40, '4、婚假：婚假为十天，包含休息日，请婚假必须持结婚证明，结婚证必须在泛微工作期间领取，且婚假必须在一年内使用完毕，不得分次休假，国家或地方政府有其他规定的按照当地要求执行；  ', 'aoa_holiday', '婚假', 10);
INSERT INTO `aoa_type_list` VALUES (41, '5、产假及哺乳假：按国家及地方法律法规执行，包含休息日与法定节假日；  ', 'aoa_holiday', '产假及哺乳假', 180);
INSERT INTO `aoa_type_list` VALUES (42, '6、陪产假：泛微正式男性员工在工作期间配偶生育的，可凭子女出生证明，享受十个自然日陪产假。  ', 'aoa_holiday', '陪产假', 10);
INSERT INTO `aoa_type_list` VALUES (43, '7、丧假：直系亲属：配偶、子女、父母可享受三天，岳父母、祖父母、外祖父母可享受一天', 'aoa_holiday', '丧假', 10);
INSERT INTO `aoa_type_list` VALUES (44, '', 'aoa_schedule_list', '日程提醒', 0);
INSERT INTO `aoa_type_list` VALUES (45, '', 'aoa_schedule_list', '假日安排', 1);
INSERT INTO `aoa_type_list` VALUES (46, 'red', 'aoa_attends_list', '请假', 3);
INSERT INTO `aoa_type_list` VALUES (47, 'red', 'aoa_attends_list', '出差', 4);
INSERT INTO `aoa_type_list` VALUES (48, 'red', 'aaa', '商铺1', 0);
COMMIT;

-- ----------------------------
-- Table structure for aoa_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_user`;
CREATE TABLE `aoa_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表ID',
  `address` varchar(255) DEFAULT NULL COMMENT '用户的地址',
  `bank` varchar(255) DEFAULT NULL COMMENT '银行',
  `birth` datetime DEFAULT NULL COMMENT '生日',
  `eamil` varchar(255) DEFAULT NULL COMMENT '用户的邮箱',
  `father_id` bigint(20) DEFAULT NULL COMMENT '上司ID',
  `hire_time` datetime DEFAULT NULL COMMENT '入职时间',
  `user_idcard` varchar(255) DEFAULT NULL COMMENT '用户身份证',
  `img_path` varchar(255) DEFAULT NULL COMMENT '用户头像路径',
  `is_lock` int(11) DEFAULT NULL COMMENT '是否被禁用',
  `last_login_ip` varchar(255) DEFAULT NULL COMMENT '最后登录的IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录的时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改此用户的用户ID',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `real_name` varchar(255) DEFAULT NULL COMMENT '用户真实姓名',
  `salary` float(20,0) DEFAULT NULL COMMENT '用户薪水',
  `user_school` varchar(255) DEFAULT NULL COMMENT '用户的毕业院校',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `theme_skin` varchar(255) DEFAULT NULL COMMENT '主题皮肤',
  `user_edu` varchar(255) DEFAULT NULL COMMENT '用户的学历',
  `user_name` varchar(255) DEFAULT NULL COMMENT '登录的用户名',
  `user_sign` varchar(255) DEFAULT NULL COMMENT '用户签名',
  `user_tel` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门表ID',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位表ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色表ID',
  `superman` int(11) DEFAULT NULL COMMENT '超人1代表超人0普通人默认为0',
  `holiday` int(11) DEFAULT NULL COMMENT '请假天数',
  `pinyin` varchar(255) DEFAULT NULL COMMENT '登录用户名的拼音',
  PRIMARY KEY (`user_id`),
  KEY `FKt0vmot9xfbgq14oyij0gwh3gh` (`dept_id`),
  KEY `FKadtg9xju7q1ijcyxlkl9gwv5t` (`position_id`),
  KEY `FKl738mmblfx0uia6671rl17cj9` (`role_id`),
  CONSTRAINT `FKadtg9xju7q1ijcyxlkl9gwv5t` FOREIGN KEY (`position_id`) REFERENCES `aoa_position` (`position_id`),
  CONSTRAINT `FKl738mmblfx0uia6671rl17cj9` FOREIGN KEY (`role_id`) REFERENCES `aoa_role_` (`role_id`),
  CONSTRAINT `FKt0vmot9xfbgq14oyij0gwh3gh` FOREIGN KEY (`dept_id`) REFERENCES `aoa_dept` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_user
-- ----------------------------
BEGIN;
INSERT INTO `aoa_user` VALUES (1, '湖南工业大学', '62175555555555444', '1986-02-03 00:00:00', '1057@qq.com', 0, '2017-09-22 19:35:40', '510322198602030429', '/22974ba8-4f7f-4166-b026-1fafa8afd923.jpg', 1, NULL, NULL, NULL, NULL, '123456', '小明', 2000, '湖南工业大学', '男', 'blue', '本科', '罗密欧', '好好', '13272143450', 1, 3, 1, 1, NULL, 'luomiou');
INSERT INTO `aoa_user` VALUES (2, '中国广东', '6217002940101998752', '1994-03-28 00:00:00', 'aaluoxiang@foxmail.com', 28, '2008-03-06 00:00:00', '510322199403280426', 'handsome.JPG', 0, NULL, NULL, NULL, NULL, '123456', '小梅', 9000, '中南大学', '女', 'blue', '硕士', '朱丽叶', '天天向上', '13203318185', 1, 1, 2, 0, NULL, 'zhuliye');
INSERT INTO `aoa_user` VALUES (3, '中国广东', '6217002940101998752', '1995-03-05 00:00:00', '255@qq.com', 2, '2009-05-24 00:00:00', '510322199503052485', '/2b30233d-bf02-421e-b8f2-a02e63db91d8.jpg', 0, NULL, NULL, NULL, NULL, 'abc123', '芳芳', 1000, '湖南大学', '女', 'yellow', '硕士', '伊丽莎白', '好好学习04', '18683688154', 1, 2, 3, 0, NULL, 'yilishabai');
INSERT INTO `aoa_user` VALUES (4, '清华大学', '6666', '1994-09-19 16:52:11', '164@qq.com', 3, '2013-09-19 16:52:40', '432524199612188018', 'fiveman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '李明', 3000, '清华大学', '男', 'red', '硕士', '小李父斯基', '天天努力', '18173328888', 1, 1, 4, 0, NULL, 'xiaolifusiji');
INSERT INTO `aoa_user` VALUES (5, '中南大学', '7777', '1996-09-19 16:56:50', '173@126.com', 3, '2014-09-19 16:57:21', '432524199612188016', 'fourman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '小罗', 4000, '中南大学', '男', 'blue', '博士', 'soli', 'iinteresting', '666666', 3, 5, 4, 0, NULL, 'soli');
INSERT INTO `aoa_user` VALUES (6, '泰山西路', '9999', '1997-09-19 16:59:29', '188@qq.com', 3, '2014-09-19 17:00:21', '432524199712188019', 'nineman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '小红', 3700, '上海交大', '女', 'green', '本科', '红之花', '每天美一点', '18868688866', 4, 6, 4, 0, NULL, 'hongzhihua');
INSERT INTO `aoa_user` VALUES (7, '湖南工业大学', '6666', '2017-10-01 15:20:20', '188@qq.com', 3, '2017-10-05 15:20:39', '432524199712188020', 'oneman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '小喻', 5000, '湖南工业大学', '男', 'yellow', '本科', '甄姬', NULL, '13117336953', 5, 5, 4, 0, NULL, 'zhengji');
INSERT INTO `aoa_user` VALUES (8, '中国广东', '62175555555555444', '2017-10-04 15:20:20', '188@qq.com', 4, '2017-10-02 15:20:39', '432524199712188021', 'sevenman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '小费', 5000, '湖南工业大学', '女', 'red', '本科', '甄姬2', NULL, '13117336954', 3, 7, 5, 0, NULL, 'zhengji2');
INSERT INTO `aoa_user` VALUES (9, '中国广东', '5555444', '2017-10-03 14:23:10', '55@qq.com', 4, '2017-10-11 14:23:32', '432524199712188021', 'twoman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '小花', 3111, '湖南工业大学', '女', 'blue', '本科', '甄嬛', NULL, '13034507214', 2, 4, 5, 0, NULL, 'zhenghuan');
INSERT INTO `aoa_user` VALUES (10, '清华大学', '4444', '2017-10-18 14:26:17', '66@qq.com', 4, '2017-10-07 14:26:37', '432524199712188021', 'handsome.JPG', 0, NULL, NULL, NULL, NULL, '123456', '花红', 2555, '湖大', '女', 'green', '本科', '无双', NULL, '13117336954', 2, 3, 5, 0, NULL, 'wushuang');
INSERT INTO `aoa_user` VALUES (11, '中南大学', '6666', '2017-10-07 14:27:54', '1057@qq.com', 4, '2017-10-07 14:28:06', '5824566822688', 'threeman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '兰瑞', 5000, '中南', '男', 'yellow', '硕士', '瑞王', NULL, '13117336953', 2, 13, 5, 0, NULL, 'ruiwang');
INSERT INTO `aoa_user` VALUES (12, '泰山西路', '62175555555555444', '1986-02-03 00:00:00', 'aaluoxiang@foxmail.com', 4, '2014-09-19 16:57:21', '510322198602030429', 'fiveman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '雨果', 2000, '湖南工业大学', '男', 'red', '本科', '丹琪', NULL, '13117336953', 1, 2, 5, 0, NULL, 'danqi');
INSERT INTO `aoa_user` VALUES (13, '湖南工业大学', '12345', '1994-03-28 00:00:00', '255@qq.com', 4, '2014-09-19 17:00:21', '510322199403280426', 'fourman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '毛羽', 1000, '中南大学', '女', 'blue', '硕士', '于彤', NULL, '13117336954', 2, 15, 5, 0, NULL, 'yutong');
INSERT INTO `aoa_user` VALUES (14, '中国广东', '123478', '1995-03-05 00:00:00', '164@qq.com', 5, '2017-10-05 15:20:39', '510322199503052485', 'nineman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '黑椰', 1000, '湖南大学', '女', 'green', '硕士', '盛如思', NULL, '18868688866', 3, 21, 7, 0, NULL, 'shengrusi');
INSERT INTO `aoa_user` VALUES (15, '中国广东', '6666', '1994-09-19 16:52:11', '173@126.com', 5, '2017-10-02 15:20:39', '432524199612188018', 'oneman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '车寿山', 3000, '清华大学', '男', 'yellow', '硕士', '李楚堂', NULL, '13117336953', 3, 22, 7, 0, NULL, 'lichutang');
INSERT INTO `aoa_user` VALUES (16, '清华大学', '7777', '1996-09-19 16:56:50', '188@qq.com', 5, '2017-10-11 14:23:32', '432524199612188016', 'sevenman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '白秋生', 4000, '中南大学', '男', 'red', '博士', '支晓璇', NULL, '13117336954', 3, 23, 5, 0, NULL, 'zhixiaoxuan');
INSERT INTO `aoa_user` VALUES (17, '中南大学', '9999', '1997-09-19 16:59:29', '188@qq.com', 6, '2017-10-07 14:26:37', '432524199712188019', 'sixman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '饶子和', 3700, '上海交大', '女', 'blue', '本科', '薛邵琴', NULL, '13034507214', 4, 16, 5, 0, NULL, 'xueshanqin');
INSERT INTO `aoa_user` VALUES (18, '泰山西路', '6666', '2017-10-01 15:20:20', '188@qq.com', 6, '2017-10-07 14:28:06', '432524199712188020', 'handsome.JPG', 0, NULL, NULL, NULL, NULL, '123456', '王秋阳', 5000, '湖南工业大学', '男', 'green', '本科', '光宇', NULL, '13117336954', 4, 17, 5, 0, NULL, 'guangyu');
INSERT INTO `aoa_user` VALUES (19, '湖南工业大学', '62175555555555444', '2017-10-04 15:20:20', '55@qq.com', 6, '2014-09-19 16:57:21', '432524199712188021', '74c43897-d08b-409d-8b90-7fa3d681fef5.jpg', 0, NULL, NULL, NULL, NULL, '123456', '叶知秋', 5000, '湖南工业大学', '女', 'yellow', '本科', '朱茵', NULL, '13117336953', 4, 18, 5, 0, NULL, 'zhuyin');
INSERT INTO `aoa_user` VALUES (22, '清华大学', '新的', '2017-10-07 14:27:54', '1057@qq.com', 7, '2014-09-19 16:57:21', '5824566822688', 'nineman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '金燕西', 5000, '中南', '男', 'green', '硕士', '陈晓吉', NULL, '13117336953', 5, 8, 5, 0, NULL, 'chenxiaoji');
INSERT INTO `aoa_user` VALUES (23, '中南大学', '新的', '2017-10-07 14:27:54', 'aaluoxiang@foxmail.com', 7, '2014-09-19 16:57:21', '25852255', 'oneman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '修璃', 6000, '中南', '女', 'yellow', '博士', '刘恋', '', '13117336954', 5, 9, 5, 0, NULL, 'liulian');
INSERT INTO `aoa_user` VALUES (26, '清华大学', '7777', '1996-09-19 16:56:50', '188@qq.com', 5, '2017-10-11 14:23:32', '432524199612188016', 'sevenman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '张秋生', 4000, '中南大学', '男', 'red', '博士', '张秋生', NULL, '13117336954', 3, 3, 5, 0, NULL, 'zhangqiusheng');
INSERT INTO `aoa_user` VALUES (28, '中国广东', '55555', '2017-10-14 21:51:42', '55@qq.com', 4, '2017-10-14 21:52:15', '432524199712188021', 'fourman.jpeg', 0, NULL, NULL, NULL, NULL, '123456', '薛之谦', 222, '湖大', '男', 'blue', '硕士', '上上签', NULL, '18868688866', 1, 1, 6, 0, NULL, 'shangshangqian');
INSERT INTO `aoa_user` VALUES (35, 'wqasd', '6217002940101998752', '2017-10-16 00:00:00', 'qq@qq.com', NULL, '2017-10-16 00:00:00', '430602199501121115', NULL, 0, NULL, NULL, NULL, NULL, '123456', '总金办测试用户', 123213, 'asdas', '男', 'blue', 'qwewq', 'wuianan', NULL, '13600003532', 1, 2, 5, 0, NULL, NULL);
INSERT INTO `aoa_user` VALUES (51, NULL, '62175555555555444', NULL, '1057@qq.com', 3, '2019-10-23 00:00:00', NULL, NULL, 0, NULL, NULL, NULL, NULL, '123456', '小明88', 4000, NULL, '男', 'blue', '本科', '罗密欧2', NULL, '13272143450', 2, 11, 1, 0, NULL, 'luomiou2');
INSERT INTO `aoa_user` VALUES (52, NULL, '62175555555555444', NULL, '1057@qq.com', 28, '2019-10-23 00:00:00', NULL, NULL, 0, NULL, NULL, NULL, NULL, '123456', '小明00000', 20000, NULL, '男', 'blue', '本科', 'soli666', NULL, '13117336953', 1, 1, 1, 0, NULL, 'soli666');
INSERT INTO `aoa_user` VALUES (53, NULL, '62175555555555444', NULL, '1057@qq.com', 3, '2019-10-23 00:00:00', NULL, NULL, 1, NULL, NULL, NULL, NULL, '123456', '小明000', 2000, NULL, '男', 'blue', '本科', 'soli000', NULL, '13272143450', 1, 1, 1, 0, NULL, 'soli000');
COMMIT;

-- ----------------------------
-- Table structure for aoa_user_log
-- ----------------------------
DROP TABLE IF EXISTS `aoa_user_log`;
CREATE TABLE `aoa_user_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户登录记录表id',
  `ip_addr` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT 'IP地址',
  `log_time` datetime DEFAULT NULL COMMENT '日志记录时间',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '操作菜单名',
  `url` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '操作菜单url',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`log_id`),
  KEY `FKherb88q97dxbtcge09ii875qm` (`user_id`),
  CONSTRAINT `FKherb88q97dxbtcge09ii875qm` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6036 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_user_log
-- ----------------------------
BEGIN;
INSERT INTO `aoa_user_log` VALUES (3, '172.31.16.188', '2017-10-10 16:30:23', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (8, '172.31.16.188', '2017-10-10 16:42:37', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (9, '172.31.16.188', '2017-10-10 16:42:39', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (10, '172.31.16.188', '2017-10-10 16:42:47', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (11, '172.31.16.188', '2017-10-10 16:43:02', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (14, '172.31.16.188', '2017-10-10 16:47:11', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (15, '172.31.16.188', '2017-10-10 16:47:17', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (16, '172.31.16.188', '2017-10-10 16:47:51', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (17, '172.31.16.188', '2017-10-10 16:51:28', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (18, '172.31.16.188', '2017-10-10 16:51:50', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (19, '172.31.16.188', '2017-10-10 16:54:26', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (20, '172.31.16.188', '2017-10-10 16:54:28', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (21, '172.31.16.188', '2017-10-10 16:57:12', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (22, '172.31.16.188', '2017-10-10 16:57:14', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (23, '172.31.16.188', '2017-10-10 16:57:15', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (24, '192.168.43.91', '2017-10-10 17:51:24', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (25, '192.168.43.91', '2017-10-10 17:57:57', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (26, '192.168.43.91', '2017-10-10 17:59:44', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (27, '192.168.43.91', '2017-10-10 18:18:04', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (29, '192.168.43.91', '2017-10-10 21:09:55', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (30, '192.168.1.233', '2017-10-10 21:44:22', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (31, '192.168.1.233', '2017-10-10 21:44:33', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (32, '192.168.1.233', '2017-10-10 21:44:39', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (33, '192.168.1.233', '2017-10-10 21:44:43', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (34, '192.168.1.233', '2017-10-10 21:44:47', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (35, '192.168.1.233', '2017-10-10 21:45:43', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (36, '192.168.1.233', '2017-10-10 21:46:13', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (37, '192.168.1.233', '2017-10-10 21:46:15', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (38, '192.168.1.233', '2017-10-10 21:46:17', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (39, '192.168.1.233', '2017-10-10 21:46:19', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (40, '192.168.1.233', '2017-10-10 21:46:21', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (41, '192.168.1.233', '2017-10-10 21:46:23', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (42, '192.168.1.233', '2017-10-10 21:46:29', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (43, '192.168.1.233', '2017-10-10 21:46:56', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (44, '192.168.1.233', '2017-10-10 21:46:58', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (45, '192.168.1.233', '2017-10-10 21:47:00', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (46, '192.168.1.233', '2017-10-10 21:47:01', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (47, '192.168.1.233', '2017-10-10 21:47:03', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (48, '192.168.1.233', '2017-10-10 21:47:05', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (49, '192.168.1.233', '2017-10-10 21:47:07', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (60, '192.168.43.91', '2017-10-10 23:12:13', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (61, '192.168.43.91', '2017-10-10 23:12:23', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (62, '192.168.43.91', '2017-10-10 23:12:34', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (63, '192.168.43.91', '2017-10-10 23:13:12', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (65, '192.168.43.91', '2017-10-10 23:27:25', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (66, '192.168.43.91', '2017-10-10 23:27:27', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (67, '192.168.43.91', '2017-10-10 23:30:17', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (69, '192.168.43.91', '2017-10-10 23:34:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (70, '192.168.43.91', '2017-10-10 23:58:50', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (71, '192.168.43.91', '2017-10-10 23:58:52', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (72, '192.168.43.91', '2017-10-10 23:58:56', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (73, '192.168.43.91', '2017-10-10 23:58:57', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (74, '192.168.43.91', '2017-10-10 23:59:01', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (75, '192.168.43.91', '2017-10-11 00:00:03', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (76, '192.168.43.91', '2017-10-11 00:05:54', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (77, '192.168.43.91', '2017-10-11 00:07:06', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (78, '192.168.43.91', '2017-10-11 00:07:49', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (79, '192.168.43.91', '2017-10-11 00:11:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (80, '192.168.43.91', '2017-10-11 00:28:40', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (81, '192.168.43.91', '2017-10-11 00:28:50', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (82, '192.168.43.91', '2017-10-11 00:29:15', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (83, '192.168.43.91', '2017-10-11 00:29:16', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (84, '192.168.43.91', '2017-10-11 00:29:17', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (85, '192.168.43.91', '2017-10-11 00:30:11', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (86, '192.168.43.91', '2017-10-11 00:30:15', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (87, '192.168.43.91', '2017-10-11 00:30:18', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (88, '192.168.43.91', '2017-10-11 00:30:19', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (89, '192.168.43.91', '2017-10-11 00:31:36', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (90, '192.168.43.91', '2017-10-11 00:31:41', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (91, '172.20.10.2', '2017-10-11 00:46:50', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (92, '172.20.10.2', '2017-10-11 00:47:06', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (93, '172.20.10.2', '2017-10-11 00:47:11', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (94, '172.20.10.2', '2017-10-11 00:47:16', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (95, '172.20.10.2', '2017-10-11 00:47:27', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (96, '172.20.10.2', '2017-10-11 00:47:35', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (97, '172.20.10.2', '2017-10-11 00:47:49', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (98, '172.20.10.2', '2017-10-11 00:47:57', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (99, '172.20.10.2', '2017-10-11 00:48:08', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (100, '172.20.10.2', '2017-10-11 00:48:49', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (101, '172.20.10.2', '2017-10-11 00:48:54', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (102, '172.20.10.2', '2017-10-11 00:49:16', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (103, '172.27.198.122', '2017-10-11 10:13:13', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (104, '172.27.198.122', '2017-10-11 10:13:14', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (105, '172.27.198.122', '2017-10-11 10:13:17', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (106, '172.27.198.122', '2017-10-11 10:13:18', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (107, '172.27.198.122', '2017-10-11 10:13:19', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (108, '172.27.198.122', '2017-10-11 10:13:27', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (109, '172.27.198.122', '2017-10-11 10:13:28', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (110, '172.27.198.122', '2017-10-11 10:15:16', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (111, '172.27.198.122', '2017-10-11 10:15:16', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (112, '172.27.198.122', '2017-10-11 10:15:17', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (113, '172.27.198.122', '2017-10-11 10:15:18', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (114, '172.31.16.97', '2017-10-11 11:13:34', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (115, '172.31.16.97', '2017-10-11 11:13:51', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (116, '172.27.198.122', '2017-10-11 11:17:05', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (117, '192.168.43.91', '2017-10-11 12:13:52', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (118, '172.31.16.97', '2017-10-11 12:47:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (119, '172.31.16.97', '2017-10-11 12:48:01', '流程管理', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (120, '172.31.16.97', '2017-10-11 12:48:06', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (121, '172.31.16.97', '2017-10-11 12:48:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (122, '192.168.1.157', '2017-10-11 12:59:32', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (123, '192.168.1.157', '2017-10-11 12:59:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (124, '192.168.56.1', '2017-10-11 13:08:57', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (125, '192.168.1.157', '2017-10-11 13:54:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (126, '192.168.1.157', '2017-10-11 13:58:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (127, '192.168.1.235', '2017-10-11 14:02:33', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (128, '192.168.1.235', '2017-10-11 14:27:14', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (129, '192.168.1.235', '2017-10-11 14:29:04', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (130, '192.168.1.235', '2017-10-11 14:32:51', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (131, '192.168.1.235', '2017-10-11 14:34:05', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (132, '192.168.1.235', '2017-10-11 14:35:37', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (133, '192.168.1.235', '2017-10-11 14:37:36', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (134, '192.168.1.235', '2017-10-11 14:44:00', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (135, '192.168.1.235', '2017-10-11 14:44:38', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (136, '192.168.1.235', '2017-10-11 14:44:45', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (137, '192.168.56.1', '2017-10-11 15:21:13', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (138, '192.168.56.1', '2017-10-11 15:26:18', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (139, '192.168.56.1', '2017-10-11 15:27:24', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (140, '192.168.56.1', '2017-10-11 15:30:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (141, '192.168.1.235', '2017-10-11 15:42:32', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (142, '192.168.1.235', '2017-10-11 15:42:38', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (143, '192.168.1.235', '2017-10-11 15:42:55', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (144, '192.168.56.1', '2017-10-11 15:45:56', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (145, '192.168.1.235', '2017-10-11 15:50:21', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (146, '192.168.56.1', '2017-10-11 15:53:12', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (147, '192.168.56.1', '2017-10-11 15:53:33', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (148, '192.168.1.235', '2017-10-11 15:53:38', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (149, '192.168.56.1', '2017-10-11 15:53:41', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (150, '192.168.1.235', '2017-10-11 15:55:25', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (151, '192.168.1.235', '2017-10-11 15:58:21', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (152, '192.168.56.1', '2017-10-11 15:58:58', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (153, '192.168.56.1', '2017-10-11 16:00:23', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (154, '192.168.56.1', '2017-10-11 16:02:19', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (155, '192.168.1.235', '2017-10-11 16:02:52', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (156, '192.168.1.235', '2017-10-11 16:04:11', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (157, '192.168.56.1', '2017-10-11 16:09:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (158, '192.168.1.235', '2017-10-11 16:17:01', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (159, '172.27.198.122', '2017-10-11 16:20:05', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (160, '172.27.198.122', '2017-10-11 16:23:50', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (161, '172.27.198.122', '2017-10-11 16:25:38', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (162, '172.27.198.122', '2017-10-11 16:26:04', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (163, '172.27.198.122', '2017-10-11 16:26:32', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (164, '172.27.198.122', '2017-10-11 16:27:51', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (165, '172.27.198.122', '2017-10-11 16:30:24', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (166, '172.27.198.122', '2017-10-11 16:30:52', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (167, '172.27.198.122', '2017-10-11 16:34:38', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (168, '172.27.198.122', '2017-10-11 16:34:42', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (169, '172.27.198.122', '2017-10-11 16:35:21', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (170, '192.168.1.235', '2017-10-11 18:34:59', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (171, '192.168.1.235', '2017-10-11 18:35:17', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (172, '192.168.1.235', '2017-10-11 18:37:33', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (173, '192.168.1.235', '2017-10-11 18:37:58', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (174, '192.168.1.235', '2017-10-11 18:40:10', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (175, '192.168.1.157', '2017-10-11 18:59:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (176, '192.168.1.157', '2017-10-11 18:59:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (177, '192.168.1.157', '2017-10-11 18:59:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (178, '192.168.1.157', '2017-10-11 19:00:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (179, '192.168.1.157', '2017-10-11 19:01:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (180, '192.168.1.157', '2017-10-11 19:01:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (181, '192.168.1.157', '2017-10-11 19:01:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (182, '192.168.1.157', '2017-10-11 19:01:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (183, '192.168.1.157', '2017-10-11 19:01:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (184, '192.168.1.157', '2017-10-11 19:04:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (185, '192.168.1.157', '2017-10-11 19:09:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (186, '192.168.1.235', '2017-10-11 19:11:20', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (187, '192.168.1.235', '2017-10-11 19:11:28', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (188, '192.168.1.157', '2017-10-11 19:14:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (189, '192.168.1.157', '2017-10-11 19:14:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (190, '192.168.1.157', '2017-10-11 19:15:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (191, '192.168.1.157', '2017-10-11 19:15:24', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (192, '192.168.1.157', '2017-10-11 19:15:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (193, '192.168.1.157', '2017-10-11 19:15:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (194, '192.168.1.157', '2017-10-11 19:17:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (195, '192.168.1.157', '2017-10-11 19:17:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (196, '192.168.1.157', '2017-10-11 19:17:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (197, '192.168.1.157', '2017-10-11 19:18:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (198, '192.168.1.157', '2017-10-11 19:18:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (199, '192.168.1.157', '2017-10-11 19:19:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (200, '192.168.1.157', '2017-10-11 19:20:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (201, '192.168.1.157', '2017-10-11 19:20:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (202, '192.168.1.157', '2017-10-11 19:20:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (203, '192.168.1.157', '2017-10-11 19:21:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (204, '192.168.1.157', '2017-10-11 19:21:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (205, '192.168.1.157', '2017-10-11 19:21:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (206, '192.168.1.157', '2017-10-11 19:21:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (207, '192.168.1.157', '2017-10-11 19:23:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (208, '192.168.1.157', '2017-10-11 19:23:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (209, '192.168.1.157', '2017-10-11 19:24:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (210, '192.168.1.157', '2017-10-11 19:24:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (211, '192.168.1.157', '2017-10-11 19:24:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (212, '192.168.1.157', '2017-10-11 19:25:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (213, '192.168.1.235', '2017-10-11 19:27:30', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (214, '192.168.1.235', '2017-10-11 19:27:37', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (215, '192.168.1.235', '2017-10-11 19:29:02', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (216, '192.168.1.235', '2017-10-11 19:29:24', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (217, '192.168.1.157', '2017-10-11 19:31:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (218, '192.168.1.157', '2017-10-11 19:31:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (219, '192.168.1.157', '2017-10-11 19:32:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (220, '192.168.1.157', '2017-10-11 19:32:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (221, '192.168.1.157', '2017-10-11 19:32:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (222, '192.168.1.157', '2017-10-11 19:32:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (223, '192.168.1.157', '2017-10-11 19:32:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (224, '192.168.1.157', '2017-10-11 19:33:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (225, '192.168.1.157', '2017-10-11 19:35:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (226, '192.168.1.157', '2017-10-11 19:37:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (227, '192.168.1.157', '2017-10-11 19:37:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (228, '192.168.1.235', '2017-10-11 19:38:36', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (229, '192.168.1.157', '2017-10-11 19:39:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (230, '192.168.1.235', '2017-10-11 19:40:15', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (231, '192.168.1.157', '2017-10-11 19:40:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (232, '192.168.1.235', '2017-10-11 19:40:21', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (233, '192.168.1.235', '2017-10-11 19:40:32', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (234, '192.168.1.157', '2017-10-11 19:41:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (235, '192.168.1.235', '2017-10-11 19:42:08', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (236, '192.168.1.235', '2017-10-11 19:42:55', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (237, '192.168.1.235', '2017-10-11 19:43:20', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (238, '192.168.1.235', '2017-10-11 19:43:52', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (239, '192.168.1.157', '2017-10-11 19:45:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (240, '192.168.1.157', '2017-10-11 19:46:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (241, '192.168.1.157', '2017-10-11 19:46:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (242, '192.168.1.157', '2017-10-11 19:47:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (243, '192.168.1.235', '2017-10-11 19:48:50', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (244, '192.168.1.235', '2017-10-11 19:49:04', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (245, '192.168.1.235', '2017-10-11 19:49:16', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (246, '192.168.1.235', '2017-10-11 19:53:13', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (247, '192.168.1.157', '2017-10-11 19:54:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (248, '192.168.1.157', '2017-10-11 19:55:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (249, '192.168.1.157', '2017-10-11 19:56:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (250, '192.168.1.157', '2017-10-11 19:56:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (251, '192.168.1.157', '2017-10-11 19:59:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (252, '192.168.1.157', '2017-10-11 20:00:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (253, '192.168.1.157', '2017-10-11 20:00:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (254, '192.168.1.157', '2017-10-11 20:01:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (255, '192.168.1.157', '2017-10-11 20:03:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (256, '192.168.1.157', '2017-10-11 20:04:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (257, '192.168.1.157', '2017-10-11 20:04:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (258, '192.168.1.157', '2017-10-11 20:06:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (259, '192.168.1.157', '2017-10-11 20:06:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (260, '192.168.1.157', '2017-10-11 20:07:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (261, '192.168.1.157', '2017-10-11 20:08:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (262, '192.168.1.157', '2017-10-11 20:09:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (263, '192.168.1.157', '2017-10-11 20:13:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (264, '192.168.1.157', '2017-10-11 20:14:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (265, '192.168.1.157', '2017-10-11 20:14:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (266, '192.168.1.157', '2017-10-11 20:14:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (267, '192.168.1.157', '2017-10-11 20:14:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (268, '192.168.1.157', '2017-10-11 22:14:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (269, '192.168.56.1', '2017-10-11 22:14:33', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (270, '192.168.1.157', '2017-10-11 22:15:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (271, '192.168.56.1', '2017-10-11 22:15:04', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (272, '192.168.56.1', '2017-10-11 22:18:42', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (273, '192.168.56.1', '2017-10-11 22:19:29', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (274, '192.168.56.1', '2017-10-11 22:22:41', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (275, '192.168.56.1', '2017-10-11 22:23:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (276, '192.168.56.1', '2017-10-11 22:25:16', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (277, '192.168.56.1', '2017-10-11 22:25:30', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (278, '192.168.56.1', '2017-10-11 22:27:42', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (279, '192.168.56.1', '2017-10-11 22:28:05', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (280, '192.168.56.1', '2017-10-11 22:31:35', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (281, '192.168.56.1', '2017-10-11 22:31:51', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (282, '192.168.1.157', '2017-10-11 22:38:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (283, '192.168.56.1', '2017-10-11 22:40:06', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (284, '192.168.1.157', '2017-10-11 22:40:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (285, '192.168.56.1', '2017-10-11 22:40:27', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (286, '192.168.1.157', '2017-10-11 22:40:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (287, '192.168.1.157', '2017-10-11 22:41:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (288, '192.168.1.157', '2017-10-11 22:43:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (289, '192.168.1.157', '2017-10-11 22:44:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (290, '192.168.1.157', '2017-10-11 22:45:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (291, '192.168.1.157', '2017-10-11 22:45:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (292, '192.168.1.157', '2017-10-11 22:46:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (293, '192.168.1.157', '2017-10-11 22:46:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (294, '192.168.1.157', '2017-10-11 22:46:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (295, '192.168.1.157', '2017-10-11 22:47:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (296, '192.168.1.157', '2017-10-11 22:47:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (297, '192.168.1.157', '2017-10-11 22:47:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (298, '192.168.1.157', '2017-10-11 22:47:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (299, '192.168.1.157', '2017-10-11 22:48:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (300, '192.168.1.157', '2017-10-11 22:48:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (301, '192.168.1.157', '2017-10-11 22:48:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (302, '192.168.1.157', '2017-10-11 22:48:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (303, '192.168.1.157', '2017-10-11 22:48:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (304, '192.168.1.157', '2017-10-11 22:48:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (305, '192.168.1.157', '2017-10-11 22:50:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (306, '192.168.1.157', '2017-10-11 22:52:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (307, '192.168.1.157', '2017-10-11 22:55:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (308, '192.168.1.157', '2017-10-11 22:56:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (309, '192.168.1.157', '2017-10-11 22:56:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (310, '192.168.1.157', '2017-10-11 22:57:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (311, '192.168.1.157', '2017-10-11 22:57:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (312, '192.168.1.157', '2017-10-11 23:02:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (313, '192.168.1.157', '2017-10-11 23:02:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (314, '192.168.1.157', '2017-10-11 23:02:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (315, '192.168.1.235', '2017-10-12 10:00:34', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (316, '192.168.1.235', '2017-10-12 10:20:42', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (317, '192.168.1.235', '2017-10-12 10:20:43', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (318, '192.168.1.235', '2017-10-12 10:26:58', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (319, '192.168.1.235', '2017-10-12 10:27:02', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (320, '192.168.1.235', '2017-10-12 10:28:37', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (321, '192.168.1.235', '2017-10-12 10:28:39', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (322, '192.168.1.235', '2017-10-12 10:29:46', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (323, '192.168.1.235', '2017-10-12 10:40:27', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (324, '192.168.1.235', '2017-10-12 10:40:29', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (325, '192.168.1.157', '2017-10-12 10:45:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (326, '192.168.1.235', '2017-10-12 10:45:25', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (327, '192.168.1.235', '2017-10-12 10:45:26', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (328, '192.168.1.235', '2017-10-12 10:45:55', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (329, '192.168.1.235', '2017-10-12 10:46:47', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (330, '192.168.1.157', '2017-10-12 10:48:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (331, '192.168.1.235', '2017-10-12 10:55:50', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (332, '192.168.1.157', '2017-10-12 10:59:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (333, '192.168.1.157', '2017-10-12 10:59:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (334, '192.168.1.235', '2017-10-12 10:59:42', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (335, '192.168.1.157', '2017-10-12 11:00:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (336, '192.168.1.157', '2017-10-12 11:00:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (337, '192.168.1.157', '2017-10-12 11:00:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (338, '192.168.1.157', '2017-10-12 11:00:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (339, '192.168.1.157', '2017-10-12 11:00:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (340, '192.168.1.157', '2017-10-12 11:00:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (341, '192.168.1.235', '2017-10-12 11:00:31', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (342, '192.168.1.235', '2017-10-12 11:00:31', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (343, '192.168.1.235', '2017-10-12 11:00:31', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (344, '192.168.1.235', '2017-10-12 11:00:36', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (345, '192.168.1.235', '2017-10-12 11:00:39', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (346, '192.168.1.157', '2017-10-12 11:00:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (347, '192.168.1.157', '2017-10-12 11:00:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (348, '192.168.1.157', '2017-10-12 11:00:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (349, '192.168.1.157', '2017-10-12 11:00:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (350, '192.168.1.235', '2017-10-12 11:00:59', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (351, '192.168.1.235', '2017-10-12 11:00:59', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (352, '192.168.1.235', '2017-10-12 11:01:03', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (353, '192.168.1.235', '2017-10-12 11:01:04', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (354, '192.168.1.157', '2017-10-12 11:01:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (355, '192.168.1.157', '2017-10-12 11:01:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (356, '192.168.1.157', '2017-10-12 11:01:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (357, '192.168.1.157', '2017-10-12 11:01:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (358, '192.168.1.157', '2017-10-12 11:01:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (359, '192.168.1.157', '2017-10-12 11:01:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (360, '192.168.1.157', '2017-10-12 11:01:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (361, '192.168.1.157', '2017-10-12 11:01:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (362, '192.168.1.157', '2017-10-12 11:01:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (363, '192.168.1.157', '2017-10-12 11:01:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (364, '192.168.1.157', '2017-10-12 11:01:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (365, '192.168.1.157', '2017-10-12 11:01:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (366, '192.168.1.157', '2017-10-12 11:02:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (367, '192.168.1.157', '2017-10-12 11:02:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (368, '192.168.1.157', '2017-10-12 11:02:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (369, '192.168.1.157', '2017-10-12 11:02:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (370, '192.168.1.157', '2017-10-12 11:03:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (371, '192.168.1.157', '2017-10-12 11:03:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (372, '192.168.1.157', '2017-10-12 11:03:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (373, '192.168.1.157', '2017-10-12 11:03:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (374, '192.168.1.157', '2017-10-12 11:03:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (375, '192.168.1.157', '2017-10-12 11:03:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (376, '192.168.1.157', '2017-10-12 11:04:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (377, '192.168.1.157', '2017-10-12 11:04:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (378, '192.168.1.157', '2017-10-12 11:04:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (379, '192.168.1.157', '2017-10-12 11:04:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (380, '192.168.1.157', '2017-10-12 11:34:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (381, '192.168.1.157', '2017-10-12 12:31:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (382, '192.168.1.157', '2017-10-12 12:31:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (383, '192.168.1.157', '2017-10-12 12:35:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (384, '192.168.1.157', '2017-10-12 12:36:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (385, '192.168.1.157', '2017-10-12 12:38:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (386, '192.168.1.157', '2017-10-12 12:39:43', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (387, '192.168.1.157', '2017-10-12 12:39:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (388, '192.168.1.157', '2017-10-12 12:45:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (389, '192.168.1.157', '2017-10-12 12:45:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (390, '192.168.1.157', '2017-10-12 12:45:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (391, '192.168.1.157', '2017-10-12 12:46:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (392, '192.168.1.157', '2017-10-12 12:51:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (393, '192.168.1.157', '2017-10-12 12:51:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (394, '192.168.1.157', '2017-10-12 12:51:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (395, '192.168.1.157', '2017-10-12 12:51:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (396, '192.168.1.157', '2017-10-12 12:54:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (397, '192.168.1.157', '2017-10-12 12:55:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (398, '192.168.1.157', '2017-10-12 12:55:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (399, '192.168.56.1', '2017-10-12 12:56:24', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (400, '192.168.1.157', '2017-10-12 12:57:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (401, '192.168.56.1', '2017-10-12 12:58:26', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (402, '192.168.1.157', '2017-10-12 12:58:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (403, '192.168.56.1', '2017-10-12 12:59:35', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (404, '192.168.1.235', '2017-10-12 13:01:07', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (405, '192.168.56.1', '2017-10-12 13:15:27', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (406, '192.168.56.1', '2017-10-12 13:15:55', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (407, '192.168.1.157', '2017-10-12 13:27:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (408, '192.168.56.1', '2017-10-12 13:28:35', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (409, '192.168.1.157', '2017-10-12 13:28:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (410, '192.168.56.1', '2017-10-12 13:29:27', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (411, '192.168.1.157', '2017-10-12 13:29:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (412, '192.168.1.157', '2017-10-12 13:30:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (413, '192.168.56.1', '2017-10-12 13:30:42', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (414, '192.168.1.157', '2017-10-12 13:44:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (415, '192.168.1.157', '2017-10-12 13:48:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (416, '192.168.1.157', '2017-10-12 13:49:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (417, '192.168.1.157', '2017-10-12 13:50:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (418, '192.168.1.157', '2017-10-12 13:50:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (419, '192.168.1.157', '2017-10-12 13:52:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (420, '192.168.1.157', '2017-10-12 13:53:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (421, '192.168.1.157', '2017-10-12 13:53:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (422, '192.168.1.157', '2017-10-12 13:54:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (423, '192.168.1.157', '2017-10-12 13:55:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (424, '192.168.1.157', '2017-10-12 13:56:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (425, '192.168.1.157', '2017-10-12 13:57:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (426, '192.168.1.157', '2017-10-12 13:57:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (427, '192.168.1.157', '2017-10-12 14:00:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (428, '192.168.43.91', '2017-10-12 14:31:22', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (429, '172.20.10.2', '2017-10-12 14:57:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (430, '172.20.10.2', '2017-10-12 15:00:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (431, '192.168.43.91', '2017-10-12 15:21:36', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (432, '192.168.43.91', '2017-10-12 15:22:07', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (433, '172.20.10.2', '2017-10-12 15:22:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (434, '192.168.43.91', '2017-10-12 15:22:46', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (435, '172.20.10.2', '2017-10-12 15:25:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (436, '192.168.43.91', '2017-10-12 15:36:46', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (437, '192.168.43.91', '2017-10-12 15:36:54', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (438, '192.168.1.157', '2017-10-12 16:16:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (439, '192.168.1.157', '2017-10-12 16:20:34', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (440, '192.168.1.235', '2017-10-12 16:21:31', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (441, '192.168.1.235', '2017-10-12 16:21:51', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (442, '192.168.1.235', '2017-10-12 16:22:18', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (443, '192.168.1.157', '2017-10-12 16:29:56', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (444, '192.168.1.157', '2017-10-12 16:29:57', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (445, '192.168.1.157', '2017-10-12 16:29:57', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (446, '192.168.1.157', '2017-10-12 16:29:59', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (447, '192.168.1.157', '2017-10-12 16:30:00', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (448, '192.168.1.235', '2017-10-12 16:30:01', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (449, '192.168.1.157', '2017-10-12 16:30:16', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (450, '192.168.56.1', '2017-10-12 16:33:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (451, '192.168.56.1', '2017-10-12 16:36:33', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (452, '192.168.56.1', '2017-10-12 16:38:04', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (453, '192.168.1.157', '2017-10-12 16:38:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (454, '192.168.1.157', '2017-10-12 16:39:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (455, '192.168.1.157', '2017-10-12 16:39:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (456, '192.168.56.1', '2017-10-12 16:40:27', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (457, '192.168.1.157', '2017-10-12 16:40:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (458, '192.168.1.157', '2017-10-12 16:42:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (459, '192.168.56.1', '2017-10-12 16:42:21', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (460, '192.168.1.157', '2017-10-12 16:42:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (461, '192.168.56.1', '2017-10-12 16:43:33', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (462, '192.168.56.1', '2017-10-12 16:44:20', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (463, '192.168.1.157', '2017-10-12 16:44:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (464, '192.168.56.1', '2017-10-12 16:45:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (465, '192.168.1.235', '2017-10-12 16:45:12', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (466, '192.168.1.157', '2017-10-12 16:45:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (467, '192.168.1.157', '2017-10-12 16:45:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (468, '192.168.56.1', '2017-10-12 16:45:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (469, '192.168.1.235', '2017-10-12 16:45:44', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (470, '192.168.56.1', '2017-10-12 16:46:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (471, '192.168.56.1', '2017-10-12 16:47:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (472, '192.168.56.1', '2017-10-12 16:48:35', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (473, '192.168.1.157', '2017-10-12 16:49:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (474, '192.168.1.235', '2017-10-12 16:55:05', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (475, '192.168.1.235', '2017-10-12 16:55:06', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (476, '192.168.1.235', '2017-10-12 17:00:19', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (477, '192.168.1.235', '2017-10-12 17:00:20', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (478, '192.168.56.1', '2017-10-12 17:00:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (479, '192.168.1.235', '2017-10-12 17:00:57', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (480, '192.168.56.1', '2017-10-12 17:02:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (481, '192.168.56.1', '2017-10-12 17:02:39', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (482, '192.168.56.1', '2017-10-12 17:03:07', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (483, '192.168.1.157', '2017-10-12 17:06:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (484, '192.168.56.1', '2017-10-12 17:06:55', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (485, '192.168.1.157', '2017-10-12 17:06:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (486, '192.168.56.1', '2017-10-12 17:07:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (487, '192.168.1.235', '2017-10-12 17:08:34', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (488, '192.168.1.157', '2017-10-12 17:09:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (489, '192.168.1.157', '2017-10-12 17:13:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (490, '192.168.1.157', '2017-10-12 17:16:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (491, '192.168.56.1', '2017-10-12 17:16:40', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (492, '192.168.56.1', '2017-10-12 17:19:00', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (493, '192.168.1.235', '2017-10-12 17:21:34', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (494, '192.168.56.1', '2017-10-12 17:21:44', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (495, '192.168.56.1', '2017-10-12 17:23:17', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (496, '192.168.56.1', '2017-10-12 17:24:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (497, '192.168.56.1', '2017-10-12 17:25:24', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (498, '192.168.56.1', '2017-10-12 17:25:29', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (499, '192.168.56.1', '2017-10-12 17:25:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (500, '192.168.1.157', '2017-10-12 17:26:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (501, '192.168.56.1', '2017-10-12 17:27:51', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (502, '192.168.1.157', '2017-10-12 17:28:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (503, '192.168.56.1', '2017-10-12 17:31:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (504, '192.168.56.1', '2017-10-12 17:33:11', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (505, '192.168.56.1', '2017-10-12 17:34:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (506, '192.168.56.1', '2017-10-12 17:35:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (507, '192.168.1.235', '2017-10-12 17:36:40', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (508, '192.168.1.235', '2017-10-12 17:40:30', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (509, '192.168.1.157', '2017-10-12 18:45:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (510, '192.168.1.157', '2017-10-12 18:48:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (511, '192.168.1.157', '2017-10-12 18:49:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (512, '192.168.1.157', '2017-10-12 18:49:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (513, '192.168.1.235', '2017-10-12 18:53:46', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (514, '192.168.56.1', '2017-10-12 18:55:14', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (515, '192.168.1.157', '2017-10-12 18:58:24', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (516, '192.168.56.1', '2017-10-12 18:58:51', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (517, '192.168.56.1', '2017-10-12 19:01:30', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (518, '192.168.1.235', '2017-10-12 19:02:23', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (519, '192.168.1.235', '2017-10-12 19:02:32', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (520, '192.168.1.235', '2017-10-12 19:02:38', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (521, '192.168.1.235', '2017-10-12 19:03:10', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (522, '192.168.1.235', '2017-10-12 19:04:23', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (523, '192.168.1.157', '2017-10-12 19:04:35', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (524, '192.168.56.1', '2017-10-12 19:04:54', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (525, '192.168.1.235', '2017-10-12 19:05:41', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (526, '192.168.1.157', '2017-10-12 19:07:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (527, '192.168.56.1', '2017-10-12 19:12:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (528, '192.168.1.157', '2017-10-12 19:12:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (529, '192.168.56.1', '2017-10-12 19:13:25', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (530, '192.168.56.1', '2017-10-12 19:15:36', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (531, '192.168.1.157', '2017-10-12 19:17:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (532, '192.168.56.1', '2017-10-12 19:20:57', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (533, '192.168.1.157', '2017-10-12 19:22:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (534, '192.168.1.157', '2017-10-12 19:24:06', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (535, '192.168.1.157', '2017-10-12 19:24:09', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (536, '192.168.1.157', '2017-10-12 19:24:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (537, '192.168.1.235', '2017-10-12 19:28:14', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (538, '192.168.1.235', '2017-10-12 19:47:28', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (539, '192.168.56.1', '2017-10-12 19:47:50', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (540, '192.168.56.1', '2017-10-12 19:48:41', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (541, '192.168.56.1', '2017-10-12 19:48:41', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (542, '192.168.56.1', '2017-10-12 19:48:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (543, '192.168.56.1', '2017-10-12 19:50:08', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (544, '192.168.56.1', '2017-10-12 19:50:48', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (545, '192.168.56.1', '2017-10-12 19:51:41', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (546, '192.168.56.1', '2017-10-12 19:52:11', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (547, '192.168.1.235', '2017-10-12 19:52:33', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (548, '192.168.1.235', '2017-10-12 19:52:52', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (549, '192.168.1.235', '2017-10-12 19:54:53', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (550, '192.168.1.157', '2017-10-12 19:59:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (551, '192.168.56.1', '2017-10-12 20:00:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (552, '192.168.56.1', '2017-10-12 20:02:32', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (553, '192.168.56.1', '2017-10-12 20:02:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (554, '192.168.56.1', '2017-10-12 20:02:52', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (555, '192.168.56.1', '2017-10-12 20:02:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (556, '192.168.1.235', '2017-10-12 20:30:06', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (557, '192.168.1.235', '2017-10-12 20:55:19', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (558, '192.168.1.157', '2017-10-12 21:03:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (559, '192.168.1.157', '2017-10-12 21:14:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (560, '192.168.1.157', '2017-10-12 21:23:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (561, '192.168.1.157', '2017-10-12 21:35:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (562, '192.168.1.157', '2017-10-12 21:36:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (563, '192.168.1.157', '2017-10-12 21:36:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (564, '192.168.56.1', '2017-10-12 21:38:21', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (565, '192.168.56.1', '2017-10-12 21:39:27', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (566, '192.168.56.1', '2017-10-12 21:39:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (567, '192.168.56.1', '2017-10-12 21:44:41', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (568, '192.168.56.1', '2017-10-12 21:44:52', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (569, '192.168.56.1', '2017-10-12 21:45:06', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (570, '192.168.56.1', '2017-10-12 21:48:26', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (571, '192.168.56.1', '2017-10-12 21:49:52', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (572, '192.168.56.1', '2017-10-12 21:50:06', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (573, '192.168.56.1', '2017-10-12 22:06:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (574, '192.168.1.102', '2017-10-12 22:07:12', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (575, '192.168.56.1', '2017-10-12 22:07:35', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (576, '192.168.1.102', '2017-10-12 22:20:31', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (577, '192.168.56.1', '2017-10-12 22:34:47', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (578, '192.168.56.1', '2017-10-12 22:36:33', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (579, '192.168.56.1', '2017-10-12 22:39:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (580, '192.168.56.1', '2017-10-12 22:40:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (581, '192.168.56.1', '2017-10-12 22:41:00', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (582, '192.168.56.1', '2017-10-12 22:41:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (583, '192.168.56.1', '2017-10-12 22:45:49', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (584, '192.168.56.1', '2017-10-12 22:48:14', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (585, '192.168.56.1', '2017-10-12 22:48:51', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (586, '192.168.56.1', '2017-10-12 22:50:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (587, '192.168.56.1', '2017-10-12 22:51:47', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (588, '192.168.56.1', '2017-10-12 22:52:37', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (589, '192.168.56.1', '2017-10-12 22:58:21', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (590, '192.168.56.1', '2017-10-12 22:58:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (591, '192.168.56.1', '2017-10-12 23:00:08', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (592, '192.168.1.102', '2017-10-12 23:00:46', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (593, '192.168.56.1', '2017-10-12 23:02:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (594, '192.168.56.1', '2017-10-12 23:02:48', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (595, '192.168.56.1', '2017-10-12 23:02:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (596, '192.168.1.102', '2017-10-12 23:03:25', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (597, '192.168.56.1', '2017-10-12 23:04:40', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (598, '192.168.56.1', '2017-10-12 23:05:55', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (599, '192.168.56.1', '2017-10-12 23:06:21', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (600, '192.168.56.1', '2017-10-12 23:06:48', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (601, '192.168.56.1', '2017-10-12 23:07:49', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (602, '192.168.56.1', '2017-10-12 23:08:23', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (603, '192.168.56.1', '2017-10-12 23:10:07', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (604, '192.168.56.1', '2017-10-12 23:10:29', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (605, '192.168.56.1', '2017-10-12 23:11:01', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (606, '192.168.56.1', '2017-10-12 23:24:49', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (607, '192.168.56.1', '2017-10-12 23:25:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (608, '192.168.1.102', '2017-10-12 23:26:29', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (609, '192.168.1.102', '2017-10-12 23:26:46', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (610, '192.168.1.102', '2017-10-12 23:28:08', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (611, '192.168.1.157', '2017-10-12 23:38:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (612, '192.168.1.157', '2017-10-12 23:39:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (613, '192.168.1.102', '2017-10-12 23:43:10', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (614, '192.168.1.157', '2017-10-12 23:45:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (615, '192.168.1.157', '2017-10-12 23:53:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (616, '192.168.1.102', '2017-10-12 23:54:10', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (617, '192.168.1.157', '2017-10-12 23:59:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (618, '172.20.10.2', '2017-10-13 00:09:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (619, '172.20.10.2', '2017-10-13 00:09:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (620, '172.20.10.2', '2017-10-13 00:12:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (621, '192.168.1.102', '2017-10-13 00:13:45', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (622, '192.168.1.102', '2017-10-13 00:15:13', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (623, '192.168.1.102', '2017-10-13 00:15:16', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (624, '172.20.10.2', '2017-10-13 00:16:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (625, '172.20.10.2', '2017-10-13 00:16:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (626, '172.20.10.2', '2017-10-13 00:17:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (627, '172.20.10.2', '2017-10-13 00:17:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (628, '172.20.10.2', '2017-10-13 00:18:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (629, '192.168.1.102', '2017-10-13 00:21:55', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (630, '192.168.1.102', '2017-10-13 00:24:07', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (631, '172.20.10.2', '2017-10-13 00:25:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (632, '172.20.10.2', '2017-10-13 00:25:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (633, '172.20.10.2', '2017-10-13 00:25:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (634, '172.20.10.2', '2017-10-13 00:25:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (635, '172.20.10.2', '2017-10-13 00:25:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (636, '172.20.10.2', '2017-10-13 00:26:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (637, '172.20.10.2', '2017-10-13 00:29:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (638, '172.20.10.2', '2017-10-13 00:31:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (639, '172.20.10.2', '2017-10-13 00:36:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (640, '172.20.10.2', '2017-10-13 00:38:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (641, '172.20.10.2', '2017-10-13 00:38:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (642, '192.168.1.102', '2017-10-13 00:39:23', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (643, '172.20.10.2', '2017-10-13 00:41:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (644, '192.168.1.102', '2017-10-13 00:41:48', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (645, '192.168.1.102', '2017-10-13 00:41:51', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (646, '172.20.10.2', '2017-10-13 00:46:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (647, '172.20.10.2', '2017-10-13 00:48:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (648, '172.20.10.2', '2017-10-13 00:52:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (649, '172.20.10.2', '2017-10-13 00:53:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (650, '172.20.10.2', '2017-10-13 00:57:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (651, '192.168.1.102', '2017-10-13 01:00:01', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (652, '172.20.10.2', '2017-10-13 01:00:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (653, '192.168.1.102', '2017-10-13 01:02:15', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (654, '172.20.10.2', '2017-10-13 01:05:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (655, '192.168.1.102', '2017-10-13 01:07:17', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (656, '192.168.1.102', '2017-10-13 01:08:39', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (657, '192.168.1.102', '2017-10-13 01:23:13', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (658, '192.168.1.157', '2017-10-13 10:45:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (659, '192.168.1.157', '2017-10-13 10:48:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (660, '192.168.1.157', '2017-10-13 10:48:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (661, '192.168.1.157', '2017-10-13 10:49:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (662, '192.168.1.157', '2017-10-13 10:49:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (663, '192.168.1.157', '2017-10-13 10:51:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (664, '192.168.1.157', '2017-10-13 10:51:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (665, '192.168.1.157', '2017-10-13 10:52:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (666, '192.168.1.157', '2017-10-13 10:53:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (667, '192.168.1.157', '2017-10-13 10:54:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (668, '192.168.1.157', '2017-10-13 11:00:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (669, '192.168.1.157', '2017-10-13 11:01:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (670, '192.168.1.157', '2017-10-13 11:04:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (671, '192.168.1.157', '2017-10-13 11:04:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (672, '192.168.1.157', '2017-10-13 11:07:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (673, '192.168.1.157', '2017-10-13 11:09:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (674, '192.168.1.157', '2017-10-13 11:17:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (675, '172.27.198.122', '2017-10-13 11:22:04', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (676, '172.27.198.122', '2017-10-13 11:22:29', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (677, '192.168.1.157', '2017-10-13 11:23:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (678, '192.168.1.157', '2017-10-13 12:54:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (679, '192.168.1.157', '2017-10-13 12:54:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (680, '192.168.1.157', '2017-10-13 13:22:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (681, '192.168.1.157', '2017-10-13 13:22:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (682, '192.168.1.157', '2017-10-13 13:29:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (683, '192.168.1.157', '2017-10-13 13:29:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (684, '192.168.1.157', '2017-10-13 13:30:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (685, '192.168.1.157', '2017-10-13 13:31:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (686, '192.168.1.157', '2017-10-13 13:33:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (687, '192.168.1.157', '2017-10-13 13:34:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (688, '192.168.1.157', '2017-10-13 13:35:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (689, '192.168.1.157', '2017-10-13 13:35:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (690, '192.168.1.157', '2017-10-13 13:39:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (691, '192.168.1.157', '2017-10-13 13:40:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (692, '192.168.1.157', '2017-10-13 14:00:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (693, '192.168.1.157', '2017-10-13 14:01:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (694, '192.168.1.157', '2017-10-13 14:02:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (695, '192.168.1.157', '2017-10-13 14:02:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (696, '192.168.1.157', '2017-10-13 14:03:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (697, '192.168.1.157', '2017-10-13 14:04:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (698, '192.168.1.157', '2017-10-13 14:09:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (699, '192.168.1.157', '2017-10-13 14:10:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (700, '172.27.198.122', '2017-10-13 14:11:11', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (701, '172.27.198.122', '2017-10-13 14:11:24', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (702, '172.27.198.122', '2017-10-13 14:12:18', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (703, '172.27.198.122', '2017-10-13 14:17:41', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (704, '192.168.1.157', '2017-10-13 14:34:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (705, '192.168.1.157', '2017-10-13 14:36:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (706, '192.168.1.157', '2017-10-13 14:37:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (707, '172.27.198.122', '2017-10-13 14:38:26', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (708, '172.27.198.122', '2017-10-13 14:47:38', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (709, '172.27.198.122', '2017-10-13 14:54:14', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (710, '172.27.198.122', '2017-10-13 15:10:05', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (711, '192.168.1.157', '2017-10-13 15:15:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (712, '192.168.1.157', '2017-10-13 15:15:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (713, '192.168.1.157', '2017-10-13 15:17:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (714, '192.168.1.157', '2017-10-13 15:18:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (715, '192.168.1.157', '2017-10-13 15:25:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (716, '192.168.56.1', '2017-10-13 15:26:25', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (717, '192.168.1.157', '2017-10-13 15:27:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (718, '192.168.1.157', '2017-10-13 15:59:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (719, '192.168.1.157', '2017-10-13 15:59:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (720, '192.168.56.1', '2017-10-13 16:00:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (721, '172.27.198.122', '2017-10-13 16:12:50', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (722, '172.27.198.122', '2017-10-13 16:16:31', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (723, '192.168.56.1', '2017-10-13 16:18:07', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (724, '192.168.56.1', '2017-10-13 16:19:34', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (725, '192.168.56.1', '2017-10-13 16:20:10', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (726, '192.168.56.1', '2017-10-13 16:20:38', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (727, '192.168.56.1', '2017-10-13 16:22:33', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (728, '192.168.56.1', '2017-10-13 16:25:01', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (729, '192.168.56.1', '2017-10-13 16:25:54', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (730, '192.168.56.1', '2017-10-13 16:26:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (731, '192.168.56.1', '2017-10-13 16:27:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (732, '192.168.56.1', '2017-10-13 16:29:47', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (733, '192.168.1.157', '2017-10-13 16:34:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (734, '172.27.198.122', '2017-10-13 16:34:03', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (735, '192.168.1.157', '2017-10-13 16:34:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (736, '192.168.1.157', '2017-10-13 16:35:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (737, '192.168.1.157', '2017-10-13 16:35:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (738, '192.168.1.157', '2017-10-13 16:36:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (739, '192.168.1.157', '2017-10-13 16:38:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (740, '192.168.56.1', '2017-10-13 16:39:35', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (741, '192.168.56.1', '2017-10-13 16:39:55', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (742, '172.27.198.122', '2017-10-13 16:41:30', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (743, '192.168.56.1', '2017-10-13 16:48:30', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (744, '192.168.56.1', '2017-10-13 16:50:35', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (745, '192.168.56.1', '2017-10-13 16:51:18', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (746, '192.168.56.1', '2017-10-13 16:53:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (747, '192.168.56.1', '2017-10-13 16:55:39', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (748, '192.168.56.1', '2017-10-13 16:58:03', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (749, '192.168.56.1', '2017-10-13 16:59:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (750, '192.168.56.1', '2017-10-13 17:01:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (751, '192.168.56.1', '2017-10-13 17:02:37', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (752, '192.168.1.157', '2017-10-13 17:07:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (753, '192.168.1.157', '2017-10-13 17:09:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (754, '192.168.1.157', '2017-10-13 17:12:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (755, '192.168.1.157', '2017-10-13 17:12:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (756, '192.168.1.157', '2017-10-13 18:17:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (757, '192.168.1.157', '2017-10-13 18:19:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (758, '192.168.1.157', '2017-10-13 18:22:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (759, '192.168.1.157', '2017-10-13 18:27:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (760, '192.168.1.157', '2017-10-13 18:38:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (761, '192.168.1.157', '2017-10-13 18:38:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (762, '192.168.1.157', '2017-10-13 18:39:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (763, '192.168.1.157', '2017-10-13 18:43:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (764, '172.27.198.122', '2017-10-13 18:43:35', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (765, '192.168.1.157', '2017-10-13 18:45:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (766, '192.168.1.157', '2017-10-13 18:46:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (767, '192.168.1.157', '2017-10-13 18:47:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (768, '192.168.1.157', '2017-10-13 19:00:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (769, '192.168.1.157', '2017-10-13 19:12:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (770, '192.168.1.157', '2017-10-13 19:13:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (771, '192.168.1.157', '2017-10-13 19:15:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (772, '192.168.1.157', '2017-10-13 19:16:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (773, '192.168.1.157', '2017-10-13 19:17:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (774, '172.27.198.122', '2017-10-13 19:30:14', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (775, '172.27.198.122', '2017-10-13 19:30:54', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (776, '172.27.198.122', '2017-10-13 19:30:54', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (777, '172.27.198.122', '2017-10-13 19:30:56', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (778, '172.27.198.122', '2017-10-13 19:33:05', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (779, '172.27.198.122', '2017-10-13 19:34:05', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (780, '172.27.198.122', '2017-10-13 19:34:05', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (781, '172.27.198.122', '2017-10-13 19:34:50', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (782, '172.27.198.122', '2017-10-13 19:35:55', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (783, '172.27.198.122', '2017-10-13 19:36:15', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (784, '172.27.198.122', '2017-10-13 19:36:16', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (785, '172.27.198.122', '2017-10-13 19:37:05', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (786, '192.168.56.1', '2017-10-13 19:38:24', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (787, '192.168.56.1', '2017-10-13 19:39:30', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (788, '192.168.1.157', '2017-10-13 19:43:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (789, '192.168.1.157', '2017-10-13 19:43:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (790, '192.168.1.157', '2017-10-13 19:46:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (791, '192.168.1.157', '2017-10-13 19:47:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (792, '192.168.1.157', '2017-10-13 19:47:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (793, '192.168.1.157', '2017-10-13 19:49:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (794, '192.168.1.157', '2017-10-13 19:49:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (795, '192.168.1.157', '2017-10-13 19:51:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (796, '192.168.1.157', '2017-10-13 19:52:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (797, '192.168.1.157', '2017-10-13 19:53:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (798, '192.168.1.157', '2017-10-13 19:53:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (799, '192.168.1.157', '2017-10-13 19:55:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (800, '192.168.1.157', '2017-10-13 19:56:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (801, '192.168.1.157', '2017-10-13 19:57:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (802, '192.168.1.157', '2017-10-13 19:58:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (803, '192.168.1.157', '2017-10-13 19:59:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (804, '192.168.1.157', '2017-10-13 20:03:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (805, '192.168.1.157', '2017-10-13 20:06:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (806, '192.168.1.157', '2017-10-13 20:06:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (807, '192.168.1.157', '2017-10-13 20:06:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (808, '192.168.1.157', '2017-10-13 20:07:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (809, '192.168.1.157', '2017-10-13 20:08:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (810, '192.168.1.157', '2017-10-13 20:09:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (811, '192.168.1.157', '2017-10-13 20:09:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (812, '172.27.198.122', '2017-10-13 20:10:06', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (813, '192.168.1.157', '2017-10-13 20:10:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (814, '192.168.1.157', '2017-10-13 20:10:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (815, '192.168.1.157', '2017-10-13 20:10:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (816, '192.168.1.157', '2017-10-13 20:11:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (817, '172.27.198.122', '2017-10-13 20:11:21', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (818, '192.168.1.157', '2017-10-13 20:12:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (819, '192.168.1.157', '2017-10-13 20:12:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (820, '192.168.1.157', '2017-10-13 20:12:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (821, '192.168.1.157', '2017-10-13 20:13:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (822, '192.168.1.157', '2017-10-13 20:14:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (823, '192.168.1.157', '2017-10-13 20:14:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (824, '192.168.1.157', '2017-10-13 20:15:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (825, '192.168.1.157', '2017-10-13 20:15:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (826, '192.168.1.157', '2017-10-13 20:16:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (827, '172.27.198.122', '2017-10-13 20:17:46', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (828, '172.27.198.122', '2017-10-13 20:18:12', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (829, '172.27.198.122', '2017-10-13 20:18:15', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (830, '192.168.1.157', '2017-10-13 20:18:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (831, '192.168.56.1', '2017-10-13 20:18:54', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (832, '192.168.56.1', '2017-10-13 20:21:02', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (833, '192.168.56.1', '2017-10-13 20:21:05', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (834, '192.168.1.157', '2017-10-13 20:21:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (835, '192.168.1.157', '2017-10-13 20:21:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (836, '192.168.56.1', '2017-10-13 20:22:27', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (837, '192.168.1.157', '2017-10-13 20:24:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (838, '192.168.1.157', '2017-10-13 20:24:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (839, '192.168.1.157', '2017-10-13 20:24:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (840, '192.168.1.157', '2017-10-13 20:25:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (841, '172.27.198.122', '2017-10-13 20:25:35', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (842, '172.27.198.122', '2017-10-13 20:26:02', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (843, '192.168.1.157', '2017-10-13 20:26:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (844, '192.168.56.1', '2017-10-13 20:26:29', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (845, '192.168.1.157', '2017-10-13 20:26:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (846, '172.27.198.122', '2017-10-13 20:28:10', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (847, '192.168.1.157', '2017-10-13 20:28:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (848, '172.27.198.122', '2017-10-13 20:28:57', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (849, '172.27.198.122', '2017-10-13 20:29:52', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (850, '172.27.198.122', '2017-10-13 20:32:03', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (851, '172.27.198.122', '2017-10-13 20:32:24', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (852, '172.27.198.122', '2017-10-13 20:32:48', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (853, '172.27.198.122', '2017-10-13 20:33:30', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (854, '172.27.198.122', '2017-10-13 20:34:47', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (855, '172.27.198.122', '2017-10-13 20:38:30', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (856, '192.168.1.157', '2017-10-13 20:39:07', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (857, '192.168.1.157', '2017-10-13 20:44:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (858, '192.168.1.157', '2017-10-13 20:44:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (859, '172.27.198.122', '2017-10-13 20:45:01', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (860, '192.168.1.157', '2017-10-13 20:48:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (861, '172.27.198.122', '2017-10-13 20:50:36', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (862, '192.168.1.157', '2017-10-13 20:52:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (863, '172.27.198.122', '2017-10-13 20:53:10', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (864, '192.168.1.157', '2017-10-13 20:53:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (865, '192.168.1.157', '2017-10-13 20:54:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (866, '172.27.198.122', '2017-10-13 20:55:52', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (867, '172.27.198.122', '2017-10-13 20:56:13', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (868, '172.27.198.122', '2017-10-13 20:57:54', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (869, '172.27.198.122', '2017-10-13 20:57:56', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (870, '172.27.198.122', '2017-10-13 20:57:57', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (871, '172.27.198.122', '2017-10-13 20:59:21', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (872, '192.168.56.1', '2017-10-13 20:59:29', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (873, '192.168.56.1', '2017-10-13 21:00:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (874, '192.168.56.1', '2017-10-13 21:01:10', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (875, '192.168.56.1', '2017-10-13 21:01:35', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (876, '172.27.198.122', '2017-10-13 21:01:43', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (877, '192.168.56.1', '2017-10-13 21:01:45', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (878, '172.27.198.122', '2017-10-13 21:01:57', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (879, '192.168.56.1', '2017-10-13 21:06:45', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (880, '192.168.1.157', '2017-10-13 21:06:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (881, '192.168.1.157', '2017-10-13 21:07:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (882, '192.168.1.157', '2017-10-13 21:07:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (883, '192.168.56.1', '2017-10-13 21:09:23', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (884, '192.168.56.1', '2017-10-13 21:09:58', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (885, '192.168.1.157', '2017-10-13 21:10:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (886, '192.168.56.1', '2017-10-13 21:10:41', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (887, '192.168.1.157', '2017-10-13 21:10:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (888, '192.168.1.157', '2017-10-13 21:12:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (889, '192.168.1.157', '2017-10-13 21:14:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (890, '192.168.1.157', '2017-10-13 21:15:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (891, '192.168.1.157', '2017-10-13 21:20:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (892, '192.168.1.157', '2017-10-13 21:27:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (893, '192.168.1.157', '2017-10-13 21:29:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (894, '192.168.1.157', '2017-10-13 21:29:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (895, '192.168.56.1', '2017-10-13 21:45:59', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (896, '192.168.1.157', '2017-10-13 21:46:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (897, '192.168.1.157', '2017-10-13 21:48:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (898, '192.168.1.157', '2017-10-13 21:50:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (899, '192.168.1.157', '2017-10-13 21:51:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (900, '192.168.56.1', '2017-10-13 21:51:22', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (901, '192.168.1.157', '2017-10-13 21:51:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (902, '192.168.1.157', '2017-10-13 21:52:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (903, '192.168.56.1', '2017-10-13 21:53:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (904, '192.168.56.1', '2017-10-13 21:55:23', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (905, '192.168.56.1', '2017-10-13 21:56:51', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (906, '192.168.56.1', '2017-10-13 22:03:26', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (907, '192.168.1.157', '2017-10-13 22:04:07', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (908, '192.168.1.157', '2017-10-13 22:04:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (909, '192.168.56.1', '2017-10-13 22:04:30', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (910, '192.168.1.157', '2017-10-13 22:04:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (911, '192.168.1.157', '2017-10-13 22:05:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (912, '192.168.1.157', '2017-10-13 22:06:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (913, '192.168.1.157', '2017-10-13 22:11:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (914, '192.168.1.157', '2017-10-13 22:17:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (915, '192.168.1.157', '2017-10-13 22:17:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (916, '192.168.1.157', '2017-10-13 22:24:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (917, '192.168.1.157', '2017-10-13 22:26:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (918, '192.168.1.157', '2017-10-13 22:27:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (919, '192.168.1.157', '2017-10-13 22:28:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (920, '192.168.1.157', '2017-10-13 22:29:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (921, '192.168.1.106', '2017-10-13 22:30:05', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (922, '192.168.1.157', '2017-10-13 22:30:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (923, '192.168.1.157', '2017-10-13 22:31:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (924, '192.168.56.1', '2017-10-13 22:31:19', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (925, '192.168.1.157', '2017-10-13 22:34:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (926, '192.168.1.157', '2017-10-13 22:39:52', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (927, '192.168.56.1', '2017-10-13 22:40:31', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (928, '192.168.1.157', '2017-10-13 22:40:38', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (929, '192.168.1.157', '2017-10-13 22:41:36', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (930, '192.168.1.157', '2017-10-13 22:41:40', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (931, '192.168.1.157', '2017-10-13 22:44:12', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (932, '192.168.1.157', '2017-10-13 22:45:25', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (933, '192.168.56.1', '2017-10-13 22:47:40', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (934, '192.168.56.1', '2017-10-13 22:47:47', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (935, '192.168.56.1', '2017-10-13 22:48:08', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (936, '192.168.56.1', '2017-10-13 22:48:18', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (937, '192.168.1.157', '2017-10-13 22:48:25', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (938, '192.168.1.106', '2017-10-13 23:59:26', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (939, '192.168.1.106', '2017-10-13 23:59:55', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (940, '192.168.1.106', '2017-10-14 00:00:13', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (941, '192.168.1.106', '2017-10-14 00:01:23', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (942, '192.168.1.106', '2017-10-14 00:01:33', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (943, '192.168.1.106', '2017-10-14 00:01:35', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (944, '192.168.56.1', '2017-10-14 00:03:24', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (945, '192.168.56.1', '2017-10-14 00:04:07', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (946, '192.168.56.1', '2017-10-14 00:08:59', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (947, '192.168.56.1', '2017-10-14 00:09:16', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (948, '192.168.56.1', '2017-10-14 00:10:04', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (949, '192.168.1.106', '2017-10-14 00:12:49', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (950, '192.168.1.106', '2017-10-14 00:12:52', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (951, '192.168.56.1', '2017-10-14 00:13:21', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (952, '192.168.56.1', '2017-10-14 00:15:10', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (953, '192.168.56.1', '2017-10-14 00:15:13', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (954, '192.168.56.1', '2017-10-14 00:18:21', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (955, '192.168.1.157', '2017-10-14 00:18:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (956, '192.168.56.1', '2017-10-14 00:21:36', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (957, '192.168.56.1', '2017-10-14 00:21:54', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (958, '192.168.56.1', '2017-10-14 00:22:44', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (959, '192.168.56.1', '2017-10-14 00:23:40', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (960, '192.168.1.157', '2017-10-14 00:25:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (961, '192.168.56.1', '2017-10-14 00:28:08', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (962, '192.168.56.1', '2017-10-14 00:28:31', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (963, '192.168.56.1', '2017-10-14 00:28:53', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (964, '192.168.1.157', '2017-10-14 00:30:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (965, '192.168.56.1', '2017-10-14 00:32:21', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (966, '192.168.56.1', '2017-10-14 00:32:46', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (967, '192.168.56.1', '2017-10-14 00:34:50', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (968, '192.168.56.1', '2017-10-14 00:35:52', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (969, '192.168.56.1', '2017-10-14 00:36:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (970, '192.168.56.1', '2017-10-14 00:37:14', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (971, '192.168.56.1', '2017-10-14 00:42:46', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (972, '192.168.56.1', '2017-10-14 00:43:18', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (973, '192.168.56.1', '2017-10-14 00:45:35', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (974, '192.168.1.157', '2017-10-14 00:53:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (975, '192.168.1.157', '2017-10-14 00:53:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (976, '192.168.1.157', '2017-10-14 00:53:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (977, '192.168.1.157', '2017-10-14 00:54:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (978, '192.168.1.157', '2017-10-14 01:01:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (979, '192.168.1.157', '2017-10-14 01:02:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (980, '192.168.1.157', '2017-10-14 01:02:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (981, '192.168.1.157', '2017-10-14 01:03:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (982, '192.168.1.157', '2017-10-14 01:04:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (983, '192.168.1.157', '2017-10-14 01:08:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (984, '192.168.1.157', '2017-10-14 01:09:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (985, '192.168.1.157', '2017-10-14 01:18:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (986, '192.168.1.157', '2017-10-14 01:19:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (987, '192.168.1.157', '2017-10-14 01:19:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (988, '192.168.1.157', '2017-10-14 01:20:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (989, '192.168.1.157', '2017-10-14 01:21:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (990, '192.168.1.157', '2017-10-14 01:45:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (991, '192.168.1.157', '2017-10-14 01:46:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (992, '192.168.1.157', '2017-10-14 01:52:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (993, '192.168.1.157', '2017-10-14 01:53:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (994, '192.168.1.157', '2017-10-14 02:05:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (995, '192.168.1.157', '2017-10-14 02:08:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (996, '192.168.1.157', '2017-10-14 02:10:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (997, '192.168.1.157', '2017-10-14 02:12:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (998, '192.168.1.157', '2017-10-14 02:14:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (999, '192.168.1.157', '2017-10-14 02:15:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1000, '192.168.1.157', '2017-10-14 02:16:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1001, '192.168.1.157', '2017-10-14 02:18:43', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1002, '192.168.1.157', '2017-10-14 02:19:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1003, '192.168.1.157', '2017-10-14 02:21:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1004, '192.168.1.157', '2017-10-14 02:23:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1005, '192.168.1.157', '2017-10-14 02:29:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1006, '192.168.1.157', '2017-10-14 11:13:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1007, '192.168.1.157', '2017-10-14 11:14:24', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1008, '192.168.1.157', '2017-10-14 11:17:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1009, '192.168.1.157', '2017-10-14 11:27:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1010, '192.168.1.157', '2017-10-14 11:28:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1011, '192.168.1.157', '2017-10-14 11:31:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1012, '192.168.1.157', '2017-10-14 11:32:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1013, '192.168.1.157', '2017-10-14 11:33:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1014, '192.168.1.157', '2017-10-14 12:11:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1015, '192.168.1.157', '2017-10-14 12:12:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1016, '192.168.1.157', '2017-10-14 12:13:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1017, '192.168.1.157', '2017-10-14 12:13:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1018, '192.168.1.157', '2017-10-14 12:23:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1019, '192.168.1.157', '2017-10-14 12:30:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1020, '192.168.1.157', '2017-10-14 12:32:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1021, '192.168.1.157', '2017-10-14 12:34:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1022, '192.168.1.157', '2017-10-14 12:51:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1023, '192.168.1.157', '2017-10-14 12:51:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1024, '192.168.1.157', '2017-10-14 13:00:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1025, '192.168.56.1', '2017-10-14 13:01:24', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1026, '192.168.56.1', '2017-10-14 13:01:31', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1027, '192.168.56.1', '2017-10-14 13:06:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1028, '192.168.56.1', '2017-10-14 13:13:49', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1029, '192.168.56.1', '2017-10-14 13:14:00', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1030, '192.168.56.1', '2017-10-14 13:14:15', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1031, '192.168.56.1', '2017-10-14 13:18:28', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1032, '192.168.56.1', '2017-10-14 13:22:46', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1033, '192.168.56.1', '2017-10-14 13:23:09', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1034, '192.168.56.1', '2017-10-14 13:25:32', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1035, '192.168.56.1', '2017-10-14 13:26:32', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1036, '192.168.56.1', '2017-10-14 13:28:29', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1037, '192.168.56.1', '2017-10-14 13:28:40', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1038, '192.168.56.1', '2017-10-14 13:28:55', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1039, '192.168.56.1', '2017-10-14 13:31:06', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1040, '192.168.56.1', '2017-10-14 13:31:14', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1041, '192.168.56.1', '2017-10-14 13:32:01', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1042, '192.168.56.1', '2017-10-14 13:32:33', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1043, '192.168.56.1', '2017-10-14 13:32:47', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1044, '192.168.56.1', '2017-10-14 13:35:18', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1045, '192.168.1.157', '2017-10-14 14:24:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1046, '192.168.1.157', '2017-10-14 14:27:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1047, '192.168.1.157', '2017-10-14 14:31:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1048, '192.168.1.157', '2017-10-14 14:31:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1049, '192.168.1.157', '2017-10-14 14:31:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1050, '192.168.1.157', '2017-10-14 14:31:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1051, '192.168.56.1', '2017-10-14 14:49:38', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1052, '192.168.56.1', '2017-10-14 14:50:07', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1053, '192.168.56.1', '2017-10-14 14:50:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1054, '192.168.56.1', '2017-10-14 14:50:30', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1055, '192.168.56.1', '2017-10-14 15:01:57', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1056, '192.168.56.1', '2017-10-14 15:05:40', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1057, '192.168.56.1', '2017-10-14 15:05:53', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1058, '192.168.56.1', '2017-10-14 15:06:52', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1059, '192.168.56.1', '2017-10-14 15:20:18', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1060, '192.168.1.157', '2017-10-14 16:00:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1061, '192.168.1.157', '2017-10-14 16:06:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1062, '192.168.1.157', '2017-10-14 16:07:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1063, '192.168.1.157', '2017-10-14 16:08:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1064, '192.168.1.157', '2017-10-14 16:13:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1065, '192.168.56.1', '2017-10-14 16:15:25', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1066, '192.168.56.1', '2017-10-14 16:15:25', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1067, '192.168.1.157', '2017-10-14 16:16:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1068, '192.168.56.1', '2017-10-14 16:16:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1069, '192.168.1.157', '2017-10-14 16:18:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1070, '192.168.56.1', '2017-10-14 16:18:48', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1071, '192.168.56.1', '2017-10-14 16:18:50', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1072, '192.168.1.157', '2017-10-14 16:20:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1073, '192.168.56.1', '2017-10-14 16:21:12', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1074, '192.168.56.1', '2017-10-14 16:22:10', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1075, '192.168.56.1', '2017-10-14 16:22:16', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1076, '192.168.56.1', '2017-10-14 16:22:33', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1077, '192.168.56.1', '2017-10-14 16:27:46', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1078, '192.168.56.1', '2017-10-14 16:29:06', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1079, '192.168.56.1', '2017-10-14 16:29:43', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1080, '192.168.1.157', '2017-10-14 16:30:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1081, '192.168.56.1', '2017-10-14 16:31:01', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1082, '192.168.1.157', '2017-10-14 16:36:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1083, '172.27.198.122', '2017-10-14 16:37:04', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1084, '172.27.198.122', '2017-10-14 16:37:05', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1085, '192.168.56.1', '2017-10-14 16:37:26', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1086, '192.168.56.1', '2017-10-14 16:38:54', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1087, '192.168.1.157', '2017-10-14 16:39:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1088, '192.168.56.1', '2017-10-14 16:39:56', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1089, '192.168.1.157', '2017-10-14 16:41:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1090, '192.168.56.1', '2017-10-14 16:42:03', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1091, '192.168.56.1', '2017-10-14 16:42:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1092, '192.168.56.1', '2017-10-14 16:45:21', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1093, '192.168.56.1', '2017-10-14 16:46:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1094, '192.168.1.157', '2017-10-14 16:47:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1095, '192.168.56.1', '2017-10-14 16:48:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1096, '192.168.1.157', '2017-10-14 16:56:32', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1097, '192.168.56.1', '2017-10-14 16:57:51', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1098, '192.168.1.157', '2017-10-14 16:58:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1099, '192.168.1.157', '2017-10-14 16:59:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1100, '192.168.56.1', '2017-10-14 17:01:23', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1101, '192.168.56.1', '2017-10-14 17:01:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1102, '192.168.1.157', '2017-10-14 17:02:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1103, '192.168.1.157', '2017-10-14 17:02:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1104, '192.168.1.157', '2017-10-14 17:04:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1105, '192.168.1.157', '2017-10-14 17:04:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1106, '192.168.1.157', '2017-10-14 17:05:23', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1107, '192.168.1.157', '2017-10-14 17:07:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1108, '192.168.1.157', '2017-10-14 17:08:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1109, '192.168.1.157', '2017-10-14 17:09:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1110, '192.168.1.157', '2017-10-14 17:53:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1111, '192.168.1.157', '2017-10-14 17:54:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1112, '192.168.1.157', '2017-10-14 17:54:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1113, '192.168.1.157', '2017-10-14 17:56:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1114, '192.168.1.157', '2017-10-14 19:42:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1115, '172.27.198.122', '2017-10-14 19:55:11', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1116, '172.27.198.122', '2017-10-14 19:55:32', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1117, '172.27.198.122', '2017-10-14 20:01:44', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1118, '192.168.1.157', '2017-10-14 20:02:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1119, '192.168.1.157', '2017-10-14 20:06:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1120, '192.168.56.1', '2017-10-14 20:06:49', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1121, '192.168.1.157', '2017-10-14 20:06:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1122, '192.168.1.157', '2017-10-14 20:07:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1123, '192.168.1.157', '2017-10-14 20:10:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1124, '192.168.56.1', '2017-10-14 20:11:16', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1125, '192.168.56.1', '2017-10-14 20:16:16', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1126, '192.168.56.1', '2017-10-14 20:18:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1127, '192.168.56.1', '2017-10-14 20:19:20', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1128, '192.168.1.157', '2017-10-14 20:26:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1129, '192.168.1.157', '2017-10-14 20:26:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1130, '192.168.1.157', '2017-10-14 20:27:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1131, '192.168.56.1', '2017-10-14 20:28:43', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1132, '192.168.56.1', '2017-10-14 20:30:03', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1133, '192.168.56.1', '2017-10-14 20:32:36', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1134, '192.168.56.1', '2017-10-14 20:35:29', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1135, '192.168.56.1', '2017-10-14 20:37:08', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1136, '192.168.56.1', '2017-10-14 20:38:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1137, '192.168.56.1', '2017-10-14 20:38:13', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1138, '192.168.56.1', '2017-10-14 20:38:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1139, '172.27.198.122', '2017-10-14 20:44:01', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1140, '172.27.198.122', '2017-10-14 20:47:08', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1141, '172.31.17.170', '2017-10-14 20:49:43', '流程管理', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1142, '172.27.198.122', '2017-10-14 20:50:00', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1143, '172.31.17.170', '2017-10-14 20:50:09', '流程管理', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1144, '172.27.198.122', '2017-10-14 20:51:08', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1145, '192.168.1.157', '2017-10-14 20:52:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1146, '172.31.17.170', '2017-10-14 20:52:48', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1147, '192.168.56.1', '2017-10-14 20:52:54', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1148, '192.168.56.1', '2017-10-14 20:54:11', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1149, '172.31.17.170', '2017-10-14 20:54:17', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1150, '172.31.17.170', '2017-10-14 20:55:14', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1151, '172.31.17.170', '2017-10-14 20:55:23', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1152, '192.168.56.1', '2017-10-14 20:57:39', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1153, '192.168.1.157', '2017-10-14 21:09:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1154, '192.168.1.157', '2017-10-14 21:10:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1155, '192.168.1.157', '2017-10-14 21:10:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1156, '192.168.1.157', '2017-10-14 21:14:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1157, '192.168.56.1', '2017-10-14 21:16:51', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1158, '172.27.198.122', '2017-10-14 21:17:36', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1159, '172.27.198.122', '2017-10-14 21:18:21', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1160, '172.27.198.122', '2017-10-14 21:19:17', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1161, '192.168.56.1', '2017-10-14 21:21:16', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1162, '192.168.56.1', '2017-10-14 21:21:16', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1163, '172.27.198.122', '2017-10-14 21:21:21', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1164, '192.168.56.1', '2017-10-14 21:21:26', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1165, '172.27.198.122', '2017-10-14 21:22:15', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1166, '192.168.56.1', '2017-10-14 21:22:36', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1167, '172.27.198.122', '2017-10-14 21:22:46', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1168, '172.27.198.122', '2017-10-14 21:23:17', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1169, '172.27.198.122', '2017-10-14 21:26:14', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1170, '192.168.56.1', '2017-10-14 21:27:32', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1171, '172.27.198.122', '2017-10-14 21:27:58', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1172, '192.168.1.157', '2017-10-14 21:28:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1173, '172.27.198.122', '2017-10-14 21:28:40', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1174, '172.27.198.122', '2017-10-14 21:28:54', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1175, '172.27.198.122', '2017-10-14 21:29:03', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1176, '192.168.56.1', '2017-10-14 21:29:42', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1177, '172.27.198.122', '2017-10-14 21:30:57', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1178, '172.27.198.122', '2017-10-14 21:32:30', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1179, '172.27.198.122', '2017-10-14 21:32:43', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1180, '172.27.198.122', '2017-10-14 21:33:22', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1181, '192.168.56.1', '2017-10-14 21:34:42', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1182, '192.168.56.1', '2017-10-14 21:34:50', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1183, '172.27.198.122', '2017-10-14 21:34:58', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1184, '192.168.56.1', '2017-10-14 21:37:27', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1185, '192.168.56.1', '2017-10-14 21:38:04', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1186, '192.168.1.157', '2017-10-14 21:38:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1187, '192.168.56.1', '2017-10-14 21:39:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1188, '192.168.56.1', '2017-10-14 21:39:47', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1189, '192.168.56.1', '2017-10-14 21:39:50', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1190, '192.168.56.1', '2017-10-14 21:55:26', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1191, '192.168.56.1', '2017-10-14 21:56:04', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1192, '192.168.56.1', '2017-10-14 22:08:01', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1193, '192.168.56.1', '2017-10-14 22:08:42', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1194, '192.168.56.1', '2017-10-14 22:08:44', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1195, '192.168.1.157', '2017-10-14 22:09:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1196, '192.168.56.1', '2017-10-14 22:10:14', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1197, '192.168.56.1', '2017-10-14 22:11:44', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1198, '192.168.56.1', '2017-10-14 22:11:50', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1199, '192.168.56.1', '2017-10-14 22:11:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1200, '192.168.56.1', '2017-10-14 22:12:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1201, '192.168.56.1', '2017-10-14 22:13:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1202, '192.168.56.1', '2017-10-14 22:14:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1203, '192.168.56.1', '2017-10-14 22:16:40', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1204, '192.168.1.157', '2017-10-14 22:17:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1205, '192.168.56.1', '2017-10-14 22:17:30', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1206, '192.168.56.1', '2017-10-14 22:22:28', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1207, '192.168.1.157', '2017-10-14 22:32:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1208, '192.168.1.157', '2017-10-14 22:32:23', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1209, '192.168.1.157', '2017-10-14 22:32:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1210, '192.168.56.1', '2017-10-14 22:33:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1211, '192.168.56.1', '2017-10-14 22:33:11', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1212, '192.168.56.1', '2017-10-14 22:33:13', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1213, '192.168.56.1', '2017-10-14 22:36:10', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1214, '192.168.56.1', '2017-10-14 22:37:39', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1215, '192.168.1.157', '2017-10-14 22:46:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1216, '192.168.1.157', '2017-10-14 22:47:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1217, '192.168.1.157', '2017-10-14 22:49:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1218, '192.168.1.157', '2017-10-14 22:50:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1219, '192.168.56.1', '2017-10-14 22:51:21', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1220, '192.168.1.157', '2017-10-14 22:51:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1221, '192.168.56.1', '2017-10-14 22:52:01', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1222, '192.168.1.157', '2017-10-14 22:54:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1223, '192.168.1.157', '2017-10-14 22:56:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1224, '192.168.1.157', '2017-10-14 22:58:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1225, '192.168.56.1', '2017-10-14 22:58:55', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1226, '192.168.56.1', '2017-10-14 22:59:10', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1227, '192.168.56.1', '2017-10-14 23:02:03', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1228, '192.168.56.1', '2017-10-14 23:02:49', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1229, '192.168.1.157', '2017-10-14 23:05:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1230, '192.168.1.157', '2017-10-14 23:11:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1231, '192.168.1.157', '2017-10-14 23:12:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1232, '192.168.1.157', '2017-10-14 23:13:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1233, '192.168.1.157', '2017-10-14 23:13:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1234, '192.168.1.157', '2017-10-14 23:15:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1235, '192.168.1.157', '2017-10-14 23:15:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1236, '192.168.1.157', '2017-10-14 23:16:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1237, '192.168.1.157', '2017-10-14 23:18:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1238, '192.168.1.157', '2017-10-14 23:19:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1239, '192.168.1.157', '2017-10-14 23:20:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1240, '192.168.1.157', '2017-10-14 23:21:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1241, '192.168.1.157', '2017-10-14 23:21:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1242, '192.168.1.157', '2017-10-14 23:21:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1243, '192.168.56.1', '2017-10-14 23:21:52', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1244, '192.168.56.1', '2017-10-14 23:22:51', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1245, '192.168.56.1', '2017-10-14 23:22:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1246, '192.168.1.157', '2017-10-14 23:23:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1247, '192.168.1.157', '2017-10-14 23:24:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1248, '192.168.1.157', '2017-10-14 23:26:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1249, '192.168.1.157', '2017-10-14 23:29:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1250, '192.168.1.157', '2017-10-14 23:30:30', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1251, '192.168.1.157', '2017-10-14 23:34:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1252, '192.168.1.157', '2017-10-14 23:50:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1253, '192.168.1.157', '2017-10-14 23:52:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1254, '192.168.56.1', '2017-10-15 00:02:00', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1255, '192.168.1.157', '2017-10-15 00:03:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1256, '192.168.56.1', '2017-10-15 00:03:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1257, '192.168.56.1', '2017-10-15 00:04:32', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1258, '192.168.56.1', '2017-10-15 00:05:42', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1259, '192.168.56.1', '2017-10-15 00:05:55', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1260, '192.168.56.1', '2017-10-15 00:05:56', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1261, '192.168.56.1', '2017-10-15 00:06:13', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1262, '192.168.56.1', '2017-10-15 00:06:28', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1263, '192.168.1.157', '2017-10-15 00:09:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1264, '192.168.56.1', '2017-10-15 00:09:37', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1265, '192.168.56.1', '2017-10-15 00:11:01', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1266, '192.168.56.1', '2017-10-15 00:11:31', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1267, '192.168.56.1', '2017-10-15 00:11:52', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1268, '192.168.1.157', '2017-10-15 00:12:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1269, '192.168.56.1', '2017-10-15 00:12:49', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1270, '192.168.1.157', '2017-10-15 00:13:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1271, '192.168.1.157', '2017-10-15 00:13:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1272, '192.168.56.1', '2017-10-15 00:13:15', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1273, '192.168.56.1', '2017-10-15 00:13:23', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1274, '192.168.1.157', '2017-10-15 00:13:51', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1275, '192.168.56.1', '2017-10-15 00:15:10', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1276, '192.168.56.1', '2017-10-15 00:15:38', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1277, '192.168.56.1', '2017-10-15 00:15:48', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1278, '192.168.1.157', '2017-10-15 00:17:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1279, '192.168.56.1', '2017-10-15 00:18:50', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1280, '192.168.56.1', '2017-10-15 00:19:51', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1281, '192.168.56.1', '2017-10-15 00:21:00', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1282, '192.168.1.157', '2017-10-15 00:22:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1283, '192.168.1.157', '2017-10-15 00:22:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1284, '172.31.17.170', '2017-10-15 00:38:57', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1285, '172.31.17.170', '2017-10-15 00:39:15', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1286, '192.168.1.157', '2017-10-15 00:39:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1287, '192.168.1.157', '2017-10-15 00:40:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1288, '192.168.1.157', '2017-10-15 00:41:31', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1289, '192.168.1.157', '2017-10-15 00:42:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1290, '192.168.1.157', '2017-10-15 00:42:56', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1291, '192.168.1.157', '2017-10-15 00:44:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1292, '192.168.1.157', '2017-10-15 00:45:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1293, '192.168.1.157', '2017-10-15 00:45:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1294, '192.168.1.157', '2017-10-15 00:47:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1295, '192.168.1.157', '2017-10-15 01:01:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1296, '192.168.1.157', '2017-10-15 01:04:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1297, '172.27.198.122', '2017-10-15 10:25:12', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1298, '192.168.1.157', '2017-10-15 11:05:04', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1299, '192.168.1.157', '2017-10-15 11:05:09', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1300, '192.168.1.157', '2017-10-15 11:09:21', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1301, '192.168.1.157', '2017-10-15 11:12:10', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1302, '192.168.1.157', '2017-10-15 11:12:12', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1303, '192.168.1.157', '2017-10-15 11:13:28', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1304, '192.168.1.157', '2017-10-15 11:13:31', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1305, '192.168.1.157', '2017-10-15 11:13:37', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1306, '192.168.1.157', '2017-10-15 11:13:55', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (1307, '192.168.1.157', '2017-10-15 11:15:33', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (1308, '192.168.1.157', '2017-10-15 11:34:18', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (1309, '192.168.1.157', '2017-10-15 11:34:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1310, '192.168.1.157', '2017-10-15 11:34:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1311, '192.168.56.1', '2017-10-15 14:03:17', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1312, '192.168.56.1', '2017-10-15 14:04:16', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1313, '192.168.56.1', '2017-10-15 14:04:19', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1314, '192.168.56.1', '2017-10-15 14:04:38', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1315, '192.168.56.1', '2017-10-15 14:04:56', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1316, '192.168.56.1', '2017-10-15 14:05:41', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1317, '192.168.56.1', '2017-10-15 14:06:54', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1318, '192.168.56.1', '2017-10-15 14:08:53', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1319, '192.168.56.1', '2017-10-15 14:09:02', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1320, '192.168.56.1', '2017-10-15 14:09:56', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1321, '192.168.56.1', '2017-10-15 14:10:54', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1322, '192.168.56.1', '2017-10-15 14:10:57', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1323, '172.31.17.170', '2017-10-15 14:13:46', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1324, '192.168.1.157', '2017-10-15 14:15:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1325, '192.168.1.157', '2017-10-15 14:15:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1326, '192.168.1.157', '2017-10-15 15:00:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1327, '192.168.1.157', '2017-10-15 15:01:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1328, '192.168.137.1', '2017-10-15 15:02:06', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1329, '192.168.137.1', '2017-10-15 15:02:11', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1330, '192.168.1.157', '2017-10-15 15:02:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1331, '192.168.1.157', '2017-10-15 15:03:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1332, '192.168.1.157', '2017-10-15 15:03:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1333, '192.168.1.157', '2017-10-15 15:04:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1334, '192.168.137.1', '2017-10-15 15:04:27', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1335, '192.168.137.1', '2017-10-15 15:04:31', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1336, '192.168.1.157', '2017-10-15 15:04:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1337, '192.168.1.157', '2017-10-15 15:05:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1338, '192.168.1.157', '2017-10-15 15:06:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1339, '192.168.1.157', '2017-10-15 15:08:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1340, '192.168.1.157', '2017-10-15 15:08:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1341, '192.168.1.157', '2017-10-15 15:08:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1342, '192.168.1.157', '2017-10-15 15:09:52', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1343, '192.168.1.157', '2017-10-15 15:10:34', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1344, '192.168.1.157', '2017-10-15 15:11:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1345, '192.168.1.157', '2017-10-15 15:11:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1346, '192.168.1.157', '2017-10-15 15:13:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1347, '192.168.1.157', '2017-10-15 15:14:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1348, '192.168.1.157', '2017-10-15 15:14:29', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1349, '192.168.56.1', '2017-10-15 15:15:27', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1350, '192.168.1.157', '2017-10-15 15:15:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1351, '192.168.1.157', '2017-10-15 15:18:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1352, '192.168.56.1', '2017-10-15 15:29:51', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1353, '192.168.56.1', '2017-10-15 15:31:30', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1354, '192.168.56.1', '2017-10-15 15:32:51', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1355, '192.168.137.1', '2017-10-15 15:37:58', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1356, '192.168.137.1', '2017-10-15 15:38:12', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1357, '192.168.137.1', '2017-10-15 15:38:13', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1358, '192.168.56.1', '2017-10-15 15:45:19', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1359, '192.168.56.1', '2017-10-15 15:45:24', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1360, '192.168.1.157', '2017-10-15 15:47:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1361, '192.168.56.1', '2017-10-15 15:47:00', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1362, '192.168.1.157', '2017-10-15 15:47:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1363, '192.168.56.1', '2017-10-15 15:47:34', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1364, '192.168.56.1', '2017-10-15 15:47:57', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1365, '192.168.56.1', '2017-10-15 15:48:08', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1366, '192.168.1.157', '2017-10-15 15:49:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1367, '192.168.1.157', '2017-10-15 16:08:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1368, '192.168.56.1', '2017-10-15 16:11:39', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1369, '192.168.56.1', '2017-10-15 16:11:41', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1370, '192.168.56.1', '2017-10-15 16:13:21', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1371, '192.168.56.1', '2017-10-15 16:14:06', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1372, '192.168.1.157', '2017-10-15 16:14:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1373, '192.168.1.157', '2017-10-15 16:16:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1374, '192.168.56.1', '2017-10-15 16:16:35', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1375, '192.168.1.157', '2017-10-15 16:17:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1376, '192.168.56.1', '2017-10-15 16:17:19', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1377, '192.168.1.157', '2017-10-15 16:18:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1378, '192.168.1.157', '2017-10-15 16:21:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1379, '192.168.1.157', '2017-10-15 16:22:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1380, '192.168.1.157', '2017-10-15 16:23:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1381, '192.168.56.1', '2017-10-15 16:49:51', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1382, '192.168.137.1', '2017-10-15 17:16:03', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1383, '192.168.1.157', '2017-10-15 18:30:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1384, '192.168.56.1', '2017-10-15 18:30:48', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1385, '192.168.1.157', '2017-10-15 18:31:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1386, '192.168.1.157', '2017-10-15 18:32:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1387, '192.168.1.157', '2017-10-15 18:33:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1388, '192.168.1.157', '2017-10-15 18:33:43', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1389, '192.168.56.1', '2017-10-15 18:34:19', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1390, '192.168.1.157', '2017-10-15 18:35:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1391, '192.168.1.157', '2017-10-15 18:35:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1392, '192.168.56.1', '2017-10-15 18:36:56', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1393, '192.168.56.1', '2017-10-15 18:36:56', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1394, '192.168.1.157', '2017-10-15 18:37:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1395, '192.168.56.1', '2017-10-15 18:37:55', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1396, '192.168.56.1', '2017-10-15 18:37:56', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1397, '192.168.1.157', '2017-10-15 18:38:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1398, '192.168.1.157', '2017-10-15 18:39:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1399, '192.168.56.1', '2017-10-15 18:40:01', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1400, '192.168.137.1', '2017-10-15 18:43:32', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1401, '192.168.56.1', '2017-10-15 18:44:06', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1402, '192.168.56.1', '2017-10-15 18:44:15', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1403, '192.168.1.157', '2017-10-15 18:45:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1404, '192.168.1.157', '2017-10-15 18:46:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1405, '192.168.56.1', '2017-10-15 18:46:11', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1406, '192.168.56.1', '2017-10-15 18:46:12', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1407, '192.168.1.157', '2017-10-15 18:46:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1408, '192.168.1.157', '2017-10-15 18:47:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1409, '192.168.56.1', '2017-10-15 18:48:55', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1410, '192.168.1.157', '2017-10-15 18:48:59', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1411, '192.168.1.157', '2017-10-15 18:49:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1412, '192.168.1.157', '2017-10-15 18:49:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1413, '192.168.56.1', '2017-10-15 18:51:25', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1414, '192.168.56.1', '2017-10-15 18:51:47', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1415, '192.168.56.1', '2017-10-15 18:52:04', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1416, '192.168.1.157', '2017-10-15 18:52:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1417, '192.168.56.1', '2017-10-15 18:54:34', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1418, '192.168.56.1', '2017-10-15 18:55:44', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1419, '192.168.56.1', '2017-10-15 18:55:53', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1420, '192.168.1.157', '2017-10-15 18:58:12', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1421, '192.168.137.1', '2017-10-15 18:59:02', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1422, '192.168.137.1', '2017-10-15 18:59:08', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1423, '192.168.1.157', '2017-10-15 18:59:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1424, '192.168.1.157', '2017-10-15 18:59:55', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1425, '192.168.56.1', '2017-10-15 19:00:59', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1426, '192.168.137.1', '2017-10-15 19:01:25', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1427, '192.168.137.1', '2017-10-15 19:01:47', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1428, '192.168.56.1', '2017-10-15 19:02:07', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1429, '192.168.56.1', '2017-10-15 19:02:08', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1430, '192.168.56.1', '2017-10-15 19:02:11', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1431, '192.168.56.1', '2017-10-15 19:02:15', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1432, '192.168.56.1', '2017-10-15 19:02:24', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1433, '192.168.137.1', '2017-10-15 19:05:01', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1434, '192.168.1.157', '2017-10-15 19:07:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1435, '192.168.1.157', '2017-10-15 19:10:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1436, '192.168.1.157', '2017-10-15 19:16:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1437, '192.168.56.1', '2017-10-15 19:16:10', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1438, '192.168.56.1', '2017-10-15 19:16:24', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1439, '192.168.56.1', '2017-10-15 19:16:32', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1440, '192.168.1.157', '2017-10-15 19:17:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1441, '192.168.137.1', '2017-10-15 19:17:15', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1442, '192.168.137.1', '2017-10-15 19:17:20', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1443, '192.168.56.1', '2017-10-15 19:17:47', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1444, '192.168.56.1', '2017-10-15 19:17:49', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1445, '192.168.56.1', '2017-10-15 19:17:50', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1446, '192.168.56.1', '2017-10-15 19:17:57', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1447, '192.168.56.1', '2017-10-15 19:17:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1448, '192.168.137.1', '2017-10-15 19:18:28', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1449, '192.168.56.1', '2017-10-15 19:18:52', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1450, '192.168.56.1', '2017-10-15 19:20:26', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1451, '192.168.1.157', '2017-10-15 19:21:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1452, '192.168.56.1', '2017-10-15 19:21:50', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1453, '192.168.56.1', '2017-10-15 19:22:35', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1454, '192.168.56.1', '2017-10-15 19:22:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1455, '192.168.1.157', '2017-10-15 19:23:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1456, '192.168.56.1', '2017-10-15 19:23:23', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1457, '192.168.1.157', '2017-10-15 19:24:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1458, '192.168.1.157', '2017-10-15 19:25:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1459, '192.168.56.1', '2017-10-15 19:26:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1460, '192.168.56.1', '2017-10-15 19:27:33', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1461, '192.168.56.1', '2017-10-15 19:40:30', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1462, '192.168.1.157', '2017-10-15 19:41:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1463, '192.168.1.157', '2017-10-15 19:41:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1464, '192.168.1.157', '2017-10-15 19:42:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1465, '192.168.56.1', '2017-10-15 19:42:54', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1466, '192.168.137.1', '2017-10-15 19:43:06', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1467, '192.168.1.157', '2017-10-15 19:43:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1468, '192.168.1.157', '2017-10-15 19:44:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1469, '192.168.1.157', '2017-10-15 19:44:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1470, '192.168.56.1', '2017-10-15 19:45:24', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1471, '192.168.56.1', '2017-10-15 19:45:28', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1472, '192.168.1.157', '2017-10-15 19:45:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1473, '192.168.56.1', '2017-10-15 19:47:07', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1474, '192.168.1.157', '2017-10-15 19:47:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1475, '192.168.1.157', '2017-10-15 19:47:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1476, '192.168.1.157', '2017-10-15 19:50:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1477, '192.168.1.157', '2017-10-15 19:51:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1478, '192.168.1.157', '2017-10-15 19:51:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1479, '192.168.1.157', '2017-10-15 19:52:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1480, '192.168.1.157', '2017-10-15 19:53:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1481, '192.168.1.157', '2017-10-15 19:55:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1482, '192.168.1.157', '2017-10-15 19:55:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1483, '192.168.1.157', '2017-10-15 19:56:39', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1484, '192.168.56.1', '2017-10-15 20:00:02', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1485, '192.168.56.1', '2017-10-15 20:00:13', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1486, '192.168.56.1', '2017-10-15 20:00:18', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1487, '192.168.137.1', '2017-10-15 20:01:32', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1488, '192.168.56.1', '2017-10-15 20:02:15', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1489, '192.168.56.1', '2017-10-15 20:02:44', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1490, '192.168.56.1', '2017-10-15 20:02:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1491, '192.168.56.1', '2017-10-15 20:03:02', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1492, '192.168.56.1', '2017-10-15 20:03:02', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1493, '192.168.56.1', '2017-10-15 20:03:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1494, '192.168.56.1', '2017-10-15 20:03:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1495, '192.168.56.1', '2017-10-15 20:04:03', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1496, '192.168.56.1', '2017-10-15 20:04:14', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1497, '192.168.56.1', '2017-10-15 20:11:37', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1498, '192.168.56.1', '2017-10-15 20:12:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1499, '192.168.56.1', '2017-10-15 20:14:14', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1500, '192.168.56.1', '2017-10-15 20:14:33', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1501, '192.168.56.1', '2017-10-15 20:14:33', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1502, '192.168.56.1', '2017-10-15 20:17:26', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1503, '192.168.56.1', '2017-10-15 20:18:05', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1504, '192.168.1.157', '2017-10-15 20:45:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1505, '192.168.1.157', '2017-10-15 20:46:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1506, '192.168.1.157', '2017-10-15 20:47:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1507, '192.168.1.157', '2017-10-15 20:47:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1508, '192.168.137.1', '2017-10-15 20:47:56', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1509, '192.168.1.157', '2017-10-15 20:48:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1510, '192.168.1.157', '2017-10-15 20:48:54', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1511, '192.168.1.157', '2017-10-15 20:49:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1512, '192.168.1.157', '2017-10-15 20:50:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1513, '192.168.137.1', '2017-10-15 20:50:38', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1514, '192.168.1.157', '2017-10-15 20:51:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1515, '192.168.137.1', '2017-10-15 20:51:41', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1516, '192.168.137.1', '2017-10-15 20:52:02', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1517, '192.168.1.157', '2017-10-15 20:52:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1518, '192.168.137.1', '2017-10-15 20:53:02', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1519, '192.168.137.1', '2017-10-15 20:53:20', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1520, '192.168.1.157', '2017-10-15 20:53:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1521, '192.168.137.1', '2017-10-15 20:53:37', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1522, '192.168.1.157', '2017-10-15 20:53:53', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1523, '192.168.137.1', '2017-10-15 20:53:59', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1524, '192.168.56.1', '2017-10-15 20:59:48', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1525, '192.168.1.157', '2017-10-15 21:00:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1526, '192.168.56.1', '2017-10-15 21:11:46', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1527, '192.168.56.1', '2017-10-15 21:11:59', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1528, '192.168.56.1', '2017-10-15 21:18:37', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1529, '192.168.56.1', '2017-10-15 21:19:16', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1530, '192.168.56.1', '2017-10-15 21:19:56', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1531, '192.168.1.157', '2017-10-15 21:20:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1532, '192.168.1.157', '2017-10-15 21:20:16', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1533, '192.168.1.157', '2017-10-15 21:20:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1534, '192.168.1.157', '2017-10-15 21:22:14', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1535, '192.168.56.1', '2017-10-15 21:22:25', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1536, '192.168.1.157', '2017-10-15 21:23:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1537, '192.168.56.1', '2017-10-15 21:23:33', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1538, '192.168.56.1', '2017-10-15 21:24:25', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1539, '192.168.56.1', '2017-10-15 21:24:54', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1540, '192.168.56.1', '2017-10-15 21:26:35', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1541, '192.168.56.1', '2017-10-15 21:29:47', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1542, '192.168.1.157', '2017-10-15 21:47:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1543, '192.168.1.157', '2017-10-15 21:48:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1544, '192.168.1.157', '2017-10-15 21:49:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1545, '192.168.1.157', '2017-10-15 21:50:48', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1546, '192.168.1.157', '2017-10-15 21:57:41', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1547, '192.168.1.157', '2017-10-15 22:02:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1548, '192.168.1.157', '2017-10-15 22:03:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1549, '192.168.1.157', '2017-10-15 22:03:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1550, '192.168.1.157', '2017-10-15 22:04:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1551, '192.168.1.157', '2017-10-15 22:06:24', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1552, '192.168.1.157', '2017-10-15 22:09:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1553, '192.168.1.157', '2017-10-15 22:12:36', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1554, '192.168.1.157', '2017-10-15 22:26:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1555, '192.168.1.157', '2017-10-15 22:30:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1556, '192.168.1.157', '2017-10-15 22:31:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1557, '192.168.1.157', '2017-10-15 22:31:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1558, '192.168.1.157', '2017-10-15 22:31:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1559, '192.168.1.157', '2017-10-15 22:33:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1560, '192.168.1.101', '2017-10-15 22:34:05', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1561, '192.168.1.157', '2017-10-15 22:34:21', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1562, '192.168.1.157', '2017-10-15 22:35:17', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1563, '192.168.1.157', '2017-10-15 22:37:09', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1564, '192.168.1.101', '2017-10-15 22:38:03', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1565, '192.168.1.157', '2017-10-15 22:38:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1566, '192.168.1.157', '2017-10-15 22:41:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1567, '192.168.1.157', '2017-10-15 22:42:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1568, '192.168.1.157', '2017-10-15 22:43:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1569, '192.168.1.157', '2017-10-15 22:56:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1570, '192.168.1.157', '2017-10-15 22:57:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1571, '192.168.1.157', '2017-10-15 22:57:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1572, '192.168.1.157', '2017-10-15 22:59:06', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1573, '192.168.1.157', '2017-10-15 22:59:27', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1574, '192.168.1.157', '2017-10-15 23:00:11', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1575, '192.168.1.101', '2017-10-15 23:01:33', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1576, '192.168.1.101', '2017-10-15 23:01:40', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1577, '192.168.1.157', '2017-10-15 23:08:03', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1578, '192.168.1.157', '2017-10-15 23:09:33', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1579, '192.168.1.157', '2017-10-15 23:12:58', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1580, '192.168.1.157', '2017-10-15 23:14:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1581, '192.168.1.101', '2017-10-15 23:16:28', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1582, '192.168.1.157', '2017-10-15 23:18:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1583, '192.168.1.157', '2017-10-15 23:19:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1584, '192.168.1.157', '2017-10-15 23:23:32', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1585, '192.168.1.157', '2017-10-15 23:24:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1586, '192.168.1.101', '2017-10-15 23:25:44', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1587, '192.168.1.157', '2017-10-15 23:27:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1588, '192.168.1.157', '2017-10-15 23:28:13', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1589, '192.168.1.157', '2017-10-15 23:29:00', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1590, '192.168.1.101', '2017-10-15 23:29:08', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1591, '192.168.1.101', '2017-10-15 23:29:09', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1592, '192.168.1.101', '2017-10-15 23:29:10', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1593, '192.168.1.157', '2017-10-15 23:29:50', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1594, '192.168.1.157', '2017-10-15 23:40:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1595, '192.168.1.157', '2017-10-15 23:40:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1596, '192.168.1.157', '2017-10-15 23:40:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1597, '192.168.1.157', '2017-10-15 23:40:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1598, '192.168.1.157', '2017-10-15 23:44:18', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1599, '192.168.1.157', '2017-10-15 23:48:02', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1600, '192.168.1.157', '2017-10-15 23:48:25', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1601, '192.168.1.157', '2017-10-15 23:49:38', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1602, '192.168.1.157', '2017-10-15 23:50:22', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1603, '192.168.1.157', '2017-10-15 23:50:57', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1604, '192.168.1.157', '2017-10-15 23:51:26', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1605, '192.168.1.157', '2017-10-15 23:53:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1606, '192.168.1.157', '2017-10-15 23:53:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1607, '192.168.1.157', '2017-10-15 23:53:20', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1608, '192.168.1.157', '2017-10-15 23:58:04', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1609, '192.168.1.157', '2017-10-15 23:58:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1610, '192.168.1.104', '2017-10-16 08:29:51', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1611, '172.31.17.170', '2017-10-16 09:21:38', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1612, '172.31.17.170', '2017-10-16 09:22:31', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1613, '172.31.17.170', '2017-10-16 09:22:40', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1614, '172.31.17.170', '2017-10-16 09:23:08', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1615, '192.168.1.104', '2017-10-16 09:27:33', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1616, '192.168.1.104', '2017-10-16 09:28:34', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1617, '192.168.1.104', '2017-10-16 09:28:36', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1618, '172.31.17.170', '2017-10-16 09:29:34', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1619, '192.168.1.104', '2017-10-16 09:32:23', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1620, '172.31.17.170', '2017-10-16 09:32:43', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1621, '192.168.1.102', '2017-10-16 14:46:47', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1622, '192.168.1.102', '2017-10-16 14:46:49', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1623, '192.168.56.1', '2017-10-16 15:35:27', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1624, '192.168.1.102', '2017-10-16 15:54:05', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1625, '192.168.56.1', '2017-10-16 15:54:52', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1626, '192.168.1.102', '2017-10-16 15:58:06', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1627, '192.168.56.1', '2017-10-16 16:02:55', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1628, '192.168.1.102', '2017-10-16 16:36:46', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1629, '192.168.56.1', '2017-10-16 16:37:51', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1630, '192.168.56.1', '2017-10-16 16:42:00', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1631, '192.168.56.1', '2017-10-16 16:42:41', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1632, '192.168.56.1', '2017-10-16 16:42:46', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1633, '192.168.56.1', '2017-10-16 16:57:32', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1634, '192.168.56.1', '2017-10-16 16:57:33', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1635, '192.168.56.1', '2017-10-16 17:05:46', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1636, '192.168.56.1', '2017-10-16 17:05:49', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1637, '192.168.56.1', '2017-10-16 17:17:02', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1638, '192.168.56.1', '2017-10-16 17:24:32', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1639, '192.168.56.1', '2017-10-16 17:26:13', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1640, '192.168.56.1', '2017-10-16 17:26:23', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1641, '192.168.56.1', '2017-10-16 17:37:23', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1642, '192.168.56.1', '2017-10-16 17:45:58', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1643, '192.168.56.1', '2017-10-16 17:46:51', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1644, '192.168.56.1', '2017-10-16 17:46:54', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1645, '192.168.56.1', '2017-10-16 17:46:57', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1646, '192.168.1.157', '2017-10-16 18:14:39', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1647, '192.168.1.157', '2017-10-16 18:14:42', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (1648, '192.168.1.157', '2017-10-16 18:14:43', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1649, '192.168.1.157', '2017-10-16 18:14:44', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (1650, '192.168.1.157', '2017-10-16 18:14:45', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1651, '192.168.1.157', '2017-10-16 18:14:45', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (1652, '192.168.56.1', '2017-10-16 18:17:20', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1653, '192.168.1.157', '2017-10-16 18:33:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1654, '172.27.198.122', '2017-10-16 19:08:31', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1655, '172.31.17.170', '2017-10-16 19:32:18', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1656, '172.27.198.122', '2017-10-16 19:33:26', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1657, '192.168.1.104', '2017-10-16 21:30:38', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1658, '192.168.1.104', '2017-10-16 21:32:22', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1659, '192.168.56.1', '2017-10-17 14:49:13', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1660, '172.27.198.122', '2017-10-17 15:20:51', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1661, '172.27.198.122', '2017-10-17 15:27:27', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1662, '172.27.198.122', '2017-10-17 15:27:37', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1663, '192.168.56.1', '2017-10-17 15:28:18', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1664, '172.27.198.122', '2017-10-17 15:37:49', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1665, '172.27.198.122', '2017-10-17 15:38:21', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (1666, '172.27.198.122', '2017-10-17 15:53:12', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1667, '192.168.56.1', '2017-10-17 15:54:10', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1668, '172.31.17.170', '2017-10-17 16:17:34', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1669, '172.31.17.170', '2017-10-17 16:17:48', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1670, '192.168.56.1', '2017-10-17 16:18:48', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1671, '172.27.198.122', '2017-10-17 16:22:00', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1672, '192.168.56.1', '2017-10-17 16:22:47', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1673, '192.168.56.1', '2017-10-17 16:23:17', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1674, '172.27.198.122', '2017-10-17 16:45:12', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1675, '192.168.56.1', '2017-10-17 16:45:27', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1676, '172.27.198.122', '2017-10-17 16:47:41', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1677, '192.168.56.1', '2017-10-17 16:49:19', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1678, '172.27.198.122', '2017-10-17 16:49:22', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1679, '192.168.56.1', '2017-10-17 16:54:48', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1680, '172.27.198.122', '2017-10-17 17:07:59', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1681, '172.27.198.122', '2017-10-17 17:11:01', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1682, '172.27.198.122', '2017-10-17 17:21:01', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1683, '172.27.198.122', '2017-10-17 17:21:17', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1684, '192.168.56.1', '2017-10-17 17:35:15', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1685, '172.27.198.122', '2017-10-17 17:35:48', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1686, '172.27.198.122', '2017-10-17 17:35:54', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1687, '192.168.56.1', '2017-10-17 17:40:36', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1688, '172.27.198.122', '2017-10-17 17:44:19', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1689, '172.27.198.122', '2017-10-17 17:44:49', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1690, '192.168.56.1', '2017-10-17 17:52:42', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1691, '172.27.198.122', '2017-10-17 17:53:48', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1692, '172.27.198.122', '2017-10-17 17:53:51', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (1693, '172.27.198.122', '2017-10-17 17:53:54', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (1694, '172.27.198.122', '2017-10-17 17:53:56', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1695, '192.168.56.1', '2017-10-17 17:54:12', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1696, '172.27.198.122', '2017-10-17 17:55:55', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (1697, '192.168.56.1', '2017-10-17 17:57:28', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1698, '172.27.198.122', '2017-10-17 17:57:42', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (1699, '192.168.56.1', '2017-10-17 18:00:27', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1700, '172.27.198.122', '2017-10-17 18:17:28', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1701, '192.168.56.1', '2017-10-17 18:17:27', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1702, '192.168.56.1', '2017-10-17 18:17:34', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1703, '172.27.198.122', '2017-10-17 18:17:43', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1704, '192.168.56.1', '2017-10-17 18:17:47', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1705, '172.27.198.122', '2017-10-17 18:19:25', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1706, '172.31.17.170', '2017-10-17 19:56:34', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1707, '192.168.56.1', '2017-10-17 19:56:56', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1708, '172.31.17.170', '2017-10-17 19:57:27', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1709, '172.31.17.170', '2017-10-17 19:57:42', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1710, '192.168.56.1', '2017-10-17 19:58:55', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1711, '192.168.43.91', '2017-10-17 20:35:53', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1712, '192.168.56.1', '2017-10-17 20:37:36', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1713, '192.168.56.1', '2017-10-17 20:56:55', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1714, '192.168.56.1', '2017-10-17 20:56:58', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1715, '192.168.56.1', '2017-10-17 21:01:17', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1716, '172.27.198.122', '2017-10-17 21:52:15', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1717, '192.168.56.1', '2017-10-17 21:53:02', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1718, '192.168.56.1', '2017-10-17 21:56:17', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1719, '192.168.1.111', '2017-10-17 23:27:03', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1720, '172.31.17.170', '2017-10-18 11:25:21', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (1721, '172.27.198.122', '2017-10-18 14:34:49', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1722, '172.27.198.122', '2017-10-18 14:39:31', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1723, '172.27.198.122', '2017-10-18 14:44:41', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1724, '172.27.198.122', '2017-10-18 15:15:09', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1725, '172.27.198.122', '2017-10-18 15:21:39', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1726, '172.31.17.170', '2017-10-18 15:27:45', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (1727, '172.31.17.170', '2017-10-18 15:29:39', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1728, '172.27.198.122', '2017-10-18 15:34:35', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1729, '172.31.17.170', '2017-10-18 15:38:44', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1730, '172.27.198.122', '2017-10-18 15:41:44', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1731, '172.31.17.170', '2017-10-18 15:44:47', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1732, '172.31.17.170', '2017-10-18 15:44:50', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1733, '172.31.17.170', '2017-10-18 15:44:53', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1734, '172.31.17.170', '2017-10-18 15:44:58', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1735, '172.31.17.170', '2017-10-18 15:45:10', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1736, '172.31.17.170', '2017-10-18 15:50:10', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1737, '172.31.17.170', '2017-10-18 15:51:04', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1738, '172.31.17.170', '2017-10-18 15:53:07', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1739, '192.168.56.1', '2017-10-18 15:53:24', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1740, '172.31.17.170', '2017-10-18 15:53:33', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1741, '192.168.56.1', '2017-10-18 15:53:32', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1742, '192.168.56.1', '2017-10-18 15:53:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1743, '192.168.56.1', '2017-10-18 15:53:45', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (1744, '172.31.17.170', '2017-10-18 15:54:01', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1745, '172.31.17.170', '2017-10-18 15:54:07', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1746, '172.31.17.170', '2017-10-18 15:55:04', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1747, '172.31.17.170', '2017-10-18 15:55:09', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1748, '172.31.17.170', '2017-10-18 15:55:12', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1749, '172.31.17.170', '2017-10-18 15:55:15', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1750, '172.31.17.170', '2017-10-18 15:55:20', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1751, '172.27.198.122', '2017-10-18 15:56:02', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1752, '172.31.17.170', '2017-10-18 15:56:35', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1753, '172.27.198.122', '2017-10-18 15:56:43', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1754, '192.168.56.1', '2017-10-18 15:58:41', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1755, '192.168.56.1', '2017-10-18 15:58:47', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1756, '192.168.56.1', '2017-10-18 15:58:50', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1757, '192.168.56.1', '2017-10-18 15:59:00', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1758, '192.168.56.1', '2017-10-18 16:00:51', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1759, '192.168.56.1', '2017-10-18 16:02:38', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1760, '172.27.198.122', '2017-10-18 16:03:24', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1761, '192.168.56.1', '2017-10-18 16:05:15', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1762, '172.31.17.170', '2017-10-18 16:07:51', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1763, '192.168.56.1', '2017-10-18 16:08:48', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1764, '172.31.17.170', '2017-10-18 16:09:05', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1765, '192.168.56.1', '2017-10-18 16:10:20', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1766, '192.168.56.1', '2017-10-18 16:10:39', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1767, '172.31.17.170', '2017-10-18 16:11:33', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1768, '172.31.17.170', '2017-10-18 16:12:14', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1769, '172.31.17.170', '2017-10-18 16:12:21', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1770, '172.27.198.122', '2017-10-18 16:13:30', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1771, '172.31.17.170', '2017-10-18 16:13:37', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1772, '172.31.17.170', '2017-10-18 16:15:07', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1773, '172.31.17.170', '2017-10-18 16:15:26', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1774, '172.31.17.170', '2017-10-18 16:15:34', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1775, '172.31.17.170', '2017-10-18 16:15:41', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1776, '172.31.17.170', '2017-10-18 16:15:56', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1777, '172.31.17.170', '2017-10-18 16:16:01', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1778, '172.27.198.122', '2017-10-18 16:16:05', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1779, '172.31.17.170', '2017-10-18 16:16:27', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1780, '172.31.17.170', '2017-10-18 16:16:50', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1781, '172.31.17.170', '2017-10-18 16:16:56', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1782, '172.31.17.170', '2017-10-18 16:16:59', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1783, '172.31.17.170', '2017-10-18 16:17:03', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1784, '172.31.17.170', '2017-10-18 16:17:06', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1785, '172.27.198.122', '2017-10-18 16:19:05', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1786, '192.168.56.1', '2017-10-18 16:19:17', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1787, '172.27.198.122', '2017-10-18 16:19:22', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1788, '172.27.198.122', '2017-10-18 16:19:35', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1789, '192.168.56.1', '2017-10-18 16:20:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1790, '172.27.198.122', '2017-10-18 16:21:31', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1791, '172.31.17.170', '2017-10-18 16:22:41', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1792, '172.31.17.170', '2017-10-18 16:23:01', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1793, '172.31.17.170', '2017-10-18 16:23:03', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1794, '172.31.17.170', '2017-10-18 16:23:10', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1795, '172.27.198.122', '2017-10-18 16:23:42', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1796, '172.31.17.170', '2017-10-18 16:23:59', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1797, '172.27.198.122', '2017-10-18 16:25:36', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1798, '192.168.56.1', '2017-10-18 16:26:57', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1799, '172.27.198.122', '2017-10-18 16:27:00', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1800, '172.31.17.170', '2017-10-18 16:27:07', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1801, '192.168.56.1', '2017-10-18 16:29:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1802, '172.31.17.170', '2017-10-18 16:30:22', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1803, '172.31.17.170', '2017-10-18 16:30:42', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1804, '172.31.17.170', '2017-10-18 16:30:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1805, '172.31.17.170', '2017-10-18 16:30:49', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1806, '172.31.17.170', '2017-10-18 16:30:53', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1807, '172.31.17.170', '2017-10-18 16:30:58', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1808, '172.31.17.170', '2017-10-18 16:31:01', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1809, '172.31.17.170', '2017-10-18 16:31:03', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1810, '172.31.17.170', '2017-10-18 16:31:05', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1811, '172.31.17.170', '2017-10-18 16:32:51', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1812, '192.168.56.1', '2017-10-18 16:33:17', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1813, '172.31.17.170', '2017-10-18 16:38:33', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1814, '192.168.56.1', '2017-10-18 16:39:29', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1815, '172.31.17.170', '2017-10-18 16:40:39', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1816, '172.27.198.122', '2017-10-18 16:42:04', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1817, '192.168.56.1', '2017-10-18 16:42:23', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1818, '172.31.17.170', '2017-10-18 16:45:44', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1819, '172.27.198.122', '2017-10-18 16:45:42', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1820, '172.27.198.122', '2017-10-18 16:45:43', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1821, '172.31.17.170', '2017-10-18 16:45:52', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1822, '172.31.17.170', '2017-10-18 16:45:55', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1823, '172.31.17.170', '2017-10-18 16:45:58', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1824, '172.31.17.170', '2017-10-18 16:46:01', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1825, '172.31.17.170', '2017-10-18 16:46:03', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1826, '172.27.198.122', '2017-10-18 16:46:48', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1827, '172.31.17.170', '2017-10-18 16:47:20', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1828, '172.31.17.170', '2017-10-18 16:47:24', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1829, '172.27.198.122', '2017-10-18 16:47:55', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1830, '192.168.56.1', '2017-10-18 16:47:55', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1831, '172.31.17.170', '2017-10-18 16:48:08', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1832, '172.27.198.122', '2017-10-18 16:48:07', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1833, '172.31.17.170', '2017-10-18 16:48:11', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1834, '172.31.17.170', '2017-10-18 16:48:14', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1835, '172.27.198.122', '2017-10-18 16:48:44', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1836, '192.168.56.1', '2017-10-18 16:50:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1837, '172.27.198.122', '2017-10-18 16:51:50', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1838, '192.168.56.1', '2017-10-18 16:51:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1839, '172.27.198.122', '2017-10-18 16:53:05', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1840, '192.168.56.1', '2017-10-18 16:54:12', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1841, '172.27.198.122', '2017-10-18 16:54:20', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1842, '192.168.56.1', '2017-10-18 16:55:35', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1843, '172.31.17.170', '2017-10-18 16:55:53', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1844, '172.31.17.170', '2017-10-18 16:55:57', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1845, '192.168.56.1', '2017-10-18 16:56:54', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1846, '172.31.17.170', '2017-10-18 16:56:59', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1847, '172.31.17.170', '2017-10-18 16:57:32', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1848, '172.31.17.170', '2017-10-18 16:57:36', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1849, '172.31.17.170', '2017-10-18 16:57:38', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1850, '192.168.56.1', '2017-10-18 17:00:41', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1851, '172.27.198.122', '2017-10-18 17:01:26', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1852, '192.168.56.1', '2017-10-18 17:01:50', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1853, '172.27.198.122', '2017-10-18 17:03:23', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1854, '192.168.56.1', '2017-10-18 17:04:58', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1855, '192.168.56.1', '2017-10-18 17:06:18', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1856, '172.27.198.122', '2017-10-18 17:08:17', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1857, '192.168.56.1', '2017-10-18 17:08:16', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1858, '192.168.56.1', '2017-10-18 17:08:31', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1859, '192.168.56.1', '2017-10-18 17:14:10', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1860, '192.168.56.1', '2017-10-18 17:16:10', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1861, '172.27.198.122', '2017-10-18 17:21:48', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1862, '192.168.56.1', '2017-10-18 17:21:49', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1863, '192.168.56.1', '2017-10-18 17:22:38', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1864, '192.168.56.1', '2017-10-18 17:22:47', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1865, '192.168.56.1', '2017-10-18 17:23:10', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1866, '172.27.198.122', '2017-10-18 17:23:17', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1867, '192.168.56.1', '2017-10-18 17:24:10', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1868, '192.168.56.1', '2017-10-18 17:25:09', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1869, '192.168.56.1', '2017-10-18 17:28:54', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1870, '172.27.198.122', '2017-10-18 17:29:41', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1871, '192.168.56.1', '2017-10-18 17:31:30', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1872, '192.168.56.1', '2017-10-18 17:31:36', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1873, '172.27.198.122', '2017-10-18 17:35:17', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1874, '192.168.56.1', '2017-10-18 17:35:33', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1875, '172.27.198.122', '2017-10-18 17:35:57', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1876, '192.168.56.1', '2017-10-18 17:38:16', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1877, '192.168.56.1', '2017-10-18 17:38:20', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1878, '192.168.56.1', '2017-10-18 17:39:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1879, '172.27.198.122', '2017-10-18 17:40:26', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1880, '192.168.56.1', '2017-10-18 17:42:21', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1881, '172.27.198.122', '2017-10-18 17:42:59', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1882, '192.168.56.1', '2017-10-18 17:43:01', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1883, '192.168.56.1', '2017-10-18 17:43:12', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1884, '192.168.56.1', '2017-10-18 17:43:18', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1885, '192.168.56.1', '2017-10-18 17:44:38', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1886, '172.27.198.122', '2017-10-18 17:45:31', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1887, '192.168.56.1', '2017-10-18 17:45:38', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1888, '172.27.198.122', '2017-10-18 17:45:48', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1889, '192.168.56.1', '2017-10-18 18:11:01', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1890, '192.168.1.157', '2017-10-18 18:15:09', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1891, '192.168.56.1', '2017-10-18 18:15:34', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1892, '192.168.1.186', '2017-10-18 18:15:48', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1893, '192.168.1.186', '2017-10-18 18:15:49', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1894, '192.168.1.186', '2017-10-18 18:15:55', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1895, '192.168.1.157', '2017-10-18 18:16:05', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1896, '192.168.1.186', '2017-10-18 18:16:17', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1897, '192.168.56.1', '2017-10-18 18:16:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1898, '192.168.1.186', '2017-10-18 18:16:33', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1899, '192.168.1.186', '2017-10-18 18:16:53', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1900, '192.168.1.157', '2017-10-18 18:17:42', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1901, '192.168.1.157', '2017-10-18 18:17:44', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1902, '192.168.1.157', '2017-10-18 18:19:15', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1903, '192.168.1.157', '2017-10-18 18:19:17', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1904, '192.168.1.186', '2017-10-18 18:19:28', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1905, '192.168.1.157', '2017-10-18 18:23:56', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1906, '192.168.1.157', '2017-10-18 18:28:25', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1907, '172.20.10.14', '2017-10-18 18:38:22', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1908, '172.20.10.14', '2017-10-18 18:38:42', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1909, '192.168.56.1', '2017-10-18 19:45:21', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1910, '192.168.56.1', '2017-10-18 19:45:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1911, '172.20.10.14', '2017-10-18 19:50:19', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1912, '172.20.10.14', '2017-10-18 19:50:26', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (1913, '192.168.56.1', '2017-10-18 19:52:44', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1914, '192.168.56.1', '2017-10-18 19:55:31', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (1915, '192.168.1.233', '2017-10-19 19:43:48', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1916, '192.168.1.233', '2017-10-19 19:51:52', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1917, '192.168.1.233', '2017-10-19 20:14:52', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1918, '172.31.17.170', '2017-10-19 22:04:44', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1919, '192.168.56.1', '2017-10-19 22:31:01', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1920, '192.168.56.1', '2017-10-19 22:31:04', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1921, '192.168.56.1', '2017-10-19 22:31:06', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1922, '192.168.56.1', '2017-10-19 22:31:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1923, '192.168.56.1', '2017-10-19 22:32:15', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1924, '192.168.56.1', '2017-10-19 22:42:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1925, '192.168.56.1', '2017-10-19 22:42:56', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1926, '192.168.56.1', '2017-10-19 22:45:21', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (1927, '192.168.56.1', '2017-10-19 22:45:23', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1928, '192.168.56.1', '2017-10-19 22:45:29', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1929, '192.168.56.1', '2017-10-19 22:45:33', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1930, '192.168.56.1', '2017-10-19 22:45:40', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1931, '192.168.56.1', '2017-10-19 22:45:46', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1932, '192.168.56.1', '2017-10-19 22:45:49', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1933, '192.168.56.1', '2017-10-19 22:45:53', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (1934, '192.168.56.1', '2017-10-19 22:45:57', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1935, '192.168.56.1', '2017-10-19 22:46:00', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1936, '192.168.56.1', '2017-10-19 22:46:05', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (1937, '192.168.56.1', '2017-10-19 22:46:10', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1938, '192.168.56.1', '2017-10-19 22:56:30', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1939, '192.168.56.1', '2017-10-19 22:58:19', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1940, '192.168.56.1', '2017-10-19 22:58:23', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1941, '192.168.56.1', '2017-10-19 23:14:54', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1942, '192.168.56.1', '2017-10-19 23:15:26', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1943, '192.168.56.1', '2017-10-19 23:16:23', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (1944, '192.168.56.1', '2017-10-19 23:16:26', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1945, '192.168.56.1', '2017-10-19 23:16:33', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1946, '192.168.56.1', '2017-10-19 23:16:34', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1947, '192.168.56.1', '2017-10-19 23:16:36', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1948, '192.168.56.1', '2017-10-19 23:17:38', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1949, '192.168.56.1', '2017-10-19 23:32:41', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1950, '192.168.56.1', '2017-10-19 23:32:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1951, '192.168.56.1', '2017-10-19 23:32:46', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1952, '192.168.56.1', '2017-10-19 23:32:50', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1953, '192.168.56.1', '2017-10-19 23:32:55', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1954, '192.168.56.1', '2017-10-19 23:32:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1955, '192.168.56.1', '2017-10-19 23:35:32', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1956, '192.168.1.157', '2017-10-19 23:36:43', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1957, '192.168.56.1', '2017-10-19 23:37:24', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1958, '192.168.1.157', '2017-10-19 23:37:40', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1959, '192.168.56.1', '2017-10-19 23:38:34', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1960, '192.168.56.1', '2017-10-19 23:38:37', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1961, '192.168.56.1', '2017-10-19 23:42:34', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1962, '192.168.56.1', '2017-10-19 23:42:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1963, '192.168.56.1', '2017-10-19 23:43:33', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1964, '192.168.56.1', '2017-10-19 23:44:58', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (1965, '192.168.1.157', '2017-10-19 23:53:24', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1966, '192.168.43.91', '2017-10-20 00:06:35', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1967, '192.168.43.91', '2017-10-20 00:06:34', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1968, '172.31.17.170', '2017-10-20 08:15:58', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1969, '172.31.17.170', '2017-10-20 08:18:02', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1970, '172.31.17.170', '2017-10-20 08:18:09', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (1971, '172.31.17.170', '2017-10-20 08:19:43', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1972, '172.31.17.170', '2017-10-20 08:19:45', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1973, '172.31.17.170', '2017-10-20 08:19:49', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1974, '172.31.17.170', '2017-10-20 08:19:53', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1975, '172.31.17.170', '2017-10-20 08:19:56', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1976, '172.31.17.170', '2017-10-20 08:19:59', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (1977, '172.31.17.170', '2017-10-20 08:20:02', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (1978, '172.31.17.170', '2017-10-20 09:27:14', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (1979, '172.31.17.170', '2017-10-20 09:32:52', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (1980, '172.31.17.170', '2017-10-20 09:36:28', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1981, '172.31.17.170', '2017-10-20 09:45:21', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1982, '172.31.17.170', '2017-10-20 09:45:31', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1983, '172.31.17.170', '2017-10-20 09:45:34', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1984, '172.31.17.170', '2017-10-20 09:45:41', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1985, '172.31.17.170', '2017-10-20 09:47:04', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1986, '172.31.17.170', '2017-10-20 09:48:23', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1987, '172.31.17.170', '2017-10-20 09:59:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1988, '172.31.17.170', '2017-10-20 10:00:24', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1989, '172.31.17.170', '2017-10-20 10:00:38', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1990, '172.31.17.170', '2017-10-20 10:00:51', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (1991, '172.31.17.170', '2017-10-20 10:01:03', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (1992, '172.31.17.170', '2017-10-20 10:02:51', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (1993, '172.31.17.170', '2017-10-20 10:03:05', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (1994, '172.31.17.170', '2017-10-20 10:03:18', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (1995, '172.31.17.170', '2017-10-20 10:04:08', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (1996, '172.31.17.170', '2017-10-20 10:05:25', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (1997, '172.31.17.170', '2017-10-20 10:09:17', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (1998, '172.31.17.170', '2017-10-20 10:09:21', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (1999, '172.31.17.170', '2017-10-20 10:09:27', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2000, '172.31.17.170', '2017-10-20 10:12:14', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2001, '172.31.17.170', '2017-10-20 10:12:34', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2002, '172.31.17.170', '2017-10-20 10:12:44', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (2003, '172.31.17.170', '2017-10-20 10:12:47', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (2004, '172.31.17.170', '2017-10-20 10:13:33', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2005, '172.31.17.170', '2017-10-20 10:19:10', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2006, '172.31.17.170', '2017-10-20 10:19:31', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2007, '172.31.17.170', '2017-10-20 10:19:43', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2008, '172.31.17.170', '2017-10-20 10:21:34', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2009, '172.31.17.170', '2017-10-20 10:21:39', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2010, '172.31.17.170', '2017-10-20 10:35:13', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2011, '172.31.17.170', '2017-10-20 10:35:19', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2012, '172.31.17.170', '2017-10-20 10:37:10', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2013, '172.31.17.170', '2017-10-20 10:37:14', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2014, '172.31.17.170', '2017-10-20 10:40:12', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2015, '172.31.17.170', '2017-10-20 10:41:00', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2016, '172.31.17.170', '2017-10-20 10:41:04', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2017, '172.31.17.170', '2017-10-20 10:41:10', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (2018, '172.31.17.170', '2017-10-20 10:41:16', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2019, '172.31.17.170', '2017-10-20 10:41:21', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2020, '172.31.17.170', '2017-10-20 10:41:23', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2021, '172.31.17.170', '2017-10-20 11:03:50', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2022, '172.31.17.170', '2017-10-20 11:04:55', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2023, '172.31.17.170', '2017-10-20 11:04:59', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2024, '192.168.56.1', '2017-10-20 12:58:47', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (2025, '192.168.56.1', '2017-10-20 12:59:04', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2026, '192.168.56.1', '2017-10-20 12:59:17', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (2027, '192.168.56.1', '2017-10-20 13:00:07', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2028, '192.168.56.1', '2017-10-20 13:00:13', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2029, '192.168.56.1', '2017-10-20 21:08:58', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2030, '192.168.56.1', '2017-10-20 21:09:14', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2031, '192.168.56.1', '2017-10-20 21:09:19', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2032, '192.168.56.1', '2017-10-20 21:10:45', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2033, '192.168.56.1', '2017-10-20 21:14:28', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (2034, '192.168.56.1', '2017-10-20 21:16:54', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2035, '192.168.56.1', '2017-10-20 21:20:14', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (2036, '172.27.198.122', '2017-10-20 21:23:07', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (2037, '172.27.198.122', '2017-10-20 21:24:02', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (2038, '172.27.198.122', '2017-10-20 21:24:10', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (2039, '192.168.56.1', '2017-10-20 21:24:18', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2040, '172.27.198.122', '2017-10-20 21:24:51', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (2041, '172.27.198.122', '2017-10-20 21:30:14', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2042, '172.31.17.170', '2017-10-20 23:42:49', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2043, '172.31.17.170', '2017-10-20 23:43:01', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2044, '172.31.17.170', '2017-10-20 23:43:33', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2045, '172.31.17.170', '2017-10-20 23:43:48', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2046, '172.31.17.170', '2017-10-20 23:44:05', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (2047, '172.31.17.170', '2017-10-20 23:44:10', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (2048, '172.31.17.170', '2017-10-20 23:46:32', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2049, '172.31.17.170', '2017-10-20 23:46:38', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2050, '172.31.17.170', '2017-10-20 23:46:44', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (2051, '172.31.17.170', '2017-10-20 23:46:49', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (2052, '172.31.17.170', '2017-10-20 23:54:43', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2053, '172.31.17.170', '2017-10-20 23:54:57', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2054, '172.31.17.170', '2017-10-20 23:57:16', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2055, '172.31.17.170', '2017-10-21 00:30:56', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2056, '172.31.17.170', '2017-10-21 00:31:01', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2057, '172.31.17.170', '2017-10-21 00:32:40', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2058, '172.31.17.170', '2017-10-21 00:32:44', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2059, '172.31.17.170', '2017-10-21 00:32:53', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2060, '172.31.17.170', '2017-10-21 00:36:44', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2061, '172.31.17.170', '2017-10-21 00:51:45', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2062, '172.31.17.170', '2017-10-21 00:51:49', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2063, '172.31.17.170', '2017-10-21 00:51:54', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2064, '172.31.17.170', '2017-10-21 00:54:38', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2065, '172.31.17.170', '2017-10-21 00:54:39', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2066, '172.31.17.170', '2017-10-21 00:57:19', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2067, '172.31.17.170', '2017-10-21 00:57:19', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2068, '172.31.17.170', '2017-10-21 00:59:50', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2069, '172.31.17.170', '2017-10-21 01:00:21', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2070, '172.31.17.170', '2017-10-21 01:00:25', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2071, '172.31.17.170', '2017-10-21 01:35:26', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2072, '172.31.17.170', '2017-10-21 01:35:28', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2073, '172.31.17.170', '2017-10-21 01:35:31', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2074, '172.31.17.170', '2017-10-21 01:35:33', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2075, '172.31.17.170', '2017-10-21 01:35:37', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2076, '172.31.17.170', '2017-10-21 01:35:41', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2077, '172.31.17.170', '2017-10-21 01:35:46', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2078, '172.31.17.170', '2017-10-21 15:06:16', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2079, '172.31.17.170', '2017-10-21 15:06:24', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2080, '172.31.17.170', '2017-10-21 15:06:28', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2081, '172.31.17.170', '2017-10-21 15:06:33', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2082, '172.31.17.170', '2017-10-21 15:06:36', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2083, '172.31.17.170', '2017-10-21 15:07:53', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (2084, '172.31.17.170', '2017-10-21 15:08:17', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2085, '172.31.17.170', '2017-10-21 15:08:22', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2086, '172.31.17.170', '2017-10-21 15:08:28', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2087, '172.31.17.170', '2017-10-21 15:12:13', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2088, '172.31.17.170', '2017-10-21 15:12:44', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2089, '172.31.17.170', '2017-10-21 15:12:50', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2090, '172.31.17.170', '2017-10-21 15:14:13', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2091, '172.31.17.170', '2017-10-21 15:14:55', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2092, '172.31.17.170', '2017-10-21 15:48:53', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2093, '172.31.17.170', '2017-10-21 16:06:09', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2094, '172.31.17.170', '2017-10-21 16:06:14', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (2095, '172.31.17.170', '2017-10-21 16:18:53', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2096, '172.31.17.170', '2017-10-21 16:18:56', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2097, '172.31.17.170', '2017-10-21 16:18:59', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2098, '172.31.17.170', '2017-10-21 16:19:24', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2099, '172.31.17.170', '2017-10-21 16:19:28', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2100, '172.31.17.170', '2017-10-21 16:37:56', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2101, '172.31.17.170', '2017-10-21 16:38:00', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2102, '172.31.17.170', '2017-10-21 17:17:41', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2103, '172.31.17.170', '2017-10-21 17:17:43', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2104, '172.31.17.170', '2017-10-21 18:01:45', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2105, '172.31.17.170', '2017-10-21 18:01:47', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (2106, '172.31.17.170', '2017-10-21 18:01:47', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2107, '172.31.17.170', '2017-10-21 18:03:45', '在线用户', '/userlogmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2108, '172.31.17.170', '2017-10-21 18:51:54', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2109, '192.168.1.157', '2017-10-21 19:48:24', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2110, '192.168.1.157', '2017-10-21 19:52:00', '在线用户', '/morelogrecord', 2);
INSERT INTO `aoa_user_log` VALUES (2111, '172.31.17.170', '2017-10-21 19:54:29', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2112, '192.168.1.157', '2017-10-21 19:56:27', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2113, '172.31.17.170', '2017-10-21 20:00:51', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2114, '172.31.17.170', '2017-10-21 20:02:18', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2115, '172.31.17.170', '2017-10-21 20:02:35', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2116, '172.31.17.170', '2017-10-21 20:03:57', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2117, '172.31.17.170', '2017-10-21 20:04:01', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2118, '172.31.17.170', '2017-10-21 20:04:10', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2119, '172.31.17.170', '2017-10-21 20:04:17', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (2120, '172.31.17.170', '2017-10-21 20:04:17', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2121, '172.31.17.170', '2017-10-21 20:05:41', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2122, '172.31.17.170', '2017-10-21 20:07:13', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2123, '172.31.17.170', '2017-10-21 20:08:09', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2124, '172.31.17.170', '2017-10-22 00:16:48', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2125, '172.31.17.170', '2017-10-22 00:16:53', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2126, '172.31.17.170', '2017-10-22 00:17:04', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2127, '172.31.17.170', '2017-10-22 00:36:14', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2128, '172.31.17.170', '2017-10-22 00:36:25', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2129, '172.31.17.170', '2017-10-22 00:36:34', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2130, '172.31.17.170', '2017-10-22 08:23:14', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2131, '172.31.17.170', '2017-10-22 08:23:23', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2132, '172.31.17.170', '2017-10-22 08:23:25', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2133, '172.31.17.170', '2017-10-22 08:25:19', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2134, '172.31.17.170', '2017-10-22 08:28:08', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2135, '172.31.17.170', '2017-10-22 08:28:12', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2136, '172.31.17.170', '2017-10-22 08:28:17', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2137, '172.31.17.170', '2017-10-22 08:28:45', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2138, '172.31.17.170', '2017-10-22 08:29:01', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2139, '172.31.17.170', '2017-10-22 08:30:16', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2140, '172.31.17.170', '2017-10-22 08:32:26', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2141, '172.31.17.170', '2017-10-22 08:32:31', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2142, '172.31.17.170', '2017-10-22 08:32:34', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2143, '172.31.17.170', '2017-10-22 08:32:44', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2144, '172.31.17.170', '2017-10-22 08:34:53', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2145, '172.31.17.170', '2017-10-22 08:35:01', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2146, '172.31.17.170', '2017-10-22 08:58:45', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2147, '172.31.17.170', '2017-10-22 09:00:35', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2148, '172.27.198.122', '2017-10-22 10:10:53', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2149, '172.27.198.122', '2017-10-22 10:11:04', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (2150, '192.168.1.233', '2017-10-22 10:17:30', '在线用户', '/morelogrecord', 3);
INSERT INTO `aoa_user_log` VALUES (2151, '192.168.1.233', '2017-10-22 10:17:37', '职位管理', '/positionmanage', 3);
INSERT INTO `aoa_user_log` VALUES (2152, '192.168.1.233', '2017-10-22 10:20:39', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2153, '192.168.1.233', '2017-10-22 10:21:14', '用户管理', '/usermanage', 3);
INSERT INTO `aoa_user_log` VALUES (2154, '192.168.1.233', '2017-10-22 10:23:28', '用户管理', '/usermanage', 3);
INSERT INTO `aoa_user_log` VALUES (2155, '192.168.1.233', '2017-10-22 10:27:41', '考勤管理', '/attendceatt', 3);
INSERT INTO `aoa_user_log` VALUES (2156, '192.168.1.233', '2017-10-22 10:28:01', '考勤管理', '/attendceatt', 3);
INSERT INTO `aoa_user_log` VALUES (2157, '192.168.1.233', '2017-10-22 10:28:47', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2158, '192.168.1.233', '2017-10-22 10:29:15', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2159, '192.168.1.233', '2017-10-22 10:29:23', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2160, '192.168.1.233', '2017-10-22 10:29:27', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2161, '192.168.1.233', '2017-10-22 10:29:35', '计划管理', '/planview', 7);
INSERT INTO `aoa_user_log` VALUES (2162, '192.168.1.233', '2017-10-22 10:32:36', '计划管理', '/planview', 7);
INSERT INTO `aoa_user_log` VALUES (2163, '192.168.1.233', '2017-10-22 10:32:44', '计划报表', '/myplan', 7);
INSERT INTO `aoa_user_log` VALUES (2164, '192.168.1.233', '2017-10-22 10:32:47', '计划报表', '/myplan', 7);
INSERT INTO `aoa_user_log` VALUES (2165, '192.168.1.233', '2017-10-22 10:33:15', '用户管理', '/usermanage', 3);
INSERT INTO `aoa_user_log` VALUES (2166, '192.168.1.233', '2017-10-22 10:33:32', '计划管理', '/planview', 3);
INSERT INTO `aoa_user_log` VALUES (2167, '192.168.1.233', '2017-10-22 10:33:36', '计划报表', '/myplan', 3);
INSERT INTO `aoa_user_log` VALUES (2168, '192.168.1.233', '2017-10-22 10:34:31', '我的管理', '/chatmanage', 3);
INSERT INTO `aoa_user_log` VALUES (2169, '192.168.1.233', '2017-10-22 10:34:37', '讨论区列表', '/chatlist', 3);
INSERT INTO `aoa_user_log` VALUES (2170, '192.168.1.157', '2017-10-22 10:36:11', '讨论区列表', '/chatlist', 5);
INSERT INTO `aoa_user_log` VALUES (2171, '192.168.1.233', '2017-10-22 10:38:03', '计划报表', '/myplan', 3);
INSERT INTO `aoa_user_log` VALUES (2172, '192.168.1.233', '2017-10-22 10:43:22', '计划报表', '/myplan', 3);
INSERT INTO `aoa_user_log` VALUES (2173, '192.168.1.233', '2017-10-22 10:44:09', '计划报表', '/myplan', 3);
INSERT INTO `aoa_user_log` VALUES (2174, '192.168.1.233', '2017-10-22 10:48:23', '考勤管理', '/attendceatt', 3);
INSERT INTO `aoa_user_log` VALUES (2175, '192.168.1.233', '2017-10-22 10:48:26', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2176, '192.168.1.233', '2017-10-22 10:49:07', '考勤管理', '/attendceatt', 3);
INSERT INTO `aoa_user_log` VALUES (2177, '192.168.1.233', '2017-10-22 10:49:30', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2178, '192.168.1.233', '2017-10-22 10:50:01', '考勤管理', '/attendceatt', 3);
INSERT INTO `aoa_user_log` VALUES (2179, '192.168.1.233', '2017-10-22 10:50:13', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2180, '192.168.1.233', '2017-10-22 10:51:27', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2181, '192.168.1.233', '2017-10-22 10:51:51', '考勤管理', '/attendceatt', 3);
INSERT INTO `aoa_user_log` VALUES (2182, '192.168.1.233', '2017-10-22 10:51:56', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2183, '192.168.1.233', '2017-10-22 10:57:36', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2184, '192.168.1.233', '2017-10-22 11:00:44', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2185, '192.168.1.233', '2017-10-22 11:01:57', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2186, '192.168.1.233', '2017-10-22 11:04:08', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2187, '192.168.1.233', '2017-10-22 11:10:20', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2188, '192.168.1.233', '2017-10-22 11:11:32', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2189, '192.168.1.233', '2017-10-22 11:14:21', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2190, '192.168.1.233', '2017-10-22 11:16:04', '考勤月报表', '/attendcemonth', 3);
INSERT INTO `aoa_user_log` VALUES (2191, '192.168.1.233', '2017-10-22 11:17:06', '考勤列表', '/attendcelist', 3);
INSERT INTO `aoa_user_log` VALUES (2192, '192.168.1.233', '2017-10-22 11:17:12', '计划管理', '/planview', 3);
INSERT INTO `aoa_user_log` VALUES (2193, '192.168.1.233', '2017-10-22 11:17:15', '笔记管理', '/noteview', 3);
INSERT INTO `aoa_user_log` VALUES (2194, '192.168.1.233', '2017-10-22 11:17:53', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2195, '172.31.17.100', '2017-12-14 20:32:58', '通知列表', '/infromlist', 7);
INSERT INTO `aoa_user_log` VALUES (2196, '172.31.17.100', '2017-12-14 20:32:58', '通知列表', '/infromlist', 7);
INSERT INTO `aoa_user_log` VALUES (2197, '172.31.17.100', '2017-12-14 20:33:18', '部门管理', '/deptmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2198, '172.31.17.100', '2017-12-14 20:33:18', '部门管理', '/deptmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2199, '172.31.17.100', '2017-12-14 20:33:34', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2200, '172.31.17.100', '2017-12-14 20:33:34', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2201, '172.31.17.100', '2017-12-14 20:33:37', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2202, '172.31.17.100', '2017-12-14 20:33:37', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2203, '172.31.17.100', '2017-12-14 20:33:39', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2204, '172.31.17.100', '2017-12-14 20:33:39', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2205, '172.31.17.100', '2017-12-14 20:33:41', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2206, '172.31.17.100', '2017-12-14 20:33:41', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2207, '172.31.17.100', '2017-12-14 20:33:45', '流程审核', '/audit', 7);
INSERT INTO `aoa_user_log` VALUES (2208, '172.31.17.100', '2017-12-14 20:33:45', '流程审核', '/audit', 7);
INSERT INTO `aoa_user_log` VALUES (2209, '172.31.17.100', '2017-12-14 20:33:47', '我的申请', '/flowmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2210, '172.31.17.100', '2017-12-14 20:33:47', '我的申请', '/flowmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2211, '172.31.17.100', '2017-12-14 20:33:48', '新建流程', '/xinxeng', 7);
INSERT INTO `aoa_user_log` VALUES (2212, '172.31.17.100', '2017-12-14 20:33:48', '新建流程', '/xinxeng', 7);
INSERT INTO `aoa_user_log` VALUES (2213, '172.31.17.100', '2017-12-14 20:33:52', '通知管理', '/infrommanage', 7);
INSERT INTO `aoa_user_log` VALUES (2214, '172.31.17.100', '2017-12-14 20:33:52', '通知管理', '/infrommanage', 7);
INSERT INTO `aoa_user_log` VALUES (2215, '172.31.17.100', '2017-12-14 20:33:54', '通知列表', '/infromlist', 7);
INSERT INTO `aoa_user_log` VALUES (2216, '172.31.17.100', '2017-12-14 20:33:56', '通知列表', '/infromlist', 7);
INSERT INTO `aoa_user_log` VALUES (2217, '172.31.17.100', '2017-12-16 19:31:10', '我的管理', '/chatmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2218, '172.31.17.100', '2017-12-16 19:34:12', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2219, '172.31.17.100', '2017-12-16 19:34:13', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2220, '172.31.17.100', '2017-12-16 19:34:15', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2221, '172.31.17.100', '2017-12-16 19:34:15', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2222, '172.31.17.100', '2017-12-16 19:34:21', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2223, '172.31.17.100', '2017-12-16 19:34:30', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2224, '172.31.17.100', '2017-12-16 19:35:08', '职位管理', '/positionmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2225, '172.31.17.100', '2017-12-16 19:35:19', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2226, '172.31.17.100', '2017-12-16 19:35:21', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2227, '172.31.17.100', '2017-12-16 19:35:25', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2228, '172.31.17.100', '2017-12-16 19:35:35', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2229, '172.31.17.100', '2017-12-16 19:35:36', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2230, '172.27.93.0', '2017-12-20 10:18:13', '部门管理', '/deptmanage', 5);
INSERT INTO `aoa_user_log` VALUES (2231, '172.27.93.0', '2017-12-20 10:18:15', '在线用户', '/morelogrecord', 5);
INSERT INTO `aoa_user_log` VALUES (2232, '172.27.93.0', '2017-12-20 10:18:16', '职位管理', '/positionmanage', 5);
INSERT INTO `aoa_user_log` VALUES (2233, '172.27.93.0', '2017-12-20 10:18:38', '考勤管理', '/attendceatt', 5);
INSERT INTO `aoa_user_log` VALUES (2234, '172.27.93.0', '2017-12-20 10:18:39', '考勤周报表', '/attendceweek', 5);
INSERT INTO `aoa_user_log` VALUES (2235, '172.27.93.0', '2017-12-20 10:18:42', '考勤月报表', '/attendcemonth', 5);
INSERT INTO `aoa_user_log` VALUES (2236, '172.27.93.0', '2017-12-20 10:18:43', '考勤列表', '/attendcelist', 5);
INSERT INTO `aoa_user_log` VALUES (2237, '172.27.93.0', '2017-12-20 10:18:44', '考勤月报表', '/attendcemonth', 5);
INSERT INTO `aoa_user_log` VALUES (2238, '172.27.93.0', '2017-12-20 10:18:45', '新建流程', '/xinxeng', 5);
INSERT INTO `aoa_user_log` VALUES (2239, '172.27.93.0', '2017-12-20 10:18:48', '任务管理', '/taskmanage', 5);
INSERT INTO `aoa_user_log` VALUES (2240, '172.27.93.0', '2017-12-20 10:18:50', '我的任务', '/mytask', 5);
INSERT INTO `aoa_user_log` VALUES (2241, '172.27.93.0', '2017-12-20 10:18:53', '邮件管理', '/mail', 5);
INSERT INTO `aoa_user_log` VALUES (2242, '172.31.17.236', '2017-12-23 12:38:13', '部门管理', '/deptmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2243, '172.31.17.236', '2017-12-23 12:38:34', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2244, '172.31.17.236', '2017-12-23 12:38:38', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2245, '172.31.17.236', '2017-12-23 12:38:41', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2246, '172.31.17.236', '2017-12-23 12:38:44', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2247, '172.31.17.236', '2017-12-23 12:38:47', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2248, '172.31.17.236', '2017-12-23 12:38:51', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2249, '172.31.17.236', '2017-12-23 12:38:54', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2250, '172.31.17.236', '2017-12-23 12:39:04', '新建流程', '/xinxeng', 7);
INSERT INTO `aoa_user_log` VALUES (2251, '172.31.17.236', '2017-12-23 12:39:07', '我的申请', '/flowmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2252, '172.31.17.236', '2017-12-23 12:39:10', '流程审核', '/audit', 7);
INSERT INTO `aoa_user_log` VALUES (2253, '172.31.17.236', '2017-12-23 12:39:14', '通知管理', '/infrommanage', 7);
INSERT INTO `aoa_user_log` VALUES (2254, '172.31.17.236', '2017-12-23 12:39:17', '通知列表', '/infromlist', 7);
INSERT INTO `aoa_user_log` VALUES (2255, '172.31.17.236', '2017-12-23 12:39:20', '账号管理', '/accountmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2256, '172.31.17.236', '2017-12-23 12:39:22', '邮件管理', '/mail', 7);
INSERT INTO `aoa_user_log` VALUES (2257, '172.31.17.236', '2017-12-23 12:39:39', '任务管理', '/taskmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2258, '172.31.17.236', '2017-12-23 12:39:41', '我的任务', '/mytask', 7);
INSERT INTO `aoa_user_log` VALUES (2259, '172.31.17.236', '2017-12-23 12:39:44', '日程管理', '/daymanage', 7);
INSERT INTO `aoa_user_log` VALUES (2260, '172.31.17.236', '2017-12-23 12:39:46', '日程管理', '/daymanage', 7);
INSERT INTO `aoa_user_log` VALUES (2261, '172.31.17.236', '2017-12-23 12:39:47', '日程管理', '/daymanage', 7);
INSERT INTO `aoa_user_log` VALUES (2262, '172.31.17.236', '2017-12-23 12:40:44', '计划管理', '/planview', 7);
INSERT INTO `aoa_user_log` VALUES (2263, '172.31.17.236', '2017-12-23 12:40:47', '计划报表', '/myplan', 7);
INSERT INTO `aoa_user_log` VALUES (2264, '172.31.17.236', '2017-12-23 12:40:49', '计划报表', '/myplan', 7);
INSERT INTO `aoa_user_log` VALUES (2265, '172.31.17.236', '2017-12-23 12:40:51', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2266, '172.31.17.236', '2017-12-23 12:41:01', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2267, '172.31.17.236', '2017-12-23 17:27:04', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2268, '172.31.17.236', '2017-12-23 17:27:40', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2269, '172.31.17.236', '2017-12-23 17:27:44', '计划管理', '/planview', 7);
INSERT INTO `aoa_user_log` VALUES (2270, '172.31.17.236', '2017-12-23 17:29:45', '文件管理', '/filemanage', 7);
INSERT INTO `aoa_user_log` VALUES (2271, '172.31.17.236', '2017-12-23 17:30:00', '通讯录', '/addrmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2272, '172.31.17.236', '2017-12-23 17:31:24', '我的管理', '/chatmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2273, '172.31.17.236', '2017-12-23 17:31:28', '讨论区列表', '/chatlist', 7);
INSERT INTO `aoa_user_log` VALUES (2274, '172.31.17.236', '2017-12-23 17:31:38', '讨论区列表', '/chatlist', 7);
INSERT INTO `aoa_user_log` VALUES (2275, '172.31.17.236', '2017-12-23 17:31:40', '部门管理', '/deptmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2276, '172.31.17.236', '2017-12-23 17:31:43', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2277, '172.31.17.236', '2017-12-23 17:31:45', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2278, '172.31.17.236', '2017-12-23 17:31:51', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2279, '172.31.17.236', '2017-12-23 17:31:53', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2280, '172.31.17.236', '2017-12-23 17:32:18', '考勤列表', '/attendcelist', 7);
INSERT INTO `aoa_user_log` VALUES (2281, '172.31.17.236', '2017-12-23 17:34:17', '日程管理', '/daymanage', 7);
INSERT INTO `aoa_user_log` VALUES (2282, '172.31.17.236', '2017-12-23 17:34:26', '我的日历', '/daycalendar', 7);
INSERT INTO `aoa_user_log` VALUES (2283, '172.31.17.236', '2017-12-23 17:35:38', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2284, '172.31.17.236', '2017-12-23 17:35:39', '考勤管理', '/attendceatt', 7);
INSERT INTO `aoa_user_log` VALUES (2285, '172.31.17.236', '2017-12-23 17:35:41', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2286, '172.31.17.236', '2017-12-23 17:35:42', '考勤周报表', '/attendceweek', 7);
INSERT INTO `aoa_user_log` VALUES (2287, '172.31.17.236', '2017-12-23 17:35:43', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2288, '172.31.17.236', '2017-12-23 17:35:44', '考勤月报表', '/attendcemonth', 7);
INSERT INTO `aoa_user_log` VALUES (2289, '172.31.17.236', '2017-12-23 17:35:59', '通知管理', '/infrommanage', 7);
INSERT INTO `aoa_user_log` VALUES (2290, '172.31.17.236', '2017-12-23 17:36:01', '通知管理', '/infrommanage', 7);
INSERT INTO `aoa_user_log` VALUES (2291, '172.31.17.236', '2017-12-23 17:36:03', '通知列表', '/infromlist', 7);
INSERT INTO `aoa_user_log` VALUES (2292, '172.31.17.236', '2017-12-23 17:36:20', '通知管理', '/infrommanage', 7);
INSERT INTO `aoa_user_log` VALUES (2293, '172.31.17.236', '2017-12-23 17:36:23', '通知列表', '/infromlist', 7);
INSERT INTO `aoa_user_log` VALUES (2294, '172.31.17.236', '2017-12-23 17:36:25', '账号管理', '/accountmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2295, '172.31.17.236', '2017-12-23 17:36:28', '邮件管理', '/mail', 7);
INSERT INTO `aoa_user_log` VALUES (2296, '172.31.17.236', '2017-12-23 17:36:42', '邮件管理', '/mail', 7);
INSERT INTO `aoa_user_log` VALUES (2297, '172.31.17.236', '2017-12-23 17:36:45', '任务管理', '/taskmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2298, '172.31.17.236', '2017-12-23 17:36:47', '任务管理', '/taskmanage', 7);
INSERT INTO `aoa_user_log` VALUES (2299, '172.31.17.236', '2017-12-23 17:36:47', '我的任务', '/mytask', 7);
INSERT INTO `aoa_user_log` VALUES (2300, '192.168.2.100', '2018-02-01 21:54:46', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (2301, '192.168.2.100', '2018-02-01 21:55:01', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2302, '192.168.2.100', '2018-02-01 21:55:28', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2303, '192.168.2.100', '2018-02-01 21:55:48', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2304, '192.168.2.100', '2018-02-01 21:58:17', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2305, '192.168.2.100', '2018-02-01 21:58:20', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2306, '192.168.2.100', '2018-02-01 21:58:33', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2307, '192.168.2.100', '2018-02-01 21:58:57', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2308, '192.168.2.100', '2018-02-01 21:59:08', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (2309, '192.168.2.100', '2018-02-01 21:59:12', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2310, '192.168.2.100', '2018-02-01 22:01:21', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2311, '192.168.2.100', '2018-02-02 23:41:09', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2312, '192.168.2.100', '2018-02-02 23:41:19', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2313, '192.168.2.100', '2018-02-02 23:43:36', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2314, '192.168.2.100', '2018-02-02 23:43:39', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2315, '192.168.2.100', '2018-02-02 23:43:53', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (2316, '192.168.2.100', '2018-02-02 23:44:07', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2317, '192.168.2.100', '2018-02-02 23:44:10', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2318, '192.168.2.100', '2018-02-02 23:44:16', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (2319, '192.168.2.100', '2018-02-02 23:45:16', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2320, '192.168.2.100', '2018-02-02 23:45:28', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2321, '192.168.2.100', '2018-02-03 00:02:33', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2322, '192.168.2.100', '2018-02-03 00:07:02', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (2323, '192.168.2.100', '2018-02-03 00:07:02', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (2324, '192.168.2.100', '2018-02-03 00:07:13', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2325, '192.168.2.100', '2018-02-03 00:07:20', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2326, '192.168.2.100', '2018-02-03 00:09:49', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2327, '192.168.2.100', '2018-02-03 00:09:59', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2328, '192.168.2.100', '2018-02-03 00:36:31', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2329, '192.168.2.100', '2018-02-03 00:36:38', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (2330, '192.168.2.100', '2018-02-03 00:36:42', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2331, '192.168.2.100', '2018-02-03 00:36:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2332, '192.168.2.100', '2018-02-03 00:36:46', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2333, '192.168.2.100', '2018-02-03 22:26:41', '文件管理', '/filemanage', 13);
INSERT INTO `aoa_user_log` VALUES (2334, '192.168.2.100', '2018-02-03 22:26:46', '笔记管理', '/noteview', 13);
INSERT INTO `aoa_user_log` VALUES (2335, '192.168.2.100', '2018-02-03 22:26:49', '我的管理', '/chatmanage', 13);
INSERT INTO `aoa_user_log` VALUES (2336, '192.168.2.100', '2018-02-03 22:26:53', '讨论区列表', '/chatlist', 13);
INSERT INTO `aoa_user_log` VALUES (2337, '192.168.2.100', '2018-02-03 22:27:00', '新建流程', '/xinxeng', 13);
INSERT INTO `aoa_user_log` VALUES (2338, '192.168.2.100', '2018-02-03 22:27:55', '新建流程', '/xinxeng', 13);
INSERT INTO `aoa_user_log` VALUES (2339, '192.168.2.100', '2018-02-03 22:28:16', '新建流程', '/xinxeng', 13);
INSERT INTO `aoa_user_log` VALUES (2340, '192.168.2.100', '2018-02-03 22:29:06', '我的申请', '/flowmanage', 13);
INSERT INTO `aoa_user_log` VALUES (2341, '192.168.2.100', '2018-02-03 22:29:13', '通知列表', '/infromlist', 13);
INSERT INTO `aoa_user_log` VALUES (2342, '192.168.2.100', '2018-02-03 22:29:17', '新建流程', '/xinxeng', 13);
INSERT INTO `aoa_user_log` VALUES (2343, '192.168.2.100', '2018-02-03 22:29:48', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (2344, '192.168.2.100', '2018-02-03 22:31:56', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2345, '192.168.2.100', '2018-02-03 22:47:18', '笔记管理', '/noteview', 11);
INSERT INTO `aoa_user_log` VALUES (2346, '192.168.2.100', '2018-02-03 22:48:04', '通知列表', '/infromlist', 11);
INSERT INTO `aoa_user_log` VALUES (2347, '192.168.2.100', '2018-02-03 23:05:49', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2348, '192.168.2.100', '2018-02-03 23:06:28', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2349, '192.168.2.100', '2018-02-03 23:06:36', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2350, '192.168.2.100', '2018-02-03 23:07:11', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2351, '192.168.2.100', '2018-02-03 23:07:42', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2352, '192.168.2.100', '2018-02-03 23:08:56', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2353, '192.168.2.100', '2018-02-03 23:09:14', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2354, '192.168.2.100', '2018-02-03 23:11:02', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2355, '192.168.2.100', '2018-02-03 23:11:44', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2356, '192.168.2.100', '2018-02-03 23:11:47', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2357, '192.168.2.100', '2018-02-03 23:11:52', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2358, '192.168.2.100', '2018-02-03 23:12:25', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2359, '192.168.2.100', '2018-02-03 23:15:31', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2360, '192.168.2.100', '2018-02-03 23:15:39', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2361, '192.168.2.100', '2018-02-03 23:16:10', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2362, '192.168.2.100', '2018-02-03 23:18:01', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2363, '192.168.2.100', '2018-02-03 23:19:20', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2364, '192.168.2.100', '2018-02-03 23:21:06', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2365, '192.168.2.100', '2018-02-03 23:21:11', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2366, '192.168.2.100', '2018-02-03 23:21:17', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2367, '192.168.2.100', '2018-02-03 23:21:21', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2368, '192.168.2.100', '2018-02-03 23:21:24', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2369, '192.168.2.100', '2018-02-03 23:25:39', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2370, '192.168.2.100', '2018-02-03 23:25:42', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2371, '192.168.2.100', '2018-02-03 23:30:09', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2372, '192.168.2.100', '2018-02-03 23:30:20', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (2373, '192.168.2.100', '2018-02-03 23:30:26', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2374, '192.168.2.100', '2018-02-03 23:30:34', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2375, '192.168.2.100', '2018-02-03 23:31:40', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2376, '192.168.2.100', '2018-02-03 23:33:46', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2377, '192.168.2.100', '2018-02-03 23:34:51', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2378, '192.168.2.100', '2018-02-03 23:35:14', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2379, '192.168.2.100', '2018-02-03 23:35:27', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2380, '192.168.2.100', '2018-02-03 23:35:34', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2381, '192.168.2.100', '2018-02-03 23:35:58', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2382, '192.168.2.100', '2018-02-03 23:36:08', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2383, '192.168.2.100', '2018-02-03 23:36:30', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2384, '192.168.2.100', '2018-02-03 23:38:09', '通知列表', '/infromlist', 2);
INSERT INTO `aoa_user_log` VALUES (2385, '192.168.2.100', '2018-02-03 23:38:27', '我的任务', '/mytask', 2);
INSERT INTO `aoa_user_log` VALUES (2386, '192.168.2.100', '2018-02-03 23:38:32', '通知列表', '/infromlist', 2);
INSERT INTO `aoa_user_log` VALUES (2387, '192.168.2.100', '2018-02-04 00:15:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2388, '192.168.2.100', '2018-02-04 00:21:51', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2389, '192.168.2.100', '2018-02-04 00:23:15', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2390, '192.168.2.100', '2018-02-04 01:05:28', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2391, '192.168.2.100', '2018-02-04 01:05:32', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2392, '192.168.2.100', '2018-02-04 01:05:44', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2393, '192.168.2.100', '2018-02-04 01:07:42', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2394, '192.168.2.100', '2018-02-04 01:07:51', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2395, '192.168.2.100', '2018-02-04 01:08:12', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2396, '192.168.2.100', '2018-02-04 01:11:42', '通知管理', '/infrommanage', 2);
INSERT INTO `aoa_user_log` VALUES (2397, '192.168.2.100', '2018-02-04 01:16:23', '考勤管理', '/attendceatt', 3);
INSERT INTO `aoa_user_log` VALUES (2398, '192.168.2.100', '2018-02-04 01:16:27', '考勤周报表', '/attendceweek', 3);
INSERT INTO `aoa_user_log` VALUES (2399, '192.168.2.100', '2018-02-04 01:17:13', '考勤管理', '/attendceatt', 2);
INSERT INTO `aoa_user_log` VALUES (2400, '192.168.2.100', '2018-02-04 01:25:40', '通知管理', '/infrommanage', 2);
INSERT INTO `aoa_user_log` VALUES (2401, '192.168.2.100', '2018-02-04 01:37:03', '通知管理', '/infrommanage', 2);
INSERT INTO `aoa_user_log` VALUES (2402, '192.168.2.100', '2018-02-05 19:48:28', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2403, '192.168.2.100', '2018-02-05 19:48:34', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2404, '192.168.2.100', '2018-02-05 19:48:35', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2405, '192.168.2.100', '2018-02-05 19:50:44', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2406, '192.168.2.100', '2018-02-05 19:52:46', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (2407, '192.168.2.100', '2018-02-05 19:54:16', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2408, '192.168.2.100', '2018-02-05 20:35:22', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2409, '192.168.2.100', '2018-02-06 17:48:12', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2410, '192.168.2.100', '2018-02-06 17:48:21', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2411, '192.168.2.100', '2018-02-06 17:48:45', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2412, '192.168.2.100', '2018-02-06 17:48:49', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (2413, '192.168.2.100', '2018-02-06 17:48:52', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (2414, '192.168.2.100', '2018-02-06 17:49:01', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2415, '192.168.2.100', '2018-02-06 17:49:03', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2416, '192.168.2.100', '2018-02-06 17:49:24', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2417, '192.168.2.100', '2018-02-06 17:49:36', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2418, '192.168.2.100', '2018-02-06 18:01:44', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2419, '192.168.2.100', '2018-02-06 18:01:57', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2420, '192.168.2.100', '2018-02-06 18:02:00', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2421, '192.168.2.100', '2018-02-06 18:02:15', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2422, '192.168.2.100', '2018-02-06 18:02:29', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (2423, '192.168.2.100', '2018-02-06 19:42:37', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2424, '192.168.2.100', '2018-02-06 19:43:25', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2425, '192.168.2.100', '2018-02-06 19:43:28', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (2426, '192.168.2.100', '2018-02-06 19:43:31', '我的日历', '/daycalendar', 1);
INSERT INTO `aoa_user_log` VALUES (2427, '192.168.2.100', '2018-02-06 19:43:38', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2428, '192.168.2.100', '2018-02-06 19:43:53', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2429, '192.168.2.100', '2018-02-06 19:48:20', '日程管理', '/daymanage', 1);
INSERT INTO `aoa_user_log` VALUES (2430, '192.168.2.100', '2018-02-06 19:48:22', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (2431, '192.168.2.100', '2018-02-06 19:48:26', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (2432, '192.168.2.100', '2018-02-06 19:48:30', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2433, '192.168.2.100', '2018-02-06 19:48:34', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (2434, '192.168.2.100', '2018-02-06 19:48:45', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2435, '192.168.2.100', '2018-02-06 19:48:51', '超级管理员', '/adminmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2436, '192.168.2.100', '2018-02-06 19:48:57', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2437, '192.168.2.100', '2018-02-06 19:49:12', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2438, '192.168.2.100', '2018-02-07 00:41:23', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2439, '192.168.2.100', '2018-02-07 00:41:59', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (2440, '192.168.2.100', '2018-02-07 00:42:32', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2441, '192.168.2.100', '2018-02-07 00:42:38', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2442, '192.168.2.100', '2018-02-07 00:42:50', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2443, '192.168.2.100', '2018-02-08 18:17:06', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2444, '192.168.2.100', '2018-02-08 18:17:24', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (2445, '192.168.2.100', '2018-02-08 18:17:27', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2446, '192.168.2.100', '2018-02-08 20:47:53', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2447, '192.168.2.100', '2018-02-08 20:47:57', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2448, '192.168.2.100', '2018-02-08 21:26:28', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2449, '192.168.2.100', '2018-02-08 21:26:29', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2450, '192.168.2.100', '2018-02-08 22:21:48', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2451, '192.168.2.100', '2018-02-09 00:47:54', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2452, '192.168.2.100', '2018-02-09 00:48:38', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2453, '192.168.2.100', '2018-02-09 00:48:45', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2454, '192.168.2.100', '2018-02-09 00:50:38', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (2455, '192.168.2.100', '2018-02-09 00:50:56', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2456, '192.168.2.100', '2018-02-09 00:51:14', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (2457, '192.168.2.100', '2018-02-09 00:51:28', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2458, '192.168.2.100', '2018-02-09 00:51:34', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2459, '192.168.2.100', '2018-02-09 00:51:40', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2460, '192.168.2.100', '2018-02-09 00:51:51', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (2461, '192.168.2.100', '2018-02-09 01:03:52', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2462, '192.168.2.100', '2018-02-09 01:03:57', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (2463, '192.168.2.100', '2018-02-11 09:49:46', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2464, '192.168.2.100', '2018-02-11 10:03:51', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2465, '192.168.2.100', '2018-02-11 10:05:52', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (2466, '192.168.2.100', '2018-02-19 13:22:37', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2467, '192.168.2.100', '2018-02-19 13:22:40', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (2468, '192.168.2.100', '2018-02-19 13:22:43', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (2469, '192.168.2.100', '2018-02-19 13:22:49', '考勤列表', '/attendcelist', 1);
INSERT INTO `aoa_user_log` VALUES (2470, '192.168.2.100', '2018-02-19 13:22:55', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (2471, '192.168.2.100', '2018-02-19 13:33:42', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (2472, '192.168.2.100', '2018-02-19 13:33:47', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2473, '192.168.1.104', '2018-03-01 19:13:42', '部门管理', '/deptmanage', 5);
INSERT INTO `aoa_user_log` VALUES (2474, '192.168.1.104', '2018-03-01 19:13:48', '考勤管理', '/attendceatt', 5);
INSERT INTO `aoa_user_log` VALUES (2475, '192.168.1.104', '2018-03-01 19:13:49', '考勤管理', '/attendceatt', 5);
INSERT INTO `aoa_user_log` VALUES (2476, '192.168.1.104', '2018-03-01 19:13:58', '流程审核', '/audit', 5);
INSERT INTO `aoa_user_log` VALUES (2477, '192.168.1.104', '2018-03-01 19:13:59', '流程审核', '/audit', 5);
INSERT INTO `aoa_user_log` VALUES (2478, '192.168.1.104', '2018-03-01 19:22:02', '角色列表', '/rolemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2479, '192.168.1.104', '2018-03-01 19:22:41', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (2480, '192.168.1.104', '2018-03-01 19:23:36', '状态管理', '/testsysstatus', 1);
INSERT INTO `aoa_user_log` VALUES (2481, '192.168.1.104', '2018-03-01 19:23:37', '菜单管理', '/testsysmenu', 1);
INSERT INTO `aoa_user_log` VALUES (2482, '192.168.1.104', '2018-03-01 19:23:40', '类型管理', '/testsystype', 1);
INSERT INTO `aoa_user_log` VALUES (2483, '192.168.1.104', '2018-03-01 19:24:09', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2484, '192.168.1.104', '2018-03-01 19:24:26', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (2485, '192.168.1.104', '2018-03-01 19:27:29', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2486, '192.168.1.104', '2018-03-01 19:28:15', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2487, '192.168.1.104', '2018-03-01 19:31:42', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (2488, '192.168.1.104', '2018-03-01 19:41:46', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (2489, '192.168.1.104', '2018-03-01 19:41:47', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (2490, '192.168.1.104', '2018-03-01 19:51:13', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (2491, '192.168.1.104', '2018-03-01 19:51:20', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (5677, '192.168.31.249', '2019-10-10 21:48:43', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (5678, '192.168.31.249', '2019-10-10 21:48:43', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (5679, '192.168.31.249', '2019-10-10 21:49:00', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5680, '192.168.31.249', '2019-10-10 23:27:27', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5681, '192.168.31.249', '2019-10-10 23:27:27', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5682, '192.168.31.249', '2019-10-10 23:27:27', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5683, '192.168.31.249', '2019-10-10 23:27:27', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5684, '192.168.43.44', '2019-10-11 09:42:29', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5685, '192.168.43.44', '2019-10-11 17:12:52', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5686, '192.168.43.44', '2019-10-11 17:13:44', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5687, '192.168.43.44', '2019-10-11 17:18:15', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5688, '192.168.43.44', '2019-10-11 17:18:15', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5689, '192.168.43.44', '2019-10-11 17:51:19', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5690, '192.168.43.44', '2019-10-11 17:52:56', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5691, '192.168.31.249', '2019-10-11 20:23:53', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5692, '192.168.31.249', '2019-10-11 21:51:18', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5693, '192.168.31.249', '2019-10-11 21:51:36', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5694, '192.168.31.249', '2019-10-11 21:51:38', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5695, '192.168.31.249', '2019-10-11 21:51:38', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5696, '192.168.31.249', '2019-10-11 21:51:38', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5697, '192.168.31.249', '2019-10-11 21:51:38', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5698, '192.168.31.249', '2019-10-11 21:51:38', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5699, '192.168.31.249', '2019-10-11 21:51:38', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5700, '192.168.31.249', '2019-10-11 21:51:38', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5701, '192.168.31.249', '2019-10-11 21:51:38', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5702, '192.168.31.249', '2019-10-11 21:51:38', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5703, '192.168.31.249', '2019-10-11 21:51:44', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5704, '192.168.31.249', '2019-10-11 21:51:45', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5705, '192.168.31.249', '2019-10-11 22:12:10', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5706, '192.168.31.249', '2019-10-11 22:12:10', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5707, '192.168.31.249', '2019-10-11 22:12:16', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5708, '192.168.31.249', '2019-10-11 22:33:11', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5709, '192.168.31.249', '2019-10-11 22:55:00', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5710, '192.168.31.249', '2019-10-11 22:55:03', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5711, '192.168.31.249', '2019-10-11 22:55:16', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5712, '192.168.31.249', '2019-10-11 22:57:25', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5713, '192.168.31.249', '2019-10-11 22:57:27', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5714, '192.168.31.249', '2019-10-11 22:57:37', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5715, '192.168.31.249', '2019-10-11 23:04:36', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5716, '192.168.31.249', '2019-10-11 23:04:36', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5717, '192.168.43.44', '2019-10-12 09:23:52', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5718, '192.168.43.44', '2019-10-12 12:15:52', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5719, '192.168.43.44', '2019-10-12 12:15:52', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5720, '192.168.43.44', '2019-10-12 12:15:52', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5721, '192.168.43.44', '2019-10-12 15:04:11', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5722, '192.168.43.44', '2019-10-12 15:04:11', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5723, '192.168.43.44', '2019-10-12 17:15:20', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5724, '192.168.43.44', '2019-10-12 17:15:20', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5725, '192.168.43.44', '2019-10-12 17:15:20', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5726, '192.168.31.249', '2019-10-13 00:03:02', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5727, '192.168.31.249', '2019-10-13 00:03:02', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5728, '192.168.31.249', '2019-10-13 00:03:06', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5729, '192.168.31.249', '2019-10-13 20:05:42', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5730, '192.168.31.249', '2019-10-13 20:06:54', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5731, '192.168.43.44', '2019-10-14 11:08:34', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5732, '192.168.43.44', '2019-10-14 11:08:34', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5733, '192.168.43.44', '2019-10-14 17:22:49', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5734, '192.168.43.44', '2019-10-14 17:23:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5735, '192.168.43.44', '2019-10-14 17:23:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5736, '192.168.43.44', '2019-10-15 09:49:35', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5737, '192.168.43.44', '2019-10-15 09:49:35', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5738, '192.168.43.44', '2019-10-15 09:49:52', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (5739, '192.168.43.44', '2019-10-15 09:49:52', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (5740, '192.168.43.44', '2019-10-15 09:49:52', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (5741, '192.168.43.44', '2019-10-15 09:49:56', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5742, '192.168.43.44', '2019-10-15 09:49:59', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5743, '192.168.43.44', '2019-10-15 09:50:02', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5744, '192.168.43.44', '2019-10-15 09:51:06', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5745, '192.168.43.44', '2019-10-15 10:27:17', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5746, '192.168.43.44', '2019-10-15 10:27:17', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5747, '192.168.43.44', '2019-10-15 10:27:21', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5748, '192.168.43.44', '2019-10-15 10:32:39', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5749, '192.168.43.44', '2019-10-15 10:32:39', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5750, '192.168.43.44', '2019-10-15 10:32:39', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5751, '192.168.31.249', '2019-10-17 14:34:05', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5752, '192.168.31.249', '2019-10-17 14:34:05', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5753, '127.0.0.1', '2019-10-22 22:16:26', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5754, '127.0.0.1', '2019-10-22 22:16:56', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5755, '127.0.0.1', '2019-10-22 22:36:05', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (5756, '127.0.0.1', '2019-10-22 22:39:39', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5757, '127.0.0.1', '2019-10-22 22:39:41', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5758, '127.0.0.1', '2019-10-22 22:39:42', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5759, '127.0.0.1', '2019-10-22 22:39:43', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5760, '127.0.0.1', '2019-10-22 22:40:34', '考勤管理', '/attendceatt', 1);
INSERT INTO `aoa_user_log` VALUES (5761, '127.0.0.1', '2019-10-22 22:40:40', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (5762, '127.0.0.1', '2019-10-22 22:40:50', '考勤月报表', '/attendcemonth', 1);
INSERT INTO `aoa_user_log` VALUES (5763, '192.168.43.44', '2019-10-23 16:03:58', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5764, '192.168.43.44', '2019-10-23 16:03:58', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5765, '192.168.43.44', '2019-10-23 16:41:04', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5766, '192.168.43.44', '2019-10-23 16:41:04', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5767, '192.168.43.44', '2019-10-23 16:49:00', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5768, '192.168.43.44', '2019-10-23 16:49:00', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5769, '192.168.43.44', '2019-10-23 16:49:26', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5770, '192.168.43.44', '2019-10-23 16:49:28', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5771, '127.0.0.1', '2019-10-23 21:36:12', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5772, '127.0.0.1', '2019-10-23 21:36:12', '部门管理', '/deptmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5773, '192.168.43.44', '2019-10-25 17:00:42', '在线用户', '/morelogrecord', 1);
INSERT INTO `aoa_user_log` VALUES (5774, '192.168.43.44', '2019-10-25 17:09:51', '职位管理', '/positionmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5775, '127.0.0.1', '2019-10-25 20:25:40', '用户管理', '/usermanage', 1);
INSERT INTO `aoa_user_log` VALUES (5776, '127.0.0.1', '2019-10-25 20:56:12', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5777, '192.168.43.44', '2019-10-26 15:12:49', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5778, '192.168.43.44', '2019-10-26 15:12:56', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5779, '192.168.43.44', '2019-10-26 15:13:03', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5780, '192.168.43.44', '2019-10-26 15:13:07', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5781, '192.168.43.44', '2019-10-26 15:13:53', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5782, '192.168.43.44', '2019-10-26 15:14:03', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5783, '192.168.43.44', '2019-10-26 15:14:28', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5784, '192.168.43.44', '2019-10-26 15:14:30', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (5785, '192.168.43.44', '2019-10-26 15:14:36', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5786, '192.168.43.44', '2019-10-26 15:14:42', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5787, '192.168.43.44', '2019-10-26 15:16:16', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5788, '127.0.0.1', '2019-10-28 10:16:44', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5789, '127.0.0.1', '2019-10-28 10:17:00', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5790, '127.0.0.1', '2019-10-28 10:17:09', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5791, '127.0.0.1', '2019-10-28 14:15:54', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5792, '127.0.0.1', '2019-10-28 14:18:12', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5793, '127.0.0.1', '2019-10-28 14:18:52', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5794, '192.168.43.44', '2019-10-30 15:47:54', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5795, '192.168.43.44', '2019-10-30 17:18:49', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5796, '192.168.43.44', '2019-10-31 17:14:45', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5797, '192.168.43.44', '2019-10-31 17:20:07', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5798, '192.168.43.44', '2019-10-31 17:20:19', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5799, '192.168.43.44', '2019-10-31 17:20:21', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5800, '192.168.43.44', '2019-11-01 09:47:17', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5801, '192.168.43.44', '2019-11-01 09:47:19', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5802, '192.168.43.44', '2019-11-01 09:51:47', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5803, '192.168.43.44', '2019-11-01 09:51:48', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5804, '127.0.0.1', '2019-11-01 23:07:38', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5805, '127.0.0.1', '2019-11-01 23:07:46', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5806, '127.0.0.1', '2019-11-01 23:08:00', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5807, '127.0.0.1', '2019-11-01 23:08:09', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5808, '127.0.0.1', '2019-11-01 23:08:39', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5809, '127.0.0.1', '2019-11-01 23:09:34', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5810, '127.0.0.1', '2019-11-01 23:09:36', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (5811, '127.0.0.1', '2019-11-01 23:09:41', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5812, '127.0.0.1', '2019-11-01 23:09:47', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5813, '127.0.0.1', '2019-11-01 23:09:52', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (5814, '127.0.0.1', '2019-11-01 23:09:57', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (5815, '127.0.0.1', '2019-11-01 23:09:57', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (5816, '127.0.0.1', '2019-11-01 23:09:57', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (5817, '127.0.0.1', '2019-11-01 23:09:59', '任务管理', '/taskmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5818, '127.0.0.1', '2019-11-01 23:10:00', '我的任务', '/mytask', 1);
INSERT INTO `aoa_user_log` VALUES (5819, '127.0.0.1', '2019-11-01 23:10:10', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5820, '127.0.0.1', '2019-11-01 23:11:00', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5821, '127.0.0.1', '2019-11-01 23:11:30', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5822, '127.0.0.1', '2019-11-01 23:11:37', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5823, '127.0.0.1', '2019-11-01 23:11:40', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5824, '127.0.0.1', '2019-11-01 23:11:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5825, '127.0.0.1', '2019-11-01 23:11:47', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5826, '127.0.0.1', '2019-11-01 23:11:58', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5827, '127.0.0.1', '2019-11-01 23:12:20', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5828, '127.0.0.1', '2019-11-01 23:12:39', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5829, '127.0.0.1', '2019-11-01 23:12:44', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5830, '127.0.0.1', '2019-11-01 23:13:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5831, '127.0.0.1', '2019-11-01 23:13:20', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5832, '127.0.0.1', '2019-11-01 23:13:32', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5833, '127.0.0.1', '2019-11-01 23:13:50', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5834, '127.0.0.1', '2019-11-01 23:14:22', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (5835, '127.0.0.1', '2019-11-01 23:14:22', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (5836, '127.0.0.1', '2019-11-01 23:14:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5837, '192.168.43.44', '2019-11-03 09:50:41', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5838, '192.168.43.44', '2019-11-03 18:11:55', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5839, '192.168.43.44', '2019-11-03 18:13:00', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5840, '192.168.43.44', '2019-11-03 18:13:56', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5841, '192.168.43.44', '2019-11-03 18:14:01', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5842, '192.168.43.44', '2019-11-03 18:15:04', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5843, '127.0.0.1', '2019-11-03 22:04:38', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5844, '127.0.0.1', '2019-11-03 22:05:47', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5845, '127.0.0.1', '2019-11-03 22:17:36', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5846, '127.0.0.1', '2019-11-03 22:20:55', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5847, '127.0.0.1', '2019-11-04 09:07:12', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5848, '192.168.43.44', '2019-11-04 09:31:39', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5849, '192.168.43.44', '2019-11-04 09:33:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5850, '192.168.43.44', '2019-11-04 09:46:21', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5851, '192.168.43.44', '2019-11-04 09:57:46', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5852, '192.168.43.44', '2019-11-04 10:00:17', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5853, '192.168.43.44', '2019-11-04 10:17:12', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5854, '192.168.43.44', '2019-11-04 10:18:19', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5855, '192.168.43.44', '2019-11-04 10:18:56', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5856, '192.168.43.44', '2019-11-04 10:19:25', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5857, '192.168.43.44', '2019-11-04 10:30:22', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5858, '192.168.43.44', '2019-11-04 10:30:47', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5859, '192.168.43.44', '2019-11-04 10:32:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5860, '192.168.43.44', '2019-11-04 10:37:43', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5861, '192.168.43.44', '2019-11-04 10:37:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5862, '192.168.43.44', '2019-11-04 10:41:26', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5863, '192.168.43.44', '2019-11-04 10:41:28', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5864, '192.168.43.44', '2019-11-04 10:53:59', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5865, '192.168.43.44', '2019-11-04 10:53:59', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5866, '127.0.0.1', '2019-11-04 11:22:29', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5867, '127.0.0.1', '2019-11-04 11:36:27', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5868, '127.0.0.1', '2019-11-04 11:36:36', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5869, '127.0.0.1', '2019-11-04 11:38:10', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5870, '127.0.0.1', '2019-11-04 11:38:10', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5871, '127.0.0.1', '2019-11-04 11:38:29', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5872, '127.0.0.1', '2019-11-04 11:39:10', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5873, '127.0.0.1', '2019-11-04 12:59:08', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5874, '127.0.0.1', '2019-11-04 13:00:41', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5875, '127.0.0.1', '2019-11-04 13:01:58', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5876, '127.0.0.1', '2019-11-04 13:02:32', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5877, '127.0.0.1', '2019-11-04 13:02:45', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5878, '127.0.0.1', '2019-11-04 13:03:07', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5879, '127.0.0.1', '2019-11-04 13:06:10', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5880, '127.0.0.1', '2019-11-04 13:07:09', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5881, '127.0.0.1', '2019-11-04 13:09:24', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5882, '127.0.0.1', '2019-11-04 13:10:30', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5883, '127.0.0.1', '2019-11-04 13:11:20', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5884, '192.168.43.44', '2019-11-04 14:36:03', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5885, '192.168.43.44', '2019-11-04 14:36:55', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5886, '192.168.43.44', '2019-11-04 14:37:00', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5887, '192.168.43.44', '2019-11-04 14:37:01', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5888, '127.0.0.1', '2019-11-04 21:00:52', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5889, '127.0.0.1', '2019-11-04 21:00:54', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5890, '127.0.0.1', '2019-11-04 21:00:57', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5891, '127.0.0.1', '2019-11-04 21:01:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5892, '127.0.0.1', '2019-11-04 21:03:19', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5893, '127.0.0.1', '2019-11-04 21:03:28', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5894, '127.0.0.1', '2019-11-04 21:04:36', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5895, '127.0.0.1', '2019-11-04 21:04:39', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5896, '127.0.0.1', '2019-11-04 21:06:12', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5897, '127.0.0.1', '2019-11-04 21:06:27', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5898, '127.0.0.1', '2019-11-04 22:48:24', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5899, '127.0.0.1', '2019-11-04 22:51:00', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5900, '127.0.0.1', '2019-11-04 22:51:47', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5901, '127.0.0.1', '2019-11-04 22:51:57', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5902, '127.0.0.1', '2019-11-04 23:00:13', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5903, '127.0.0.1', '2019-11-04 23:02:02', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5904, '127.0.0.1', '2019-11-05 08:45:47', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5905, '127.0.0.1', '2019-11-05 08:51:26', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5906, '127.0.0.1', '2019-11-05 10:29:34', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5907, '127.0.0.1', '2019-11-05 11:04:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5908, '127.0.0.1', '2019-11-05 11:05:03', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5909, '127.0.0.1', '2019-11-05 11:05:22', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5910, '127.0.0.1', '2019-11-05 11:05:46', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5911, '127.0.0.1', '2019-11-05 11:17:05', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5912, '127.0.0.1', '2019-11-05 11:18:02', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5913, '127.0.0.1', '2019-11-05 11:23:31', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5914, '127.0.0.1', '2019-11-05 11:30:35', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5915, '127.0.0.1', '2019-11-05 11:30:36', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5916, '127.0.0.1', '2019-11-05 11:36:26', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5917, '127.0.0.1', '2019-11-05 11:49:58', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5918, '127.0.0.1', '2019-11-05 13:57:52', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5919, '127.0.0.1', '2019-11-05 13:58:02', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5920, '127.0.0.1', '2019-11-05 13:58:12', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5921, '127.0.0.1', '2019-11-05 13:58:17', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5922, '127.0.0.1', '2019-11-05 13:58:21', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5923, '127.0.0.1', '2019-11-05 14:00:54', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5924, '127.0.0.1', '2019-11-05 14:03:24', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5925, '127.0.0.1', '2019-11-05 14:05:29', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5926, '127.0.0.1', '2019-11-05 14:07:34', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5927, '127.0.0.1', '2019-11-05 14:12:42', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5928, '127.0.0.1', '2019-11-05 23:28:12', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5929, '127.0.0.1', '2019-11-05 23:28:15', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5930, '127.0.0.1', '2019-11-05 23:28:37', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5931, '127.0.0.1', '2019-11-05 23:28:40', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5932, '127.0.0.1', '2019-11-05 23:29:48', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5933, '127.0.0.1', '2019-11-05 23:29:58', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5934, '127.0.0.1', '2019-11-05 23:30:04', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (5935, '127.0.0.1', '2019-11-05 23:30:06', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5936, '192.168.43.44', '2019-11-06 08:23:23', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5937, '192.168.43.44', '2019-11-06 08:23:29', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5938, '192.168.43.44', '2019-11-06 08:23:36', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5939, '192.168.43.44', '2019-11-06 08:23:41', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5940, '192.168.43.44', '2019-11-06 08:28:23', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5941, '192.168.43.44', '2019-11-06 08:28:33', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5942, '192.168.43.44', '2019-11-06 08:29:12', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5943, '192.168.43.44', '2019-11-06 08:29:29', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5944, '192.168.43.44', '2019-11-06 08:29:37', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5945, '192.168.43.44', '2019-11-06 08:29:42', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5946, '192.168.43.44', '2019-11-06 08:29:46', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5947, '192.168.43.44', '2019-11-06 08:31:09', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5948, '192.168.43.44', '2019-11-06 08:31:47', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5949, '192.168.43.44', '2019-11-06 10:13:43', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5950, '192.168.43.44', '2019-11-06 10:14:07', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5951, '192.168.43.44', '2019-11-06 10:45:25', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5952, '192.168.43.44', '2019-11-06 10:45:32', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5953, '127.0.0.1', '2019-11-06 16:03:42', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5954, '127.0.0.1', '2019-11-06 16:04:08', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5955, '127.0.0.1', '2019-11-06 16:04:15', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5956, '127.0.0.1', '2019-11-06 16:04:17', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5957, '127.0.0.1', '2019-11-06 16:06:05', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5958, '127.0.0.1', '2019-11-06 16:07:04', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5959, '127.0.0.1', '2019-11-06 16:16:30', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5960, '127.0.0.1', '2019-11-06 16:31:28', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5961, '127.0.0.1', '2019-11-06 16:32:16', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5962, '127.0.0.1', '2019-11-06 16:32:28', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5963, '127.0.0.1', '2019-11-06 16:33:41', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5964, '127.0.0.1', '2019-11-06 16:37:47', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5965, '127.0.0.1', '2019-11-06 16:38:09', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5966, '127.0.0.1', '2019-11-06 16:38:39', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5967, '192.168.43.44', '2019-11-06 17:21:26', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5968, '192.168.43.44', '2019-11-06 18:07:51', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5969, '192.168.43.44', '2019-11-06 18:08:00', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5970, '192.168.43.44', '2019-11-06 19:45:57', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5971, '192.168.43.44', '2019-11-06 19:47:11', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5972, '192.168.43.44', '2019-11-06 19:47:39', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5973, '192.168.43.44', '2019-11-06 19:47:44', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5974, '192.168.43.44', '2019-11-06 20:09:09', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5975, '192.168.43.44', '2019-11-06 20:10:44', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5976, '127.0.0.1', '2019-11-06 21:07:12', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5977, '127.0.0.1', '2019-11-06 21:54:50', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5978, '127.0.0.1', '2019-11-06 22:09:38', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (5979, '127.0.0.1', '2019-11-06 22:12:39', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5980, '127.0.0.1', '2019-11-06 22:21:21', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5981, '127.0.0.1', '2019-11-06 22:22:40', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5982, '127.0.0.1', '2019-11-06 22:37:57', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5983, '127.0.0.1', '2019-11-06 22:38:05', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5984, '127.0.0.1', '2019-11-06 23:00:18', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5985, '127.0.0.1', '2019-11-06 23:08:12', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5986, '127.0.0.1', '2019-11-07 08:41:06', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5987, '127.0.0.1', '2019-11-07 08:44:21', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5988, '127.0.0.1', '2019-11-07 08:44:32', '邮件管理', '/mail', 1);
INSERT INTO `aoa_user_log` VALUES (5989, '127.0.0.1', '2019-11-07 08:45:28', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5990, '127.0.0.1', '2019-11-07 08:45:57', '我的管理', '/chatmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5991, '127.0.0.1', '2019-11-07 08:46:03', '讨论区列表', '/chatlist', 1);
INSERT INTO `aoa_user_log` VALUES (5992, '127.0.0.1', '2019-11-07 08:46:35', '通讯录', '/addrmanage', 1);
INSERT INTO `aoa_user_log` VALUES (5993, '127.0.0.1', '2019-11-07 08:47:13', '笔记管理', '/noteview', 1);
INSERT INTO `aoa_user_log` VALUES (5994, '127.0.0.1', '2019-11-07 08:54:19', '文件管理', '/filemanage', 1);
INSERT INTO `aoa_user_log` VALUES (5995, '127.0.0.1', '2019-11-07 08:55:06', '计划管理', '/planview', 1);
INSERT INTO `aoa_user_log` VALUES (5996, '127.0.0.1', '2019-11-07 08:55:26', '计划报表', '/myplan', 1);
INSERT INTO `aoa_user_log` VALUES (5997, '192.168.43.44', '2019-11-07 09:17:19', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (5998, '192.168.43.44', '2019-11-07 11:28:30', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (5999, '192.168.43.44', '2019-11-07 11:28:48', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6000, '192.168.43.44', '2019-11-07 12:36:45', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (6001, '192.168.43.44', '2019-11-07 12:37:10', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6002, '192.168.43.44', '2019-11-07 12:37:40', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (6003, '192.168.43.44', '2019-11-07 12:38:07', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6004, '127.0.0.1', '2019-11-07 12:46:13', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (6005, '127.0.0.1', '2019-11-07 13:08:21', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6006, '127.0.0.1', '2019-11-07 13:11:14', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (6007, '127.0.0.1', '2019-11-07 15:03:58', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6008, '127.0.0.1', '2019-11-07 15:11:13', '通知列表', '/infromlist', 1);
INSERT INTO `aoa_user_log` VALUES (6009, '192.168.43.44', '2019-11-07 16:54:43', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6010, '127.0.0.1', '2019-11-07 21:56:14', '考勤周报表', '/attendceweek', 1);
INSERT INTO `aoa_user_log` VALUES (6011, '127.0.0.1', '2019-11-07 21:56:19', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6012, '127.0.0.1', '2019-11-07 21:57:51', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6013, '127.0.0.1', '2019-11-07 22:25:05', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6014, '127.0.0.1', '2019-11-08 14:49:57', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6015, '127.0.0.1', '2019-11-08 14:49:59', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6016, '127.0.0.1', '2019-11-08 14:51:55', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (6017, '127.0.0.1', '2019-11-08 14:51:58', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6018, '127.0.0.1', '2019-11-08 14:52:02', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6019, '127.0.0.1', '2019-11-08 14:52:04', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6020, '127.0.0.1', '2019-11-08 14:52:05', '流程审核', '/audit', 1);
INSERT INTO `aoa_user_log` VALUES (6021, '127.0.0.1', '2019-11-08 14:52:06', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6022, '127.0.0.1', '2019-11-08 14:52:09', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6023, '127.0.0.1', '2019-11-08 14:55:17', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6024, '127.0.0.1', '2019-11-08 14:55:29', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6025, '127.0.0.1', '2019-11-08 14:59:21', '通知管理', '/infrommanage', 1);
INSERT INTO `aoa_user_log` VALUES (6026, '127.0.0.1', '2019-11-08 15:48:49', '账号管理', '/accountmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6027, '127.0.0.1', '2019-11-08 15:48:53', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6028, '127.0.0.1', '2019-11-08 15:49:22', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6029, '127.0.0.1', '2019-11-08 15:51:47', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6030, '127.0.0.1', '2019-11-08 15:51:45', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6031, '192.168.43.44', '2019-11-09 11:04:46', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6032, '192.168.43.44', '2019-11-09 11:04:46', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6033, '127.0.0.1', '2019-11-09 12:38:37', '新建流程', '/xinxeng', 1);
INSERT INTO `aoa_user_log` VALUES (6034, '127.0.0.1', '2019-11-09 12:44:27', '我的申请', '/flowmanage', 1);
INSERT INTO `aoa_user_log` VALUES (6035, '127.0.0.1', '2019-11-09 13:50:11', '通知管理', '/infrommanage', 1);
COMMIT;

-- ----------------------------
-- Table structure for aoa_user_login_record
-- ----------------------------
DROP TABLE IF EXISTS `aoa_user_login_record`;
CREATE TABLE `aoa_user_login_record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `browser` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户使用的浏览器',
  `ip_addr` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT 'IP地址',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `session_id` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT 'session_id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '登录用户ID',
  PRIMARY KEY (`record_id`),
  KEY `FKks6qpqj3ss4e4timjt0xok1p0` (`user_id`),
  CONSTRAINT `FKks6qpqj3ss4e4timjt0xok1p0` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=532 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_user_login_record
-- ----------------------------
BEGIN;
INSERT INTO `aoa_user_login_record` VALUES (362, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-10-31 10:06:21', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (363, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-10-31 17:14:41', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (364, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-10-31 17:33:50', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (365, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-10-31 17:43:27', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (366, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-10-31 17:47:03', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (367, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-10-31 17:50:51', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (368, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-10-31 17:53:26', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (369, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-01 09:47:00', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (370, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-01 11:31:23', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (371, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-01 17:07:13', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (372, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-01 17:21:03', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (373, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-01 18:18:52', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (374, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-01 23:06:59', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (375, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-01 23:24:54', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (376, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 09:16:04', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (377, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 09:42:21', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (378, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 10:47:09', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (379, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 11:12:03', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (380, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 11:18:36', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (381, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-02 16:15:44', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (382, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-02 16:28:24', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (383, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-02 16:36:47', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (384, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-02 17:08:02', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (385, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-02 17:15:33', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (386, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 17:40:44', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (387, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 17:45:22', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (388, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 18:03:21', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (389, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-02 18:45:20', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (459, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-06 16:05:49', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (460, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-06 16:31:21', NULL, 3);
INSERT INTO `aoa_user_login_record` VALUES (461, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-06 16:33:37', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (462, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-06 17:01:08', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (463, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-06 17:07:32', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (464, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-06 18:02:51', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (465, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-06 18:53:27', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (466, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-06 20:09:02', NULL, 3);
INSERT INTO `aoa_user_login_record` VALUES (467, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-06 20:10:40', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (468, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-06 21:06:39', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (469, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-06 22:21:11', NULL, 3);
INSERT INTO `aoa_user_login_record` VALUES (470, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-06 23:00:13', NULL, 3);
INSERT INTO `aoa_user_login_record` VALUES (471, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-06 23:02:58', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (472, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 08:41:02', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (473, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 11:28:24', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (474, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 12:37:07', NULL, 3);
INSERT INTO `aoa_user_login_record` VALUES (475, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 15:03:55', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (476, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 16:54:35', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (477, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 17:17:11', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (478, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 17:52:43', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (479, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 18:52:03', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (480, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 19:02:10', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (481, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 19:03:51', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (482, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 19:20:12', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (483, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 19:22:16', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (484, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-07 19:23:40', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (485, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 21:46:16', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (486, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:09:22', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (487, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:14:08', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (488, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:16:01', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (489, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:19:55', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (490, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:36:53', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (491, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:40:10', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (492, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:45:27', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (493, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 22:48:11', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (494, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 23:05:35', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (495, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 23:06:30', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (496, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 23:09:55', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (497, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-07 23:13:48', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (498, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 08:43:53', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (499, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 08:45:47', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (500, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 08:53:19', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (501, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 09:20:31', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (502, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 10:13:04', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (503, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 11:09:34', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (504, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 11:10:57', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (505, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 11:16:33', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (506, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 11:32:30', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (507, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 11:35:24', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (508, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 12:16:49', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (509, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 14:49:46', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (510, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 14:55:13', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (511, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 14:59:14', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (512, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 15:48:42', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (513, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 15:51:12', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (514, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 15:54:40', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (515, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 16:14:40', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (516, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-08 17:36:03', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (517, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 19:27:49', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (518, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 21:52:25', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (519, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 22:41:13', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (520, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 23:11:15', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (521, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 23:21:44', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (522, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 23:34:06', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (523, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-08 23:46:45', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (524, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-09 09:02:14', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (525, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-09 09:36:06', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (526, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-09 09:39:39', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (527, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-09 09:40:31', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (528, 'Chrome/78.0.3904.70', '192.168.43.44', '2019-11-09 10:14:26', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (529, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-09 12:33:55', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (530, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-09 13:20:35', NULL, 5);
INSERT INTO `aoa_user_login_record` VALUES (531, 'Chrome/78.0.3904.70', '127.0.0.1', '2019-11-09 13:23:18', NULL, 5);
COMMIT;

-- ----------------------------
-- Table structure for aoa_vote_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_vote_list`;
CREATE TABLE `aoa_vote_list` (
  `vote_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投票表ID',
  `end_time` datetime DEFAULT NULL COMMENT '投票结束时间',
  `selectone` int(11) DEFAULT NULL COMMENT '单选和多选',
  `start_time` datetime DEFAULT NULL COMMENT '投票开始时间',
  PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_vote_list
-- ----------------------------
BEGIN;
INSERT INTO `aoa_vote_list` VALUES (1, '2017-10-04 21:52:48', 1, '2017-10-03 21:52:48');
INSERT INTO `aoa_vote_list` VALUES (2, '2017-10-04 21:54:36', 1, '2017-10-03 21:54:36');
INSERT INTO `aoa_vote_list` VALUES (3, '2017-10-04 23:18:52', 1, '2017-10-03 23:18:52');
INSERT INTO `aoa_vote_list` VALUES (4, '2017-10-03 02:57:33', 2, '2017-10-04 02:57:33');
INSERT INTO `aoa_vote_list` VALUES (5, '2017-10-05 03:18:25', 1, '2017-10-04 03:18:25');
INSERT INTO `aoa_vote_list` VALUES (7, '2017-10-30 15:27:03', 2, '2017-10-27 15:27:03');
INSERT INTO `aoa_vote_list` VALUES (8, '2017-10-18 16:01:25', 2, '2017-10-04 16:01:25');
INSERT INTO `aoa_vote_list` VALUES (9, '2017-10-06 22:53:22', 2, '2017-10-05 22:53:22');
INSERT INTO `aoa_vote_list` VALUES (10, '2017-10-06 22:56:45', 2, '2017-10-05 22:56:45');
INSERT INTO `aoa_vote_list` VALUES (11, '2017-10-06 22:57:59', 1, '2017-10-05 22:57:59');
INSERT INTO `aoa_vote_list` VALUES (12, '2017-10-13 23:25:24', 1, '2017-10-12 23:25:24');
INSERT INTO `aoa_vote_list` VALUES (13, '2019-12-20 19:22:52', 1, '2019-12-19 19:22:52');
INSERT INTO `aoa_vote_list` VALUES (14, '2019-12-21 23:39:29', 1, '2019-12-19 23:39:29');
INSERT INTO `aoa_vote_list` VALUES (15, '2019-12-21 09:46:07', 2, '2019-12-20 09:46:07');
INSERT INTO `aoa_vote_list` VALUES (16, '2019-12-21 10:07:03', 2, '2019-12-20 10:07:03');
INSERT INTO `aoa_vote_list` VALUES (17, '2019-12-21 10:10:33', 1, '2019-12-20 10:10:33');
INSERT INTO `aoa_vote_list` VALUES (18, '2019-12-21 14:49:07', 1, '2019-12-20 14:49:07');
INSERT INTO `aoa_vote_list` VALUES (19, '2019-12-21 14:53:22', 2, '2019-12-20 14:53:22');
INSERT INTO `aoa_vote_list` VALUES (20, '2019-12-21 14:57:56', 2, '2019-12-20 14:57:56');
INSERT INTO `aoa_vote_list` VALUES (21, '2019-12-21 15:03:25', 2, '2019-12-20 15:03:25');
INSERT INTO `aoa_vote_list` VALUES (22, '2019-12-21 19:49:37', 2, '2019-12-20 19:49:37');
INSERT INTO `aoa_vote_list` VALUES (23, '2019-12-21 19:53:08', 2, '2019-12-20 19:53:08');
COMMIT;

-- ----------------------------
-- Table structure for aoa_vote_title_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_vote_title_user`;
CREATE TABLE `aoa_vote_title_user` (
  `vote_title_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投票-标题-用户 表ID',
  `vote_id` bigint(20) DEFAULT NULL COMMENT '投票表ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户表ID',
  `title_id` bigint(20) DEFAULT NULL COMMENT '投票标题表ID',
  PRIMARY KEY (`vote_title_user_id`),
  KEY `FKb2pou179gr3wf10lx0wy6qrli` (`user_id`),
  KEY `FK79ia8m9w7faxi7wmth7or8mqg` (`title_id`),
  CONSTRAINT `FK79ia8m9w7faxi7wmth7or8mqg` FOREIGN KEY (`title_id`) REFERENCES `aoa_vote_titles` (`title_id`),
  CONSTRAINT `FKb2pou179gr3wf10lx0wy6qrli` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_vote_title_user
-- ----------------------------
BEGIN;
INSERT INTO `aoa_vote_title_user` VALUES (1, 3, 1, 7);
INSERT INTO `aoa_vote_title_user` VALUES (2, 3, 2, 8);
INSERT INTO `aoa_vote_title_user` VALUES (3, 3, 3, 9);
INSERT INTO `aoa_vote_title_user` VALUES (4, 3, 4, 7);
INSERT INTO `aoa_vote_title_user` VALUES (5, 1, 2, 2);
INSERT INTO `aoa_vote_title_user` VALUES (6, 2, 2, 4);
INSERT INTO `aoa_vote_title_user` VALUES (7, 4, 2, 11);
INSERT INTO `aoa_vote_title_user` VALUES (8, 4, 2, 12);
INSERT INTO `aoa_vote_title_user` VALUES (9, 4, 2, 13);
INSERT INTO `aoa_vote_title_user` VALUES (13, 5, 2, 15);
INSERT INTO `aoa_vote_title_user` VALUES (17, 8, 2, 23);
INSERT INTO `aoa_vote_title_user` VALUES (18, 8, 2, 24);
INSERT INTO `aoa_vote_title_user` VALUES (19, 8, 2, 25);
INSERT INTO `aoa_vote_title_user` VALUES (20, 11, 2, 32);
INSERT INTO `aoa_vote_title_user` VALUES (21, 8, 1, 23);
INSERT INTO `aoa_vote_title_user` VALUES (22, 8, 1, 24);
INSERT INTO `aoa_vote_title_user` VALUES (23, 8, 1, 25);
INSERT INTO `aoa_vote_title_user` VALUES (24, 14, 3, 36);
INSERT INTO `aoa_vote_title_user` VALUES (25, 15, 3, 37);
INSERT INTO `aoa_vote_title_user` VALUES (26, 15, 3, 38);
INSERT INTO `aoa_vote_title_user` VALUES (27, 15, 3, 38);
INSERT INTO `aoa_vote_title_user` VALUES (28, 17, 3, 41);
INSERT INTO `aoa_vote_title_user` VALUES (29, 16, 3, 39);
INSERT INTO `aoa_vote_title_user` VALUES (30, 16, 3, 40);
INSERT INTO `aoa_vote_title_user` VALUES (31, 16, 3, 40);
INSERT INTO `aoa_vote_title_user` VALUES (32, 18, 3, 43);
INSERT INTO `aoa_vote_title_user` VALUES (33, 19, 3, 45);
INSERT INTO `aoa_vote_title_user` VALUES (34, 19, 3, 46);
INSERT INTO `aoa_vote_title_user` VALUES (35, 20, 3, 47);
INSERT INTO `aoa_vote_title_user` VALUES (36, 20, 3, 48);
INSERT INTO `aoa_vote_title_user` VALUES (37, 20, 3, 48);
INSERT INTO `aoa_vote_title_user` VALUES (78, 23, 3, 54);
INSERT INTO `aoa_vote_title_user` VALUES (79, 23, 3, 55);
INSERT INTO `aoa_vote_title_user` VALUES (80, 23, 3, 55);
COMMIT;

-- ----------------------------
-- Table structure for aoa_vote_titles
-- ----------------------------
DROP TABLE IF EXISTS `aoa_vote_titles`;
CREATE TABLE `aoa_vote_titles` (
  `title_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投票标题ID',
  `color` varchar(255) DEFAULT NULL COMMENT '投票进度颜色',
  `title` varchar(255) DEFAULT NULL COMMENT '投票标题',
  `vote_id` bigint(20) DEFAULT NULL COMMENT '投票表ID',
  PRIMARY KEY (`title_id`),
  KEY `FKnl21d99b8hc6gtfrrfsc9alge` (`vote_id`),
  CONSTRAINT `FKnl21d99b8hc6gtfrrfsc9alge` FOREIGN KEY (`vote_id`) REFERENCES `aoa_vote_list` (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of aoa_vote_titles
-- ----------------------------
BEGIN;
INSERT INTO `aoa_vote_titles` VALUES (1, '#5bc0de', '22222', 1);
INSERT INTO `aoa_vote_titles` VALUES (2, '#5bc0de', '111111', 1);
INSERT INTO `aoa_vote_titles` VALUES (3, '#5bc0de', '33333', 1);
INSERT INTO `aoa_vote_titles` VALUES (4, '#5bc0de', '我的33333', 2);
INSERT INTO `aoa_vote_titles` VALUES (5, '#5bc0de', '你的2222222', 2);
INSERT INTO `aoa_vote_titles` VALUES (6, '#5bc0de', '他的44444', 2);
INSERT INTO `aoa_vote_titles` VALUES (7, '#7589d2', 'fsdfadsf', 3);
INSERT INTO `aoa_vote_titles` VALUES (8, '#292fce', 'fsafas', 3);
INSERT INTO `aoa_vote_titles` VALUES (9, '#5af4a3', 'dfa ', 3);
INSERT INTO `aoa_vote_titles` VALUES (10, '#5bc0de', '他的44444', 3);
INSERT INTO `aoa_vote_titles` VALUES (11, '#8d0282', '多选2 ', 4);
INSERT INTO `aoa_vote_titles` VALUES (12, '#57427f', '多选三', 4);
INSERT INTO `aoa_vote_titles` VALUES (13, '#29bcfc', '多选1', 4);
INSERT INTO `aoa_vote_titles` VALUES (14, '#79d8b7', '去泰国', 5);
INSERT INTO `aoa_vote_titles` VALUES (15, '#4a7647', '哇塞，去香港', 5);
INSERT INTO `aoa_vote_titles` VALUES (16, '#5627a7', '去北京', 5);
INSERT INTO `aoa_vote_titles` VALUES (20, '#6653e0', '222', 7);
INSERT INTO `aoa_vote_titles` VALUES (21, '#af8675', '1111', 7);
INSERT INTO `aoa_vote_titles` VALUES (22, '#4414e5', '333', 7);
INSERT INTO `aoa_vote_titles` VALUES (23, '#9cb08f', '32131', 8);
INSERT INTO `aoa_vote_titles` VALUES (24, '#72e6e2', '31231', 8);
INSERT INTO `aoa_vote_titles` VALUES (25, '#9a46f7', '112312', 8);
INSERT INTO `aoa_vote_titles` VALUES (26, '#8da9b7', '大师傅3', 9);
INSERT INTO `aoa_vote_titles` VALUES (27, '#efe79f', '大师傅', 9);
INSERT INTO `aoa_vote_titles` VALUES (28, '#118a0a', '这是投票4', 10);
INSERT INTO `aoa_vote_titles` VALUES (29, '#1c6035', '这是投票1', 10);
INSERT INTO `aoa_vote_titles` VALUES (30, '#bf617e', '这是投票3', 10);
INSERT INTO `aoa_vote_titles` VALUES (31, '#97dc10', '这是投票2', 10);
INSERT INTO `aoa_vote_titles` VALUES (32, '#b90601', '范德萨', 11);
INSERT INTO `aoa_vote_titles` VALUES (33, '#4c6a51', '电风扇', 11);
INSERT INTO `aoa_vote_titles` VALUES (34, '#4504de', '范德萨', 12);
INSERT INTO `aoa_vote_titles` VALUES (35, '#530145', '地方撒', 12);
INSERT INTO `aoa_vote_titles` VALUES (36, '#ce7d80', '新增的投票标题001', 14);
INSERT INTO `aoa_vote_titles` VALUES (37, '#475906', '第一个投票', 15);
INSERT INTO `aoa_vote_titles` VALUES (38, '#f1b2fe', '第二个投票', 15);
INSERT INTO `aoa_vote_titles` VALUES (39, '#613d2f', '投票1', 16);
INSERT INTO `aoa_vote_titles` VALUES (40, '#515a56', '投票2', 16);
INSERT INTO `aoa_vote_titles` VALUES (41, '#bf65d2', '投票1002', 17);
INSERT INTO `aoa_vote_titles` VALUES (42, '#43c06a', '投票1003', 17);
INSERT INTO `aoa_vote_titles` VALUES (43, '#c00ded', '朱丽叶', 18);
INSERT INTO `aoa_vote_titles` VALUES (44, '#c35d2f', '罗密欧', 18);
INSERT INTO `aoa_vote_titles` VALUES (45, '#d3da1f', '伊丽莎白', 19);
INSERT INTO `aoa_vote_titles` VALUES (46, '#1bb193', '朱丽叶', 19);
INSERT INTO `aoa_vote_titles` VALUES (47, '#c5f573', '第二次多选投票01', 20);
INSERT INTO `aoa_vote_titles` VALUES (48, '#15e62d', '第二次多选投2', 20);
INSERT INTO `aoa_vote_titles` VALUES (49, '#5647f3', '伊丽莎白001', 21);
INSERT INTO `aoa_vote_titles` VALUES (50, '#cfe9d7', '伊丽莎白002', 21);
INSERT INTO `aoa_vote_titles` VALUES (51, '#efcd3a', '伊丽莎白投票999', 22);
INSERT INTO `aoa_vote_titles` VALUES (52, '#a738e1', '伊丽莎白投票998', 22);
INSERT INTO `aoa_vote_titles` VALUES (53, '#5d9ecc', '伊丽莎白投票997', 22);
INSERT INTO `aoa_vote_titles` VALUES (54, '#c3c7d6', '伊丽莎白的投票888', 23);
INSERT INTO `aoa_vote_titles` VALUES (55, '#27ed78', '伊丽莎白的投票887', 23);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
