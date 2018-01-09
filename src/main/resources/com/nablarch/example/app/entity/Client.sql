-------------------------------------------------------------------------------
-- 顧客名、業種による検索
-------------------------------------------------------------------------------
SEARCH_CLIENT =
SELECT
    CLIENT_NUM,
    CLIENT_NAME,
    INDUSTRY_CODE
FROM
    CLIENT
WHERE
     $if (clientName) {CLIENT_NAME LIKE :%clientName%}
     AND $if (industryCode) {INDUSTRY_CODE = :industryCode}
$sort(sortId) {
    (clientIdAsc CLIENT_NUM)
    (clientIdDesc CLIENT_NUM DESC)
    (clientNameAsc CLIENT_NAME, CLIENT_NUM)
    (clientNameDesc CLIENT_NAME DESC, CLIENT_NUM DESC)
}

FIND_BY_CLIENT_ID =
SELECT
    CLIENT_NUM,
    CLIENT_NAME,
    INDUSTRY_CODE
FROM
    CLIENT
WHERE
    CLIENT_NUM = :clientNum
