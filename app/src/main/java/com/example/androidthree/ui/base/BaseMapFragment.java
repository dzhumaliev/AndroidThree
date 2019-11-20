package com.example.androidthree.ui.base;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidthree.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.LocationComponentOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.util.List;

import butterknife.BindView;

import static com.example.androidthree.BuildConfig.MAPBOX_KEY;

public abstract class BaseMapFragment extends BaseFragment implements OnMapReadyCallback, PermissionsListener, MapboxMap.OnMapClickListener {


    private LocationComponent locationComponent;
    private PermissionsManager permissionsManager;
    private MapboxMap map;
    private LatLng currentPosition = new LatLng();
    private GeoJsonSource geoJsonSource;
    private ValueAnimator animator;
    private FusedLocationProviderClient fusedLocationClient;



    //    инициализация карты
    @BindView(R.id.mapView)
    MapView mapView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(requireContext(),
                MAPBOX_KEY);
        Mapbox.getInstance(getContext(), MAPBOX_KEY);


    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView.getMapAsync(this);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {
            map = mapboxMap;
            mapboxMap.addOnMapClickListener(BaseMapFragment.this);


            enableLocationComponent(map.getStyle());

            geoJsonSource = new GeoJsonSource("source-id",
                    Feature.fromGeometry(Point.fromLngLat(currentPosition.getLongitude(),
                            currentPosition.getLatitude())));

            style.addImage(("marker_icon"), BitmapFactory.decodeResource(
                    getResources(), R.drawable.ic_map_marker));



            style.addSource(geoJsonSource);

            style.addLayer(new SymbolLayer("layer-id", "source-id")
                    .withProperties(
                            PropertyFactory.iconImage("marker_icon"),
                            PropertyFactory.iconIgnorePlacement(true),
                            PropertyFactory.iconAllowOverlap(true)
                    ));

            mapboxMap.addOnMapClickListener(BaseMapFragment.this);

//            map.animateCamera(new CameraUpdateFactory().newLatLng
//                    (new LatLng(currentPosition.getLatitude(), currentPosition.getLongitude())), 2000);

            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(getActivity(), location -> {
                        cameraUpdate();
                        if (location != null) {
                        }
                    });
        });
    }

    public void cameraUpdate(){
//        CameraPosition position = new CameraPosition.Builder()
//                .target() // Sets the new camera position
//                .zoom(17) // Sets the zoom
//                .bearing(180) // Rotate the camera
//                .tilt(30) // Set the camera tilt
//                .build(); // Creates a CameraPosition from the builder
//
//        map.animateCamera(CameraUpdateFactory
//                .newCameraPosition(position), 7000);

    }


    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) enableLocationComponent(map.getStyle());
    }


    private void enableLocationComponent(Style style) {
        if (PermissionsManager.areLocationPermissionsGranted(requireContext())) {
            LocationComponentOptions customLocationComponentOptions = LocationComponentOptions.builder(requireContext())
                    .elevation(5)
                    .accuracyAlpha(.6f)
                    .accuracyColor(Color.BLUE)
                    .build();

            locationComponent = map.getLocationComponent();

            LocationComponentActivationOptions locationComponentActivationOptions =
                    LocationComponentActivationOptions.builder(requireContext(), style)
                            .locationComponentOptions(customLocationComponentOptions)
                            .build();
//            map.animateCamera(CameraUpdateFactory
//                    .newCameraPosition(new CameraPosition.Builder()
//                            .zoom(50)
//                            .build()), 2000);



            locationComponent.activateLocationComponent(locationComponentActivationOptions);

            locationComponent.setLocationComponentEnabled(true);

            locationComponent.setRenderMode(RenderMode.NORMAL);

            locationComponent.setCameraMode(CameraMode.TRACKING_COMPASS);

            locationComponent.setCameraMode(CameraMode.TRACKING_GPS_NORTH);



        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(getActivity());

        }
    }




    @Override
    public boolean onMapClick(@NonNull LatLng point) {


        if (animator != null && animator.isStarted()) {
            currentPosition = (LatLng) animator.getAnimatedValue();
            animator.cancel();
        }

        animator = ObjectAnimator
                .ofObject(latLngEvaluator, currentPosition, point)
                .setDuration(1500);
        animator.addUpdateListener(animatorUpdateListener);
        animator.start();

        currentPosition = point;


        CameraPosition position = new CameraPosition.Builder()
                .target(currentPosition) // Sets the new camera position
                .zoom(17) // Sets the zoom
                .bearing(180) // Rotate the camera
                .tilt(30) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        map.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), 7000);

        return true;
    }

    private final ValueAnimator.AnimatorUpdateListener animatorUpdateListener =
            new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LatLng animatedPosition = (LatLng) valueAnimator.getAnimatedValue();
                    geoJsonSource.setGeoJson(Point.fromLngLat(animatedPosition.getLongitude(), animatedPosition.getLatitude()));
                }
            };

    // Class is used to interpolate the marker animation.
    private static final TypeEvaluator<LatLng> latLngEvaluator = new TypeEvaluator<LatLng>() {

        private final LatLng latLng = new LatLng();

        @Override
        public LatLng evaluate(float fraction, LatLng startValue, LatLng endValue) {
            latLng.setLatitude(startValue.getLatitude()
                    + ((endValue.getLatitude() - startValue.getLatitude()) * fraction));
            latLng.setLongitude(startValue.getLongitude()
                    + ((endValue.getLongitude() - startValue.getLongitude()) * fraction));
            return latLng;
        }
    };



    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected int getViewLayout() {
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mapView.onDestroy();

    }


}
