(ns scramblies-ui.view
  (:require [scramblies-ui.api   :as api]
            [scramblies-ui.atoms :as atoms]))

(defn home-page []
  [:div
   [:h2 "Scramblies"]
   [:p "Scramblies checks if it is possible to make string2 from the characters contained in string 1"]
   [:div
    [:label "string 1 "]
    [:input {:type "text"
             :value @atoms/string1
             :on-change #(reset! atoms/string1 (-> % .-target .-value))}]]
   [:div
    [:label "string 2 "]
    [:input {:type "text"
             :value @atoms/string2
             :on-change #(reset! atoms/string2 (-> % .-target .-value))}]]
   [:input {:type "button" :value "Check"
            :on-click #(api/check @atoms/string1 @atoms/string2)}]
   [:p (str @atoms/result)]])
