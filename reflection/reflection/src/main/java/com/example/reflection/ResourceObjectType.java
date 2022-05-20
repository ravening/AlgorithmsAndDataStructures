package com.example.reflection;

import java.util.HashMap;
import java.util.Map;

public enum ResourceObjectType {
    UserVm(true, true, true),
        Template(true, true, true),
        ISO(true, false, true),
        Volume(true, true),
        Snapshot(true, false),
        Backup(true, false),
        Network(true, true, true),
        Nic(false, true),
        LoadBalancer(true, true),
        PortForwardingRule(true, true),
        FirewallRule(true, true),
        SecurityGroup(true, false),
        SecurityGroupRule(true, false),
        PublicIpAddress(true, true),
        Project(true, false, true),
        Account(true, false, true),
        Vpc(true, true, true),
        NetworkACL(true, true),
        StaticRoute(true, false),
        VMSnapshot(true, false),
        RemoteAccessVpn(true, true),
        Zone(false, true, true),
        ServiceOffering(false, true),
        Storage(false, true),
        PrivateGateway(false, true),
        NetworkACLList(false, true),
        VpnGateway(false, true),
        CustomerGateway(false, true),
        VpnConnection(false, true),
        User(true, true, true),
        DiskOffering(false, true),
        AutoScaleVmProfile(false, true),
        AutoScaleVmGroup(false, true),
        LBStickinessPolicy(false, true),
        LBHealthCheckPolicy(false, true),
        SnapshotPolicy(true, true),
        GuestOs(false, true),
        NetworkOffering(false, true),
        VpcOffering(true, false),
        Domain(false, false, true);
        ResourceObjectType(boolean resourceTagsSupport, boolean resourceMetadataSupport) {
            this.resourceTagsSupport = resourceTagsSupport;
            metadataSupport = resourceMetadataSupport;
        }
        ResourceObjectType(boolean resourceTagsSupport, boolean resourceMetadataSupport, boolean resourceIconSupport) {
            this(resourceTagsSupport, resourceMetadataSupport);
            this.resourceIconSupport = resourceIconSupport;
        }
        private final boolean resourceTagsSupport;
        private final boolean metadataSupport;
        private boolean resourceIconSupport;
        private static final Map<String, ResourceObjectType> resourceObjectTypeMap = new HashMap<>();

        public boolean resourceTagsSupport() {
            return resourceTagsSupport;
        }
        public boolean resourceMetadataSupport() {
            return metadataSupport;
        }
        public boolean resourceIconSupport() {
            return resourceIconSupport;
        }


        public static ResourceObjectType getResourceObjectType(String type) {
            return resourceObjectTypeMap.getOrDefault(type.toLowerCase(), null);
        }
    
    static {
        for (var value : ResourceObjectType.values()) {
            resourceObjectTypeMap.put(value.toString().toLowerCase(), value);
        }
    }
}
