SELECT
	DATE_FORMAT(SUBSTRING(`etl_key`, -21, 8), '%Y-%m-%d') AS `date`,
	COUNT(*) AS `count`,
	'ETS1' AS `ets_source`
FROM `secretary`.`etl_bookmark_new_workers`
WHERE
	etl_key LIKE '%.csv.gz%'
        AND
	SUBSTRING(`etl_key`, -21, 8) >= :first
        AND
	SUBSTRING(`etl_key`, -21, 8) <= :last
GROUP BY `date`
ORDER BY `date`
LIMIT :offset, :limit
