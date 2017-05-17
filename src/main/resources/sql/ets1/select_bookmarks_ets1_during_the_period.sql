SELECT * FROM `secretary`.`etl_bookmark_new_workers` AS `a`
JOIN (
SELECT etl_key as `key` FROM `secretary`.`etl_bookmark_new_workers`
    WHERE
	    etl_key LIKE '%.csv.gz%'
		    AND
	    SUBSTRING(`etl_key`, -21, 8) >= :first
		    AND
	    SUBSTRING(`etl_key`, -21, 8) <= :last
    limit :offset, :limit
) AS `b` ON a.etl_key = b.key
ORDER BY `etl_key`
