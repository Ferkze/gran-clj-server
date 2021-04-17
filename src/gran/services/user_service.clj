(ns gran.services.user-service
  (:require [clojure.string :as str]))

(def users-collection (atom []))

(defn add-user [firstname surname]
  (swap! users-collection conj {:firstname (str/capitalize firstname)
                                :surname (str/capitalize surname)}))

(defn get-users []
  (@users-collection))

(add-user "Functional" "Humnan")
(add-user "Mickey" "Mouse")