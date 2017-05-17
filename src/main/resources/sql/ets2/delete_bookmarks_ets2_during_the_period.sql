DELETE FROM `secretary`.`etl_bookmark_new_workers`
WHERE
    etl_key LIKE '%.tar.gz%'
	    AND
	SUBSTRING(`etl_key`, -26, 10) >= :first
	    AND
	SUBSTRING(`etl_key`, -26, 10) <= :last
