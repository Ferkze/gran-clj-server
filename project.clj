(defproject gran "0.1.0-SNAPSHOT"
  :description "Gran Server"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.2"]
                 [ring/ring-defaults "0.3.2"]
                 [org.clojure/data.json "2.0.2"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler gran.handler/app
         :auto-reload? true}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
