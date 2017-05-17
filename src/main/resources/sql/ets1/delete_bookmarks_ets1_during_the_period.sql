DELETE FROM `secretary`.`etl_bookmark_new_workers`
WHERE
    etl_key LIKE '%.csv.gz%'
        AND
    SUBSTRING(`etl_key`, -21, 8) >= :first
        AND
	SUBSTRING(`etl_key`, -21, 8) <= :last
