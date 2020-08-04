from rest_framework import serializers
from inventory_app.models import BusConfigModel


class BusConfigEditSerializer(serializers.ModelSerializer):
    class Meta:
        model = BusConfigModel
        exclude = ['bus_config_id']


class BusConfigListSerializer(serializers.ModelSerializer):
    class Meta:
        model = BusConfigModel
        fields = '__all__'
