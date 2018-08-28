(ns scramblies-ui.api
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require        [cljs-http.client       :as http]
                   [cljs.core.async        :refer [<!]]
                   [scramblies-ui.atoms    :as atoms]))

(defn check [str1 str2]
  (go (let [response (<!
                       (http/get
                         (str "http://localhost:3000/api/scramblies/" str1 "/" str2)
                         {:with-credentials? false}))]
        (prn (:status response))
        (reset! atoms/result  (str "\""
                                   str1
                                   (if (:body response)
                                     "\" contains \""
                                     "\" does NOT contain \"")
                                   str2
                                   "\"")))))
