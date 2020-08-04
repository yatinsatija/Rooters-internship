from inventory_app.models import RouteScheduleModel
from rest_framework import serializers


class RouteScheduleEditSerializer(serializers.ModelSerializer):
    class Meta:
        model = RouteScheduleModel
        exclude = ['route_schedule_id']


class RouteScheduleListSerializer(serializers.ModelSerializer):
    class Meta:
        model = RouteScheduleModel
        fields = '__all__'

