DROP view view_box_size
CREATE VIEW view_box_size	 AS
SELECT DISTINCT
	locker_charge_standard.id,
	locker_box.cabinet_id cabinet_id,
	locker_box.box_size_id box_size_id,
	sys_dictionary.`code`,
	sys_dictionary.`name`,
	locker_charge_standard.price,
	sys_dictionary.description
FROM
	locker_box_charge_standard
INNER JOIN locker_box ON locker_box.id = locker_box_charge_standard.box_id
INNER JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id
INNER JOIN locker_charge_standard ON locker_charge_standard.id = locker_box_charge_standard.charge_standard_id
INNER JOIN sys_dictionary ON locker_box.box_size_id = sys_dictionary.id
GROUP BY locker_charge_standard.id
UNION

SELECT
	locker_charge_standard.id,
	locker_box.cabinet_id cabinet_id,
	locker_box.box_size_id box_size_id,
	sys_dictionary.`code`,
	sys_dictionary.`name`,
	locker_charge_standard.price,
	sys_dictionary.description
from locker_box
INNER JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id
INNER JOIN sys_dictionary ON locker_box.box_size_id = sys_dictionary.id
INNER JOIN locker_charge_standard ON  locker_charge_standard.default_box_size = locker_box.box_size_id
WHERE locker_box.id NOT in (select box_id from locker_box_charge_standard)