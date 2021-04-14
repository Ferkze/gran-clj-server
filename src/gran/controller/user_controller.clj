(ns gran.controller.user-controller
  (:require [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]))

(def users-collection (atom []))

(defn add-user
  "Add user fn"
  [firstname surname]
  (swap! users-collection conj {:firstname (str/capitalize firstname)
                                :surname (str/capitalize surname)}))

(add-user "Functional" "Humnan")
(add-user "Mickey" "Mouse")

(defn get-users-handler
  "Get users request handler"
  [req]
  {:status 200
   :headers {"Content-Type" "text/json"}
   :body    (str (json/write-str @users-collection))})

(defn add-user-handler
  "Add user request handler"
  [req]
  {:status 200
   :headers {"Content-Type" "text/json"}
   :body    (-> (

                  ))})

(defn simple-body-page [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello World"})

(defn request-example
  "Example request controller"
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (->>
           (pp/pprint req)
           (str "Request Object: " req))})

(defn hello-name [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (->
              (pp/pprint req)
              (str "Hello " (-> req :params :name)))})