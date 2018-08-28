(ns scramblies-ui.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :include-macros true]
            [accountant.core :as accountant]))

(defonce string1 (atom ""))
(defonce string2 (atom ""))
;; -------------------------
;; Views

(defn home-page []
  [:div
   [:h2 "Scramblies"]
   [:div "string 1"
    [:input {:type "text"
             :value @string1
             :on-change #(reset! string1 (-> % .-target .-value))}]]
   [:div "string 2"
    [:input {:type "text"
             :value @string2
             :on-change #(reset! string2 (-> % .-target .-value))}]]
   [:input {:type "button" :value "Click me!"
            :on-click #(println "click")}]])

;; -------------------------
;; Routes

(defonce page (atom #'home-page))

(defn current-page []
  [:div [@page]])

(secretary/defroute "/" []
  (reset! page #'home-page))

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (secretary/dispatch! path))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
