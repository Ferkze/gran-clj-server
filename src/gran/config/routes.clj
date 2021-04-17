(ns gran.config.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [gran.controller.user-controller :as user-ctrl]))


(defroutes routes-config
  (GET "/" [] user-ctrl/request-example)
  (GET "/hello" [] user-ctrl/hello-name)
  (GET "/users" [] user-ctrl/get-users-handler)
  (GET "/users/add" [] user-ctrl/add-user-handler)
  (route/not-found "Not Found"))

(def app-routes
  (wrap-defaults routes-config site-defaults))