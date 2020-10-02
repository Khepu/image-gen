(ns image-gen.db-info
  (:use [korma.db]
        [korma.core]))

(defdb exam-db (mysql {:db "sales"
                       :user "root"
                       :password ""}))

(defentity data)

