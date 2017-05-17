SELECT * FROM `secretary`.`etl_bookmark_new_workers` AS `a`
JOIN (
SELECT etl_key as `key` FROM `secretary`.`etl_bookmark_new_workers`
    WHERE
	    etl_key LIKE '%.tar.gz%'
		    AND
	    SUBSTRING(`etl_key`, -26, 10) >= :first
		    AND
	    SUBSTRING(`etl_key`, -26, 10) <= :last
    limit :offset, :limit
) AS `b` ON a.etl_key = b.key
ORDER BY `etl_key`
