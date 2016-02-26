package com.myjeeva.digitalocean;

/**
 * Created by klynch on 2/24/2016.
 */
import com.myjeeva.digitalocean.exception.DigitalOceanException;
import com.myjeeva.digitalocean.exception.RequestUnsuccessfulException;
import com.myjeeva.digitalocean.impl.DigitalOceanClient;
import com.myjeeva.digitalocean.pojo.Account;
import com.myjeeva.digitalocean.pojo.Droplet;
import com.myjeeva.digitalocean.pojo.Droplets;

import java.util.List;


public class klCient1 {
    public static void main(String[] args){

        String opp = null;

        // Testing the Intellij git commit



        if(args.length > 0){
            opp = args[0];
        }
        System.out.println("Starting klClient1");
        String authToken = "3d78e98dc69e9f975c4f0ab05554d9bde431fc91e24058645269470133b2f6a4";
        DigitalOcean apiClient = new DigitalOceanClient(authToken);

        if(apiClient != null) {

            Droplets droplets = null;
            try {
                droplets = apiClient.getAvailableDroplets(0, 10);
            }
            catch(DigitalOceanException ex){

            }
            catch(RequestUnsuccessfulException ex) {
            }


            if(opp != null) {
                switch (opp) {
                    case "user":
                        try {
                            Account acc = apiClient.getAccountInfo();
                            if (acc != null)
                                System.out.println("User email = " + acc.getEmail());
                                System.out.println("Email Verified = " + acc.isEmailVerified());
                                System.out.println("Droplet Limit = " + acc.getDropletLimit());
                                System.out.println("Floating IP Limit = " + acc.getFloatingIPLimit());
                                System.out.println("UUID = " + acc.getUuid());
                                System.out.println("Status  = " + acc.getStatus());
                                System.out.println("Status Msg = " + acc.getStatusMessage());

                        } catch (DigitalOceanException doe) {

                        } catch (RequestUnsuccessfulException rue) {
                        }
                        break;
                    case "droplets":
                    default: {
                        for (Droplet d : droplets.getDroplets()) {
                            listDroplet(d);
                        }
                    }
                }
            }
            else{
                for (Droplet d : droplets.getDroplets()) {
                    listDroplet(d);
                }
            }
        }

        System.out.println("Done klClient1");
    }

    public static void listDroplet(Droplet d){
        List<String> features;
        System.out.println("name = " + d.getName());
        System.out.println("Size = " + d.getSize());
        System.out.println("UserData = " + d.getUserData());
        System.out.println("Created = " + d.getCreatedDate());
        System.out.println("Disk = " + d.getDiskSize());
        System.out.println("Rate Limit = " + d.getRateLimit());
        System.out.println("is Backup Enabled = " + d.getEnableBackup());
        System.out.println("is IPV5 Enabled = " + d.getEnableIpv6());
        System.out.println("Private Networking = " + d.getEnablePrivateNetworking());

        features = d.getFeatures();
        if(features != null) {
            for (String s : features) {
                System.out.println("Feature = " + d.getFeatures());
            }
        }
        System.out.println("Id = " + d.getId());
        System.out.println("Image = " + d.getImage());
        System.out.println("Kernel = " + d.getKernel());
        //List<String>
        //System.out.println("Droplet name = " + d.getKeys());
        System.out.println("Memory = " + d.getMemorySizeInMb());
        //List<String>
        //System.out.println("Droplet name = " + d.getNames());
        System.out.println("Networks = " + d.getNetworks());
        System.out.println("Region = " + d.getRegion());
        System.out.println("SnapshotIds = " + d.getSnapshotIds());
        System.out.println("Status = " + d.getStatus());
        System.out.println("Virtual CPUs = " + d.getVirutalCpuCount());
        System.out.println("is Active = " + d.isActive());
        System.out.println("is Archived = " + d.isArchived());
        System.out.println("is Locked = " + d.isLocked());
        System.out.println("is New = " + d.isNew());
        System.out.println("is Off = " + d.isOff());

    }
}

