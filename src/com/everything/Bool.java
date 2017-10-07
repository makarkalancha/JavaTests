package com.everything;

/**
 * User: Makar Kalancha
 * Date: 11/12/13
 * Time: 2:26 PM
 */
public class Bool {
    public static void main(String[] args) {

        int lastSyncDt = 1387310143;
        int updateDt = 1387310280;
        int deleteDt = 0;
        int createDt = 1387307956;

//        System.out.println("(lastSyncDt >= deleteDt) && (lastSyncDt >= createDt) && (lastSyncDt >= updateDt);");
//        System.out.println((lastSyncDt >= deleteDt) && (lastSyncDt >= createDt) && (lastSyncDt >= updateDt));

        System.out.println("(lastSyncDt >= deleteDt) && (lastSyncDt >= createDt) && (lastSyncDt >= updateDt)");
        System.out.println((lastSyncDt >= deleteDt) && (lastSyncDt >= createDt) && (lastSyncDt >= updateDt));


        String[] except = {"_v1","_v2"};
        String[] foreignKeys = {"adsf_v1","adsf_v1","adsf_v2","adsf","adsf","adsf","adsf","adsf","adsf"};
        Product[] products = new Product[foreignKeys.length];
        for(int i = 0 ; i < products.length;i++){
            Product pr = new Product();
            pr.type = foreignKeys[i];
            products[i] = pr;
        }
        for(Product pr : products){
            System.out.println("fk:"+pr.type+"; canPurge:"+canPurgeProduct(pr,except));
        }
    }



    private static boolean canPurgeProduct(Product product, String[] _exceptSuffix)
    {
//        return !product.type.endsWith(_exceptSuffix);
        for(String exceptSuffix : _exceptSuffix){
            if(product.type.endsWith(exceptSuffix)) {
                return false;
            }
        }
        return true;
    }

    private static class Product{
        public String type;
    }
}
