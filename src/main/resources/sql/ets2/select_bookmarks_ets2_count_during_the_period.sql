SELECT
	SUBSTRING(`etl_key`, -26, 10) AS `date`,
	COUNT(*) AS `count`,
	'ETS2' AS `ets_source`
FROM `secretary`.`etl_bookmark_new_workers`
	WHERE 1
AND
	etl_key LIKE '%.tar.gz%'
AND
	SUBSTRING(`etl_key`, -26, 10) >= :first
AND
	SUBSTRING(`etl_key`, -26, 10) <= :last
GROUP BY `date`
ORDER BY `date`
LIMIT :offset, :limit
