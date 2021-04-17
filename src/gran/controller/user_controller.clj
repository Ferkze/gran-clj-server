(ns gran.controller.user-controller
  (:require [clojure.pprint :as pp]
            [clojure.data.json :as json]
            [gran.services.user-service :as user-srv]))

(defn get-req-param
  "Get string parameter from ring request"
  [req param]
  (get (:params req) param))

(defn get-users-handler
  "Get users request handler"
  [_]
  {:status 200
   :headers {"Content-Type" "text/json"}
   :body    (str (json/write-str (user-srv/get-users)))})

(defn add-user-handler
  "Add user request handler"
  [req]
  {:status 200
   :headers {"Content-Type" "text/json"}
   :body    (-> (let [p (partial get-req-param req)]
                  (str (json/write-str (user-srv/add-user (p :firstname) (p :surname))))))})


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