(ns scramblies-ui.prod
  (:require [scramblies-ui.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
